/*
 * -------------------------------------------------------------------------
 *
 * (C) Copyright / American Express, Inc. All rights reserved.
 * The contents of this file represent American Express trade secrets and
 * are confidential. Use outside of American Express is prohibited and in
 * violation of copyright law.
 *
 * -------------------------------------------------------------------------
 */

package com.mockservice.processor;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlImporter;
import com.eviware.soapui.model.iface.Operation;
import com.mockservice.domain.MockAppContext;
import com.mockservice.domain.Service;
import com.mockservice.domain.ServiceFactory;
import com.mockservice.domain.OperationUnit;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * MockServiceImportProcessor
 *
 * @author shegde6
 * @version $Id$
 */
public class MockServiceImportProcessor implements BaseMockServiceProcessor {
	public void process(MockAppContext ctx)
	{
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		System.out.println("#### $$$$The service name is "+ctx.getServiceName());
		System.out.println("#### $$$$The wsdl URL is "+ctx.getServiceURL());
		try
		{
			WsdlProject project = new WsdlProject();//Need to check what wsdl project is all about
			WsdlInterface[] wsdls = WsdlImporter.importWsdl(project, ctx.getServiceURL());
			
			WsdlInterface wsdl = wsdls[0];
			Service service = new Service();
			service.setServiceName(ctx.getServiceName());
			service.setWsdlURL(ctx.getServiceURL());
			List<OperationUnit> operationList = new ArrayList<OperationUnit>();
			for (Operation operation : wsdl.getOperationList()) {
				OperationUnit opr = new OperationUnit(); 
				List<String> elementList = new ArrayList<String>();
				WsdlOperation op = (WsdlOperation) operation;
				opr.setName(op.getName());
				opr.setRootElement(op.getRequestBodyElementQName().getLocalPart());
				opr.setDefaultGenRequest(op.createRequest(true));
				opr.setDefaultGenResponse(op.createResponse(true));
				System.out.println("OP Name:"+op.getName());
				System.out.println("Root Element Name"+op.getRequestBodyElementQName().getLocalPart());
				System.out.println("Request Below : ----->");
				System.out.println(op.createRequest(true));
				System.out.println("Response Below : ----->");
				System.out.println(op.createResponse(true));
				SOAPMessage msg = MessageFactory.newInstance().createMessage(null, new ByteArrayInputStream((op.createRequest(true)).getBytes()));
				Node node = msg.getSOAPBody();
				appendElements(node,elementList);
				for(String i:elementList)
				{
					System.out.println("###### Lising the elements #####"+i);
				}
				opr.setKeyElements(elementList);
				operationList.add(opr);
        }
		service.setOperationList(operationList);	
        serviceFactory.updateServiceMap(ctx.getServiceName(), service);
		}catch(Exception ex)
		{
			System.out.println(" The exception is "+ex.getMessage());
			ex.printStackTrace();
		}
		
	}
	public void appendElements(Node n, List<String> elements)
	{
		NodeList nl = n.getChildNodes();
		for(int i = 0; i < nl.getLength(); i++)
        {
			n = nl.item(i);
            if(n.getNodeType() != 1)
            {
                continue;
            }
            if(hasChild(n))
            {
            	appendElements(n, elements);
                continue;
            }
            if(!elements.contains(n.getLocalName()))
            {
                elements.add(n.getLocalName());
            }
        }
	}
	private static boolean hasChild(Node n)
    {
        NodeList nl = n.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++)
        {
            n = nl.item(i);
            if(n.getNodeType() == 1)
            {
                return true;
            }
        }

        return false;
    }

}
