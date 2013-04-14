/**
 * Copyright (C) 2013 ChangSha XNS Science & Technology CO,.LTD. All rights reserved.
 * XNS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * Copyright (C) 2002-2013 WUZEWEN. All rights reserved.
 * WUZEWEN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * This software is the confidential and proprietary information of
 * WuZeven, Personal. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with WuZeven.
 */

package com.kingcore.cms.base.controller;

import java.util.Map;

import com.kingcore.cms.entity.main.CmsSite;
import com.kingcore.common.web.freemarker.DirectiveUtils;

import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * <p>java类文件的说明...</p>
 * @author Zeven/wzw on Apr 14, 2013
 * @version	1.0
 * @see		Object#equals(java.lang.Object)
 * @since	JDK5
 */

public class CmsBaseDirective {

	/**
	 * 输入参数，站点ID。
	 */
	public static final String PARAM_SITE_ID = "siteId";

	//mod by wzw
	protected Integer getSiteId(CmsSite site, Map<String, TemplateModel> params)
			throws TemplateException {
		Integer siteId = DirectiveUtils.getInt(PARAM_SITE_ID, params);
		if (siteId == null) {
			siteId = site.getId();
		}
		return siteId;
	}
	
	/**
	 * <p>java方法的说明...</p>
	 * @author Zeven on Apr 14, 2013
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
