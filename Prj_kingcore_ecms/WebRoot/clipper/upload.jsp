<%@ page contentType="text/html; charset=utf-8"%>

<html><head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>有道云笔记</title>

    <link type="text/css" rel="stylesheet" href="http://note.youdao.com/yws/css/web-clipper.css?ver=428648">
    <script type="text/javascript" src="http://localhost:8080/clipper/crossDomain.js"></script>
    <script language="javascript">
        function preSubmit () {
            document.getElementById("sb").disabled = true;
            document.getElementById("cancelbtn").disabled = true;
            var v = document.getElementById("tl");
            if (v != null && v.value == "") {
                v.value = "无标题笔记";
            }
            alert( document.getElementById("bs").value );
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
                <span class="ydnwc-dialog-title"><img src="http://note.youdao.com/yws/images/logo-web-clipper.png" alt="有道云笔记" align="absmiddle"> 有道云笔记
                </span>
                  <span id="logout">
                    注销
                </span>
                <span id="ydnwcUser">wuzeven@163.com</span><a href="#" id="close" class="ydnwc-dialog-close"></a>
            </div>

                        <div class="ydnwc-dialog-bd" id="content">
            <form name="_YNoteInfoForm" class="ydnwc-dialog-form" action="http://localhost:8080/clipper/upload.jspx?keyfrom=wcp" method="POST" enctype="multipart/form-data" onsubmit="return preSubmit()">
                    <div class="row">
                        <div class="row-hd"><label for="null-name-1">网址:</label></div>
                        <div class="row-bd"><a target="_blank">
                                                                                     http://www.zhongyi360.cn/tcmxx/11178.jhtml
                                                                            </a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="row-hd"><label for="tl">标题:</label></div>
                        <div class="row-bd">
                            <input type="text" class="ydnwc-dialog-text title" id="tl" name="tl" value="百度一下，你就知道" maxlength="500">
                            <input type="hidden" value="/wcp1367207408791157" name="p" id="p">
                            <input type="hidden" value="" name="bs" id="bs">
                            <input type="hidden" value="5968" name="len" id="len">
                            <input type="hidden" value="http://www.zhongyi360.cn/tcmxx/11178.jhtml" name="src" id="src">
                            <input type="hidden" value="false" name="e" id="e">
                            <input type="hidden" value="FullPage" name="type" id="type">
                            <input type="hidden" value="" name="from">
                        	<input type="hidden" value="true" name="confirm">
                        </div>
                    </div>

                    <div class="row">
                        <div class="row-hd"><label for="nb">笔记本:</label></div>
                        <div class="row-bd">
                            <select id="nb" name="nb">
                                                                     <option value="/D0D82996EAEA4A29BA8275C0A9BA3E98">SpringMVC使用.woo</option>
                                                                     <option value="/7502865B848E436185D0B1E8A6603094">Freemarker使用.woo</option>
                                                                     <option value="/DCE9628F8AFD46F3844BB64099E1CC96">General</option>
                                                                     <option value="/5034C81A1C014F84A9BB5B49535C2A71">JBoss</option>
                                                                     <option value="/8CFF09D82E4140329BDBF84C81640CD2">JMX</option>
                                                                     <option value="/821476AEB849430C8F2DC88F93A89031">KingCore_Director</option>
                                                                     <option value="/63B5BC7287154117A95B0DB3092945D5">KingCore_Framework</option>
                                                                     <option value="/66F81550970E4FA9800266096E2C29C8">KingCore_Pda</option>
                                                                     <option value="/6EBF17E30E3E439CA04650FF67ED6400">KingCore_eCMS</option>
                                                                     <option value="/CE9366A8E12945B2A94BA6AFC638443A">Library_Finance</option>
                                                                     <option value="/08324D2881BE4695891311721AA67504">Log4j</option>
                                                                     <option value="/8EDCF67F8F4345DE86C3D72E9D578CAE">Mon开发相关</option>
                                                                     <option value="/E3D87A43D1924F5D818DF4373AE01F77">Mon平台_集成测试与部署</option>
                                                                     <option value="/3F34C73382CC4731A37E6A16077E7FA5">东洲装饰网</option>
                                                                     <option value="/C06011AF94D64431BDB9BE71FAE78E3B">其他杂项笔记</option>
                                                                     <option value="/VjEoPK3">软件考试</option>
                                                                     <option value="/4BE05AA5835E47D08E31C53D60BDA465">数据库读写分离</option>
                                                                     <option value="/EC65A13EAC5A46F98206F1871CCF5EA4">网站：IT实践网.cn</option>
                                                                     <option value="/A6AD0A33092D409B91DB62A19D4EE54A">网站：东洲装饰公司.com</option>
                                                                     <option value="/Vx39tuq">网站：中医保健网.cn</option>
                                                             </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="row-hd"></div>
                        <div class="row-bd">
                            <label for="ourl1"><input type="radio" id="ourl1" name="ourl" value="false" checked="true" onclick="selectionContent(this)">保存整个网页</label>
                            <label for="ourl2"><input type="radio" id="ourl2" name="ourl" value="true" onclick="selectionContent(this)">只保存网址</label>
                            <label for="ourl3" id="lb3" style="color: rgb(222, 222, 222); "><input type="radio" id="ourl3" name="ourl" value="false" onclick="selectionContent(this)" disabled="">保存正文</label>
                            <img id="new" src="http://note.youdao.com/yws/images/new.png" style="display: none; ">
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
                    setTimeout(function(){try{var us=document.getElementById("tl");us.focus();us.select();}catch(e){}},100);
                -->
         </script>

    </div>
    <div class="ydnwc-dialog-ft" id="tips">
            <p class="ydnwc-dialog-tip"><img src="../images/feedback.gif" alt="意见反馈" align="absmiddle">&nbsp;&nbsp;<a target="_blank" href="http://feedback.youdao.com/note_web_report.jsp?prodtype=note_web">意见反馈</a></p>
    </div>

    <!-- loading -->
    <div id="loadingview" name="loadingview" class="ydnwc-dialog-loading" style="display:none">正在加载中，请稍后…</div>
    </div>
</div>
    <script type="text/javascript" src="http://localhost:8080/clipper/close.js"></script>
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
        
        alert(tempStr);
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
        alert(mainContent);
        
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
            alert(11);
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
            	alert(12);
            }
            if(obj.id === 'ourl1' || obj.id === 'ourl2' ){
                croDomain.postMessage('remove', parent_url);
               _bsInput.value = fullPageContent;
               _docType.value = 'FullPage';
            	alert(13);
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
