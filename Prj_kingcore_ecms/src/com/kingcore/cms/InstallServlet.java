package com.kingcore.cms;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InstallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String dbHost = request.getParameter("dbHost");
		String dbPort = request.getParameter("dbPort");
		String dbName = request.getParameter("dbName");
		String dbUser = request.getParameter("dbUser");
		String dbPassword = request.getParameter("dbPassword");

		String isCreateDb = request.getParameter("isCreateDb");
		String isCreateTable = request.getParameter("isCreateTable");
		String isInitData = request.getParameter("isInitData");
		String isUpdateConf = request.getParameter("isUpdateConf");
		
		String domain = request.getParameter("domain");
		String cxtPath = request.getParameter("cxtPath");
		String port = request.getParameter("port");

		String dbFileName = request.getParameter("dbFileName");
		String initFileName = request.getParameter("initFileName");
		String dbXmlFileName = "/WEB-INF/config/jdbc.properties";
		String webXmlFrom = "/install/config/web.xml";
		String webXmlTo = "/WEB-INF/web.xml";
		String forwardUrl = "/install/addWebSite_success.jspw"; //默认forward
		try {
			// 创建数据库
			if (isCreateDb==null || "true".equals(isCreateDb)) {
				Install.createDb(dbHost, dbPort, dbName, dbUser, dbPassword);
				System.out.println("创建数据库完成!");
			} else {
				Install.changeDbCharset(dbHost, dbPort, dbName, dbUser,
						dbPassword);
			}
			// 创建表
			if (isCreateTable==null || "true".equals(isCreateTable)) {
				String sqlPath = getServletContext().getRealPath(dbFileName);
				List<String> sqlList = Install.readSql(sqlPath);
				Install.createTable(dbHost, dbPort, dbName, dbUser, dbPassword,
						sqlList);
				System.out.println("创建表完成!");
			}
			// 初始化数据
			if (isInitData==null || "true".equals(isInitData)) {
				String initPath = getServletContext().getRealPath(initFileName);
				List<String> initList = Install.readSql(initPath);
				Install.createTable(dbHost, dbPort, dbName, dbUser, dbPassword,
						initList);
				System.out.println("初始化数据完成!");
			}
			//更新系统配置文件
			if(isUpdateConf==null || "true".equals(isUpdateConf)){
				// 更新配置
				Install.updateConfig(dbHost, dbPort, dbName, dbUser, dbPassword,
						domain, cxtPath, port);
				// 处理数据库配置文件
				String dbXmlPath = getServletContext().getRealPath(dbXmlFileName);
				Install
						.dbXml(dbXmlPath, dbHost, dbPort, dbName, dbUser,
								dbPassword);
				// 处理web.xml
				String webXmlFromPath = getServletContext().getRealPath(webXmlFrom);
				String webXmlToPath = getServletContext().getRealPath(webXmlTo);
				Install.webXml(webXmlFromPath, webXmlToPath);
				forwardUrl = "/install/install_success.jspw";
				System.out.println("更新系统配置文件完成!");
			}
		} catch (Exception e) {
			throw new ServletException("install failed!", e);
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher( forwardUrl );
		dispatcher.forward(request, response);
	}
}
