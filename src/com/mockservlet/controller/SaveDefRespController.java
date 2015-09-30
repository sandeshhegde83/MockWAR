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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mockservice.domain.OperationUnit;
import com.mockservice.domain.Service;
import com.mockservice.domain.ServiceFactory;

/**
 * SaveDefRespController
 *
 * @author shegde6
 * @version $Id$
 */
public class SaveDefRespController extends ApplicationController{
	private String EMPTY = "";
	public String performAction(HttpServletRequest request, HttpServletResponse response, String viewType)
	{
		String defaultResponse = request.getParameter("defResp");
		String selectedService = request.getParameter("selectedSvc");
		String selectedOpr = request.getParameter("selectedOpr");
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		Service service = serviceFactory.getServiceMap().get(selectedService);
		for(OperationUnit opr:service.getOperationList())
		{
			if(opr.getName().equalsIgnoreCase(selectedOpr))
			{
				opr.setDefaultGenResponse(defaultResponse);
			}
		}
		serviceFactory.saveMockResponse();
	 return "saveDefResp";	
	}
}
