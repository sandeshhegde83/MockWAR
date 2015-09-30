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

import java.io.Serializable;
import java.util.List;

/**
 * Service
 *
 * @author shegde6
 * @version $Id$
 */
public class Service implements Serializable{
	/**
	 TODO: Need to find about serial Id 
	 */
	private static final long serialVersionUID = 7668986290206977651L;
	private String serviceName;
	private String wsdlURL;
	private List<OperationUnit> operationList;
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setWsdlURL(String wsdlURL) {
		this.wsdlURL = wsdlURL;
	}
	public String getWsdlURL() {
		return wsdlURL;
	}
	public void setOperationList(List<OperationUnit> operationList) {
		this.operationList = operationList;
	}
	public List<OperationUnit> getOperationList() {
		return operationList;
	}

}
