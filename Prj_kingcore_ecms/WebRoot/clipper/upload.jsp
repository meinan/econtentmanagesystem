<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>

<html><head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>有道云笔记</title>

    <link type="text/css" rel="stylesheet" href="/clipper/css/web-clipper.css?ver=428648">
    <script type="text/javascript" src="/clipper/js/crossDomain.js"></script>

   <script src="/res/common/js/jquery.js" type="text/javascript"></script>
   <script src="/res/common/js/jquery.ext.js" type="text/javascript"></script>
   <script type="text/javascript" src="/component/jwysiwyg/jquery.wysiwyg.js"></script>
   <link rel="stylesheet" href="/component/jwysiwyg/jquery.wysiwyg.css" type="text/css" />
  
  <script language="javascript">
$(document).ready(function(){ 
	$('#txt').wysiwyg();
});  
        function preSubmit () {
            document.getElementById("sb").disabled = true;
            document.getElementById("cancelbtn").disabled = true;
            var v = document.getElementById("title");
            if (v != null && v.value == "") {
                v.value = "无标题笔记";
            }
            //alert( document.getElementById("bs").value );
            //document.getElementById("content").style.display = "none";
            document.getElementById("loadingview").style.display = "block";

            croDomain.postMessage('remove', 'http://www.zhongyi360.cn/tcmxx/11178.jhtml');
            return true;
         }
</script>
<script type="text/javascript">
        setTimeout(function () {
            croDomain.postMessage('resize_fullpage','http://www.zhongyi360.cn/tcmxx/11178.jhtml');
        }, 101);
        setTimeout(function () {
            croDomain.postMessage('creat', 'http://www.zhongyi360.cn/tcmxx/11178.jhtml');
        }, 202);
</script>
</head>
<body style="border:0px;padding:0px;margin:0px">
<div id="ydNoteWebClipper">
    <div id="ydNoteWebClipper-New">
            <div class="ydnwc-dialog-hd ydnwc-dialog-hd-closable">
                <span class="ydnwc-dialog-title"><img src="/clipper/image/logo-web-clipper.png" alt="KingCore网页剪报" align="absmiddle"> KingCore网页剪报
                </span>
                  <span id="logout">
                    
                </span>
                <span id="ydnwcUser">admin</span><a href="#" id="close" class="ydnwc-dialog-close"></a>
            </div>

                        <div class="ydnwc-dialog-bd" id="content">
            <form name="_YNoteInfoForm" class="ydnwc-dialog-form" action="/clipper/upload.jspx?keyfrom=wcp" method="POST" enctype="multipart/form-data" onsubmit="return preSubmit()">
                    <div style="display:none" class="row">
                        <div class="row-hd"><label for="null-name-1">网址:</label></div>
                        <div class="row-bd"><a target="_blank">
                                                                                     http://www.zhongyi360.cn/tcmxx/11178.jhtml
                                                                            </a>
                        </div>
                    </div>

                    <div class="row">
                        <div class="row-hd"><label for="channelId">栏目:</label></div>
                        <div class="row-bd">
                            <select id="channelId" name="channelId">
<c:forEach items="${model.channelList}" var="item" varStatus="status">
<option value="${item.id}">${item.channelExt.name}</option>
</c:forEach>                   
                             </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="row-hd"><label for="title">标题:</label></div>
                        <div class="row-bd">
                            <input type="text" class="ydnwc-dialog-text title" id="title" name="title" value="百度一下，你就知道" maxlength="500">
                            <input type="hidden" value="/wcp1367207408791157" name="p" id="p">
                            <input type="hidden" value="" name="bs" id="bs">
                            <input type="hidden" value="5968" name="len" id="len">
                            <input type="hidden" value="http://www.zhongyi360.cn/tcmxx/11178.jhtml" name="src" id="src">
                            <input type="hidden" value="false" name="e" id="e">
                            <input type="hidden" value="" name="from">
                        	<input type="hidden" value="true" name="confirm">
                        </div>
                    </div>
                   <div style="width:390px;height:100px;" class="row">
                        <div class="row-hd">内容：</div>
                        <div class="row-bd">

    <textarea style="width:310px;height:100px;" name="txt" id="txt" rows="3" cols="30"></textarea>
    
                        </div>
                    </div>
                    <div style="display:none" class="row">
                        <div class="row-hd"></div>
                        <div class="row-bd">
                            <label for="ourl1"><input type="radio" id="ourl1" name="ourl" value="false" checked="true" onclick="selectionContent(this)">保存整个网页</label>
                            <label for="ourl2"><input type="radio" id="ourl2" name="ourl" value="true" onclick="selectionContent(this)">只保存网址</label>
                            <label for="ourl3" id="lb3" style="color: rgb(222, 222, 222); "><input type="radio" id="ourl3" name="ourl" value="false" onclick="selectionContent(this)" disabled="">保存正文</label>
                            <img id="new" src="/clipper/image/new.png" style="display: none; ">
                        </div>
                    </div>
                   <!--div class="row">
                        <div class="row-hd">添加注释</div>
                        <div class="row-bd">
                            <textarea  name="cmt" style="width:100%" value="${cmt}" >
                            </textarea>
                        </div>
                    </div-->
                    <div class="row btns-row" style="height:50px">
                        <input class="ydnwc-dialog-btn" name="sb" id="sb" type="submit" value="保 存">
                        <input class="ydnwc-dialog-btn ydnwc-dialog-btn-gray" type="button" name="cancelbtn" id="cancelbtn" value="取 消">
                    </div>

        </form>
        <script type="text/javascript">
                <!--
                    setTimeout(function(){try{var us=document.getElementById("title");us.focus();us.select();}catch(e){}},100);
                -->
         </script>
  
    </div>
    <div class="ydnwc-dialog-ft" id="tips">
            <p class="ydnwc-dialog-tip"><img src="../images/feedback.gif" alt="意见反馈" align="absmiddle">&nbsp;&nbsp;<a target="_blank" href="/guestbook.jspx">意见反馈</a></p>
    </div>

    <!-- loading -->
    <div id="loadingview" name="loadingview" class="ydnwc-dialog-loading" style="display:none">正在加载中，请稍后…</div>
    </div>
</div>
    <script type="text/javascript" src="/clipper/js/close.js"></script>
    <script type="text/javascript">
    <!--
    (function (){
        var  _$ = function(id){
            return document.getElementById(id);
        }
        var contenMode = window.name.substring(0,1);
        var parent_url = document.getElementById('src').value;
        //取到包括分割标识符正文已经整个网页的一个字符串
        var tempStr = document.getElementById('bs').value;
        
        //alert(tempStr);
       //取到分割标识符所在位置
        var position = tempStr.lastIndexOf('$');
        //取到包含两个分割标识符的正个网页的字符串
        var allContent = tempStr.substring(0,position);
        //取到标识符
        var mark = tempStr.substring(position+1);
        var tempArr = allContent.split(mark);
        //正文
        var mainContent = tempArr.length > 1 ? tempArr[1] : allContent;
        //mainContent = tempStr;
        //alert(mainContent);
        
        //整个网页
        var fullPageContent = allContent.replace(mark,'');
        //隐藏文本控件
        var  _bsInput = _$('bs');
        //保存正文label
        var _lb3 = _$('lb3');
        //docType
        var _docType = _$('type');
        //checkbox控件
        var  _our1Check = _$('ourl1');
        var  _our2Check = _$('ourl2');
        var  _our3Check = _$('ourl3');
        if(contenMode ==='1'){
            _our3Check.disabled = true;
            _lb3.style.color = '#dedede';
            _$('new').style.display = 'none';
        }
        if(contenMode ==='2'){
            _our3Check.disabled = false;
            _our3Check.checked= 'true';
            _bsInput.value = mainContent;
            //alert(11);
        }
        function cancel(){
            _$('deleteForm').submit();
            croDomain.postMessage('remove', parent_url);
        }
        function selectionContent(obj){
            if(obj.id === 'ourl3'){
               croDomain.postMessage('creat', parent_url);
               _bsInput.value = tempStr; //mainContent;  //mod by wzw
               _docType.value = 'MainBody';
            	//alert(12);
            }
            if(obj.id === 'ourl1' || obj.id === 'ourl2' ){
                croDomain.postMessage('remove', parent_url);
               _bsInput.value = fullPageContent;
               _docType.value = '1'; //'FullPage';
            	//alert(13);
            }
        }
        //method=logout，参数有p，src，tl，bs，len，fpc，e
        _$('logout').onclick = function(){
            var form = document.forms['_YNoteInfoForm'];
            _bsInput.value = tempStr;
            form.action = "http://note.youdao.com/yws/mapi/wcp?method=logout&keyfrom=wcp";
            form.submit();
            alert(14);
        }
        window.selectionContent = function(e){
            selectionContent(e);
        };
    })();

    -->
    </script>



</body></html>
