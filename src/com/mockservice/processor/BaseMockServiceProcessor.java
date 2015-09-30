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

package com.mockservice.processor;

import com.mockservice.domain.MockAppContext;

/**
 * BaseMockServiceProcessor
 *
 * @author shegde6
 * @version $Id$
 */
public interface BaseMockServiceProcessor {
	public void process(MockAppContext ctx);
}
