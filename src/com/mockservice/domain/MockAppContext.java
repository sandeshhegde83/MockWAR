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

package com.mockservice.domain;

/**
 * MockAppContext
 *
 * @author shegde6
 * @version $Id$
 */
public class MockAppContext {
	private String helloString;
	private String serviceName;
	private String serviceURL;
	private String selectedService;
	private String selectedOperation;

	public String getHelloString() {
		return helloString;
	}

	public void setHelloString(String helloString) {
		this.helloString = helloString;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceURL(String serviceURL) {
		this.serviceURL = serviceURL;
	}

	public String getServiceURL() {
		return serviceURL;
	}

	public void setSelectedService(String selectedService) {
		this.selectedService = selectedService;
	}

	public String getSelectedService() {
		return selectedService;
	}

	public void setSelectedOperation(String selectedOperation) {
		this.selectedOperation = selectedOperation;
	}

	public String getSelectedOperation() {
		return selectedOperation;
	}
	
}
