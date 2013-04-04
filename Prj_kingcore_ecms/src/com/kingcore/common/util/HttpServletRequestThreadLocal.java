/**
 * HttpServletRequestThreadLocal.java
 * Created date : 2:25:54 PM Mar 8, 2010
 */
package com.kingcore.common.util;

import com.kingcore.common.bean.RequestBean;

/**
 * An implementation class of {@link ThreadLocal} is used to receive the
 * instances of {@link RequestBean} on current thread whatever
 * RequestBean argument exists in Servlet container.
 * 
 * If can't receive the instance of {@link RequestBean}, it is possible
 * that current thread is a sub-thread of RequestBean thread or main
 * thread of Servlet container.
 * 
 * @author mercy
 * @since 1.65
 * @version 1.65 2:25:54 PM Mar 8, 2010
 */
public final class HttpServletRequestThreadLocal extends ThreadLocal<RequestBean> {

	private static final HttpServletRequestThreadLocal instance = new HttpServletRequestThreadLocal();
	
	public static ThreadLocal<RequestBean> getInstance(){
		return instance;
	}
	
	private HttpServletRequestThreadLocal() {
		//NOTHING
	}
	
}
