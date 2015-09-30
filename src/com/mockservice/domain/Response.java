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

/**
 * response
 *
 * @author shegde6
 * @version $Id$
 */
public class Response implements Serializable{

	private static final long serialVersionUID = -8470979425603908705L;
	private String key;
	
	private String response;
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getResponse() {
		return response;
	}
	
}
