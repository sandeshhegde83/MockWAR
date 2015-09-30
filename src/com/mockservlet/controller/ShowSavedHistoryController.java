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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mockservice.domain.OperationUnit;
import com.mockservice.domain.Service;
import com.mockservice.domain.ServiceFactory;

/**
 * ShowSavedHistoryController
 *
 * @author 199283
 * @version $Id$
 */
public class ShowSavedHistoryController extends ApplicationController {
	public String performAction(HttpServletRequest request, HttpServletResponse response, String viewType)
	{
		List<String> responseList = new ArrayList<String>();
		String selectedService = request.getParameter("selectedSvc");
		String selectedOpr = request.getParameter("selectedOpr");
		System.out.println("########## The selected service is "+selectedService);
		System.out.println("########## The selected operation is "+selectedOpr);
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		Service service = serviceFactory.getServiceMap().get(selectedService);
		for(OperationUnit opr:service.getOperationList())
		{
			if(opr.getName().equalsIgnoreCase(selectedOpr))
			{
				for(Map.Entry<String,String> entry : opr.getCustomResponseMap().entrySet())
				{
					responseList.add(entry.getKey());
				}
			
			}
		}
		request.setAttribute("savedResponseHistory", responseList);
		return viewType;
	}
}
