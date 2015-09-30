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

package com.mockservice.helper;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;

import com.mockservice.domain.OperationUnit;
import com.mockservice.domain.Response;
import com.mockservice.domain.Service;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * MockServiceHelper
 *
 * @author shegde6
 * @version $Id$
 */
public class MockServiceHelper {
	public String getMockResponse(String soapReq,Service service)
	{
		try
		{
			String operationName = getOperationName(soapReq);
			System.out.println("### Inside class [MockServiceHelper] before getting selected OperationUnit");
			OperationUnit ou = getOperationUnit(operationName,service);
			System.out.println("### Inside class [MockServiceHelper] after getting selected OperationUnit"+ou.getName());
			System.out.println("### Inside class [MockServiceHelper] after getting selected OperationUnit"+ou.getDefaultGenRequest());
			System.out.println("### Key Element Name "+ou.getElementName());
			String keyElemValue = retrieveKeyValue(soapReq,ou.getElementName());
			System.out.println("##### In Class [MockServiceHelper], the keyvalue retrieved from request is "+keyElemValue);
			String soapResp = null;
			if(ou ==null)
			{
				//TODO:throw exception 
			}
			if(ou.getElementName()==null)
			{
				//IF KEY ELEMENT DOES NOT EXIST RETURN DEFAULT RESPONSE
				return ou.getDefaultGenResponse();
			}
			else if(checkKeyElementExists(ou,keyElemValue))
			{
				soapResp = retrieveRespKeyElement(ou,keyElemValue);
				return soapResp;
			}
			else
			{
				return ou.getDefaultGenResponse();
			}
		
				
		}catch(Exception ex)
		{
			System.out.println("### Printing the exception from methos getMockResponse");
			ex.printStackTrace();
		}
		return null;
		
	}
	public String retrieveRespKeyElement(OperationUnit opr, String keyValue)
	{
		HashMap<String,String> customRespMap = (HashMap<String,String>)opr.getCustomResponseMap();
		String key = opr.getElementName()+":"+keyValue;
		System.out.println("##### In Class [MockServiceHelper], method [retrieveRespKeyElement], the key retrieved is "+key);
		for(Map.Entry<String,String> entry: customRespMap.entrySet())
		{
			System.out.println(" The Key is "+entry.getKey());
			System.out.println(" The value is "+entry.getValue());
		}
		return customRespMap.get(key);
		
	}
	public boolean checkKeyElementExists(OperationUnit ou,String keyValue)
	{
		if (keyValue !=null && keyValue!="")
		{
			if(retrieveRespKeyElement(ou,keyValue)!=null)
			return true;
		}
		return false;		
		
	}
	public String retrieveKeyValue(String req,String elementName)
	{
		int startInd = req.indexOf((new StringBuilder()).append(":").append(elementName).append(">").toString());
        if(startInd == -1)
        {
            startInd = req.indexOf((new StringBuilder()).append("<").append(elementName).append(">").toString());
            if(startInd == -1)
            {
                return null;
            }
        }
        startInd = req.indexOf('>', startInd);
        if(startInd == -1)
        {
            return null;
        }
        int endInd = req.indexOf("</", startInd);
        if(endInd == -1 || endInd <= startInd)
        {
            return null;
        } else
        {
            return req.substring(startInd + 1, endInd);
        } 
	}
	public String getOperationName(String soapRequest) throws Exception
    {
        NodeList nodeList;
        MessageFactory messageFactory;
        if(soapRequest.contains("http://www.w3.org/2003/05/soap-envelope"))
        {
            messageFactory = MessageFactory.newInstance("SOAP 1.2 Protocol");
        } else
        {
            messageFactory = MessageFactory.newInstance();
        }
        //Create SOAP Message
        SOAPMessage message = messageFactory.createMessage(null, new ByteArrayInputStream(soapRequest.getBytes()));
        
        //Retrieve Child elements from SOAP Body
        nodeList = message.getSOAPBody().getChildNodes();
        for(int i = 0; i < nodeList.getLength();)
        {
        	try
            {
        		if(nodeList.item(i).getLocalName() != null)
        		{
            	//First element returned is the operation
                return nodeList.item(i).getLocalName();
        		}
            
                i++;
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.println("####  Printing the exception ##"+e.getMessage());
                
            }
        }

        return null;
    }
	public OperationUnit getOperationUnit(String operationName, Service service)
	{
		for(OperationUnit ou:service.getOperationList())
		{
			//COMPARE WITH THE ROOT ELEMENT OF THE OPERATION UNIT
			if(operationName.equalsIgnoreCase(ou.getRootElement()))
			{
				return ou;
			}
		}
		return null;
	}

}
