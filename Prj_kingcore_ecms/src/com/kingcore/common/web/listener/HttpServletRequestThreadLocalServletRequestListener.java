/**
 * HttpServletRequestThreadLocalServletRequestListener.java
 * Created date : 2:22:40 PM Mar 8, 2010
 */
package com.kingcore.common.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import com.kingcore.common.bean.RequestBean;
import com.kingcore.common.util.HttpServletRequestThreadLocal;

/**
 * A implementation of {@link ServletRequestListener} for {@link HttpServletRequestThreadLocal}
 * @author mercy
 * @since 
 * @version 2:22:40 PM Mar 8, 2010
 */
public class HttpServletRequestThreadLocalServletRequestListener implements ServletRequestListener {

	/**
	 * A {@link ThreadLocal} for HttpServletRequest.
	 */
	private ThreadLocal<RequestBean> httpServletRequestThreadLocal = HttpServletRequestThreadLocal.getInstance();
	
	/**
	 * Removes the instance of {@link HttpServletRequest}.
	 * @since 
	 * @version 2:22:40 PM Mar 8, 2010
	 * @override
	 * @param sre
	 */
	//@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		httpServletRequestThreadLocal.remove();
	}

	/**
	 * Adds the instance of {@link HttpServletRequest}.
	 * @since 1.65
	 * @version 1.64 2:22:40 PM Mar 8, 2010
	 * @override
	 * @param sre
	 */
	//@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request=(HttpServletRequest)sre.getServletRequest();
		String remoteAddr = request.getRemoteAddr();
		RequestBean reqBean = new RequestBean();
		reqBean.setRemoteAddr(remoteAddr);
		
		httpServletRequestThreadLocal.set(reqBean);
	}

}
