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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * operation
 *
 * @author shegde6
 * @version $Id$
 */
public class OperationUnit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2671892489643110108L;
	private String name;
	private String rootElement;
	private String keyElementName;
	private Map<String,String> customResponseMap;
	private String defaultGenRequest;
	private String defaultGenResponse;
	private List keyElements;
	
	public List getKeyElements() {
		return keyElements;
	}
	public void setKeyElements(List keyElements) {
		this.keyElements = keyElements;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setRootElement(String rootElement) {
		this.rootElement = rootElement;
	}
	public String getRootElement() {
		return rootElement;
	}
	public void setElementName(String keyElement) {
		this.keyElementName = keyElement;
	}
	public String getElementName() {
		return keyElementName;
	}
	public void setCustomResponseMap(String key, String value) {
		if(this.customResponseMap == null)
		{
			this.customResponseMap = new HashMap<String,String>();
			this.customResponseMap.put(key, value);
		}	
		else
		{
			this.customResponseMap.put(key, value);
		}
		
	}
	public Map<String,String> getCustomResponseMap() {
		return customResponseMap;
	}
	public void setDefaultGenRequest(String defaultGenRequest) {
		this.defaultGenRequest = defaultGenRequest;
	}
	public String getDefaultGenRequest() {
		return defaultGenRequest;
	}
	public void setDefaultGenResponse(String defaultGenResponse) {
		this.defaultGenResponse = defaultGenResponse;
	}
	public String getDefaultGenResponse() {
		return defaultGenResponse;
	}
}
