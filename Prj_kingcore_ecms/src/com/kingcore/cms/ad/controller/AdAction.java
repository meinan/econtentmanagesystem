package com.kingcore.cms.ad.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kingcore.cms.ad.service.AdService;
import com.kingcore.cms.base.controller.CmsBaseAction;
import com.kingcore.cms.entity.main.Content;



/**
 * <p>java类文件的说明...</p>
 * @author Zeven/wzw on Apr 14, 2013
 * @version	1.0
 * @see		Object#equals(java.lang.Object)
 * @since	JDK5
 */
@Controller
public class AdAction extends CmsBaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(AdAction.class);

	public static final String COOKIE_ERROR_REMAINING = "_error_remaining";

	private static final long Half_Day_Micsecd = 1000*60*60*12L;

	@RequestMapping(value = "/ad/directorAd.jspx", method = RequestMethod.GET)
	public String directorAd(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String type = request.getParameter("type");
		log.debug("type======"+type);
		String adHtmlStr = null;
//		if("stabar".equals(type)){//状态栏广告区广告
//			adHtmlStr = "<a href='http://www.zhongyi360.cn/zybj'><FONT SIZE='2px'>儿童咳嗽中药调理</FONT></a>";
//		}else if("awkmsg".equals(type)){//弹出式提醒窗口区广告
//			adHtmlStr = "<a href='http://www.zhongyi360.cn/zyzl'><FONT SIZE='2px'>春夏季预防感冒</FONT></a>";
//		}else{//其他默认广告
//			adHtmlStr = "<a href='http://www.zhongyi360.cn' target='_blank'><FONT SIZE='2px'>春夏季预防感冒</FONT></a>";
//		}
		List<Content> list = null;
		Object obj = request.getSession().getServletContext().getAttribute("Ad_Content_List");
		Object date = request.getSession().getServletContext().getAttribute("Ad_Content_Time");
		if(obj==null || date==null
				|| (Calendar.getInstance().getTime().getTime()-((Date)date).getTime())> Half_Day_Micsecd ){
			list = adService.getListBySiteIdsForTag(null, null, null, null, //Boolean.FALSE, Boolean.FALSE,
							null, -1, null, 10);
			request.getSession().getServletContext()
				.setAttribute("Ad_Content_List", list );
			request.getSession().getServletContext()
				.setAttribute("Ad_Content_Time", Calendar.getInstance().getTime() );
		}else{
			list = (List<Content>) obj;
		}
		
		Random rad = new Random();
		int random = rad.nextInt(10);//取小于10的正整数
		Content content = list.get(random);
		adHtmlStr = "<a href='"+content.getUrl()+"' title='"
		                         +convert(content.getTitle())+"'><FONT SIZE='2px'>"
								 +convert(content.getTitle())+"</FONT></a>";
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print( adHtmlStr );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
 
	private String convert(String title) {
		return StringUtils.replace(title, "'", "&acute;");
	}

	@Autowired
	private AdService adService;
//	@Autowired
//	private UnifiedUserMng unifiedUserMng; 
}
