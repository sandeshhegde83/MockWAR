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

import com.fasterxml.jackson.annotation.JsonRawValue;

import org.codehaus.jackson.annotate.JsonValue;
/**
 * CardJson
 *
 * @author 199283
 * @version $Id$
 */
public class CardJson {
	private final String value;

    public CardJson(String value) {
        this.value = value;
    }

    @JsonValue
    @JsonRawValue
    public String getValue() {
        return value;
    }
}
