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

/**
 * CustomRespController
 *
 * @author shegde6
 * @version $Id$
 */
public class CustomRespController extends ApplicationController {
	private String EMPTY = "";
	public String performAction(HttpServletRequest request, HttpServletResponse response, String viewType)
	{
		String selectedService = request.getParameter("svcNM")!=null?request.getParameter("svcNM"):EMPTY;
		String selectedOperation = request.getParameter("oprNM")!=null?request.getParameter("oprNM"):EMPTY;
		
		System.out.println("########  In class [CustomRespController] , method [performAction],  selected service is "+selectedService);
		System.out.println("########  In class [CustomRespController] , method [performAction],  selected Operation is ### "+selectedOperation);
		request.setAttribute("selectedService", selectedService);
		request.setAttribute("selectedOperation", selectedOperation);
		
		return viewType;
		
	}

}
