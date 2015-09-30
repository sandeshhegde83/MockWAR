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

package com.mockservlet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mockservice.domain.MockAppContext;
import com.mockservice.processor.BaseMockServiceProcessor;
import com.mockservice.processor.MockServiceProcessor;

/**
 * ApplicationController
 *
 * @author shegde6
 * @version $Id$
 */
public class ApplicationController {
	
	private String helloString;
	private List<BaseMockServiceProcessor> processors;
	private String EMPTY = "";
	
	public List<BaseMockServiceProcessor> getProcessors() {
		return processors;
	}

	public void setProcessors(List<BaseMockServiceProcessor> processors) {
		this.processors = processors;
	}

	public String performAction(HttpServletRequest request, HttpServletResponse response, String viewType)
	{
		MockAppContext appContext = new MockAppContext();
		populateAppContext(request,appContext);
		for(BaseMockServiceProcessor processor:processors)
		{
			processor.process(appContext);
		}
		//setSessionData(request, appContext);
		return viewType;
	}

	public void setHelloString(String helloString) {
		this.helloString = helloString;
	}

	public String getHelloString() {
		return helloString;
	}
	
	public void setSessionData(HttpServletRequest request,Object sessionObj)
	{
		HttpSession session = request.getSession(true);
		session.setAttribute("mainObj", sessionObj);
		
	}
	public void populateAppContext(HttpServletRequest request,MockAppContext appContext)
	{
		String serviceURL = request.getParameter("serviceurl")!=null?request.getParameter("serviceurl"):EMPTY;
		String serviceName = request.getParameter("servicename")!=null?request.getParameter("servicename"):EMPTY;
		
		appContext.setServiceURL(serviceURL);
		appContext.setServiceName(serviceName);
		
	}
}
