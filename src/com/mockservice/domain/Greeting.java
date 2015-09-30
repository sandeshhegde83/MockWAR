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
 * Greeting
 *
 * @author shegde6
 * @version $Id$
 */
public class Greeting {
	    private final long id;
	    private final String content;

	    public Greeting(long id, String content) {
	        this.id = id;
	        this.content = content;
	    }

	    public long getId() {
	        return id;
	    }

	    public String getContent() {
	        return content;
	    }
}


