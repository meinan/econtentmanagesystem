package com.kingcore.cms.action.directive;

import static com.kingcore.cms.Constants.TPL_STYLE_LIST;
import static com.kingcore.cms.Constants.TPL_SUFFIX;
import static com.kingcore.cms.web.FrontUtils.PARAM_STYLE_LIST;
import static com.kingcore.common.web.Constants.UTF8;
import static com.kingcore.common.web.freemarker.DirectiveUtils.OUT_PAGINATION;
import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.kingcore.cms.action.directive.abs.AbstractChannelDirective;
import com.kingcore.cms.entity.main.CmsSite;
import com.kingcore.cms.web.FrontUtils;
import com.kingcore.common.page.Pagination;
import com.kingcore.common.web.freemarker.DirectiveUtils;
import com.kingcore.common.web.freemarker.ParamsRequiredException;
import com.kingcore.common.web.freemarker.DirectiveUtils.InvokeType;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 栏目分页标签
 * 
 * @author liufang
 * 
 */
public class ChannelPageDirective extends AbstractChannelDirective {
	/**
	 * 模板名称
	 */
	public static final String TPL_NAME = "channel_page";

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		CmsSite site = FrontUtils.getSite(env);
		Integer parentId = DirectiveUtils.getInt(PARAM_PARENT_ID, params);
		Integer siteId = DirectiveUtils.getInt(PARAM_SITE_ID, params);
		boolean hasContentOnly = getHasContentOnly(params);

		Pagination page;
		if (parentId != null) {
			page = channelMng.getChildPageForTag(parentId, hasContentOnly,
					FrontUtils.getPageNo(env), FrontUtils.getCount(params));
		} else {
			if (siteId == null) {
				siteId = site.getId();
			}
			page = channelMng.getTopPageForTag(siteId, hasContentOnly,
					FrontUtils.getPageNo(env), FrontUtils.getCount(params));
		}

		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		paramWrap.put(OUT_PAGINATION, DEFAULT_WRAPPER.wrap(page));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		InvokeType type = DirectiveUtils.getInvokeType(params);
		String listStyle = DirectiveUtils.getString(PARAM_STYLE_LIST, params);
		if (InvokeType.sysDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			env.include(TPL_STYLE_LIST + listStyle + TPL_SUFFIX, UTF8, true);
		} else if (InvokeType.userDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			FrontUtils.includeTpl(TPL_STYLE_LIST, site, env);
		} else if (InvokeType.custom == type) {
			FrontUtils.includeTpl(TPL_NAME, site, params, env);
		} else if (InvokeType.body == type) {
			body.render(env.getOut());
		} else {
			throw new RuntimeException("invoke type not handled: " + type);
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
	}
}
