<%@ page contentType="text/html; charset=utf-8"%><body bgcolor='#EEEEEE' leftmargin="0" topmargin="0" style="width: 100%; border-width=0; border-style:none"><marquee style="WIDTH: 388px; HEIGHT: 200px" scrollamount="2" direction="up" ><%
//create by wzw
String type = request.getParameter("type");
System.out.println("type======"+type);
if("stabar".equals(type)){//状态栏广告区广告
	out.print("<a href='http://www.zhongyi360.cn'><FONT SIZE='2px'>cfs12儿童咳嗽中药调理</FONT></a>");
}else if("awkmsg".equals(type)){//弹出式提醒窗口区广告
	out.print("<a href='http://www.baidu.com'><FONT SIZE='2px'>cfd2春夏季预防感冒</FONT></a>");
}else{//其他默认广告
	out.print("<a href='http://www.baidu.com' target='_blank'><FONT SIZE='2px'>d春夏季预防感冒</FONT></a>");
}
%></marquee></body>