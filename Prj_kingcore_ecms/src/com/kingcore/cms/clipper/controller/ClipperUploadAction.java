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

package com.kingcore.cms.clipper.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kingcore.cms.base.controller.CmsBaseAction;

/**
 * <p>java类文件的说明...</p>
 * @author Zeven/wzw on Apr 29, 2013
 * @version	1.0
 * @see		Object#equals(java.lang.Object)
 * @since	JDK5
 */
@Controller
@RequestMapping("/clipper")
public class ClipperUploadAction extends CmsBaseAction {

	private final static Logger log = Logger.getLogger(ClipperUploadAction.class);
	
	/**
	 * <p>java方法的说明...</p>
	 * @author Zeven on Apr 29, 2013
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	@RequestMapping(value = "/upload.jspx", method = RequestMethod.POST)  //
	public String upload(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		log.debug("begin save ...");
		
//		response.setCharacterEncoding("gbk");
//		response.getWriter().print("保存成功！");

		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement().toString();
			System.out.println( name );
			System.out.println( request.getParameter( name ) );
		}
		
		try {
			request.getRequestDispatcher( "/clipper/success.jsp" ).forward(request,response);
		} catch (ServletException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return null;
	}

}
