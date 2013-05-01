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

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kingcore.cms.base.controller.CmsBaseAction;
import com.kingcore.cms.clipper.service.ClipperUploadService;
import com.kingcore.cms.entity.main.Channel;
import com.kingcore.cms.entity.main.CmsSite;
import com.kingcore.cms.entity.main.CmsUser;
import com.kingcore.cms.entity.main.Content;
import com.kingcore.cms.entity.main.ContentExt;
import com.kingcore.cms.entity.main.ContentTxt;
import com.kingcore.cms.manager.main.ContentMng;
import com.kingcore.cms.web.CmsUtils;
import com.kingcore.cms.web.WebErrors;
import com.kingcore.common.util.StrUtils;
import com.kingcore.common.web.RequestUtils;
import com.kingcore.common.web.springmvc.MessageResolver;

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

	@Autowired
	private ClipperUploadService clipperUploadService;
	@Autowired
	private ContentMng manager;
	
	/**
	 * <p>java方法的说明...</p>
	 * @author Zeven on Apr 29, 2013
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	@RequestMapping(value = "/openPanel.jspx", method = RequestMethod.POST)  //
	public String openPanel(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		log.debug("begin open ...");

		CmsSite site = CmsUtils.getSite(request);
		//获取栏目列表
		List<Channel> channelList = clipperUploadService.getAllChannelList(site.getId(), true);

		System.out.println(""+  (request.getParameter("title")) );
		model.addAttribute("channelList", channelList);
		request.setAttribute("model", model);
		//转向视图层
		requestForward(request,response,"/clipper/upload.jsp");
		
		return null;
	}


	@RequestMapping(value = "/upload.jspx", method = RequestMethod.POST)  //
	public String upload(Content bean, ContentExt ext, ContentTxt txt,
	Integer[] channelIds, Integer[] topicIds, Integer[] viewGroupIds,
	String[] attachmentPaths, String[] attachmentNames,
	String[] attachmentFilenames, String[] picPaths, String[] picDescs,
	Integer channelId, Integer typeId, String tagStr, Boolean draft,
	Integer cid, HttpServletRequest request, 
	HttpServletResponse response, ModelMap model) {
//		WebErrors errors = validateSave(bean, channelId, request);
//		if (errors.hasErrors()) {
//			return errors.showErrorPage(model);
//		}
		// 加上模板前缀
		CmsSite site = CmsUtils.getSite(request);
		CmsUser user = createAdminUser(); //CmsUtils.getUser(request);
		
		String tplPath = site.getTplPath();
		if (!StringUtils.isBlank(ext.getTplContent())) {
			ext.setTplContent(tplPath + ext.getTplContent());
		}
		bean.setContentExt(ext);
//		bean.setContentTxt(txt);
		bean.setSite(site);
		typeId = 1;//普通
		bean.setAttr(RequestUtils.getRequestMap(request, "attr_"));
		String[] tagArr = null; //StrUtils.splitAndTrim(tagStr, ",", MessageResolver
//				.getMessage(request, "content.tagStr.split"));
		bean = manager.save(bean, ext, txt, channelIds, topicIds, viewGroupIds,
				tagArr, attachmentPaths, attachmentNames, attachmentFilenames,
				picPaths, picDescs, channelId, typeId, draft, user, false);
		log.info("save Content id={}"+bean.getId());
		
		requestForward(request, response, "/clipper/success.jsp");
		
		return null;
	}


	private CmsUser createAdminUser() {
		CmsUser user = new CmsUser();
		user.setAdmin(true);
		user.setId(1);
		user.setUsername("admin"); 
		return user;
	}

}
