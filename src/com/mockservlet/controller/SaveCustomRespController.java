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
 * SaveCustomRespController
 *
 * @author shegde6
 * @version $Id$
 */
public class SaveCustomRespController extends ApplicationController{
	
	public String performAction(HttpServletRequest request, HttpServletResponse response, String viewType)
	{
		String keyElementName = request.getParameter("elementName");
		String keyElementVal = request.getParameter("elementValue");
		String customResp = request.getParameter("customResp");
		String selectedService = request.getParameter("selectedSvc");
		String selectedOpr = request.getParameter("selectedOpr");
		String mapKey = keyElementName+":"+keyElementVal;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		Service service = serviceFactory.getServiceMap().get(selectedService);
		for(OperationUnit opr:service.getOperationList())
		{
			if(opr.getName().equalsIgnoreCase(selectedOpr))
			{
				opr.setElementName(keyElementName);
				opr.setCustomResponseMap(mapKey,customResp);
			}
		}
		serviceFactory.saveMockResponse();
	 return viewType;	
	}

}
