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

package com.kingcore.common.web.listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.kingcore.common.bean.RequestBean;
import com.kingcore.common.util.HttpServletRequestThreadLocal;

/**
 * <p>java类文件的说明...</p>
 * @author Zeven/wzw on Apr 1, 2013
 * @version	1.0
 * @see		Object#equals(java.lang.Object)
 * @since	JDK5
 */

public class CmsSessionListener implements HttpSessionListener {

	/**
	 * A {@link ThreadLocal} for HttpServletRequest.
	 */
	private ThreadLocal<RequestBean> httpServletRequestThreadLocal = HttpServletRequestThreadLocal.getInstance();
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		httpServletRequestThreadLocal.remove();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {

//		arg0.getSession().getServletContext().
//		HttpServletRequest request=(HttpServletRequest)sre.getServletRequest();
//		String remoteAddr = request.getRemoteAddr();
//		RequestBean reqBean = new RequestBean();
//		reqBean.setRemoteAddr(remoteAddr);
//		
//		httpServletRequestThreadLocal.set(reqBean);

	}

	/**
	 * <p>java方法的说明...</p>
	 * @author Zeven on Apr 1, 2013
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
