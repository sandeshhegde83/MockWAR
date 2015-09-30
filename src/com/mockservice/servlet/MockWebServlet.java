package com.mockservice.servlet;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mockservice.domain.Service;
import com.mockservice.domain.ServiceFactory;
import com.mockservice.helper.MockServiceHelper;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class MockWebServiceServlet
 */

public class MockWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MockWebServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("### Inside the service method ###");
		
		
		try
        {
			System.out.println("### Before calling the svcPath ");
            String svcPath = request.getRequestURI().substring((new StringBuilder()).append(request.getContextPath()).append("/serviceName/").toString().length());
            System.out.println("### After calling the svcPath ");
            //String tmps[] = svcPath.split("/");
            System.out.println("### After calling the svcPath Split");
            String serviceName = svcPath;
            System.out.println("### In Class [MockWebServlet] method [service] , the service name is "+serviceName);
            MockServiceHelper mockserviceHelper = new MockServiceHelper(); 
            String soapResp = null;
            String soapReq = "";
            if(svcPath == null || svcPath.length()==0)
            {
            	// TODO Throw a SOAP fault
            } 
            Service service = ServiceFactory.getInstance().getServiceMap().get(serviceName);
            java.io.InputStream is = request.getInputStream();
            soapReq = new String(IOUtils.toByteArray(is));
            //System.out.println("### Printing the soap request ##"+ soapReq);
            String resp = mockserviceHelper.getMockResponse(soapReq, service);
            //System.out.println("### Printing returned response ##"+ resp);
            if(soapReq.contains("http://www.w3.org/2003/05/soap-envelope"))
            {
            	response.setContentType("application/soap+xml");
            } else
            {
            	response.setContentType("text/xml");
            }
            response.getOutputStream().write(resp.getBytes());
            //TODO: Handle fault scenarios
        }
		catch(Throwable ex){
			System.out.println("#### The exception caught is"+ ex.getMessage());
			ex.printStackTrace();
			
		}
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("#### Inside doPost111 ");
	}

}
