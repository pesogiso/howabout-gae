<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>howabout83</title>
	<script type="text/javascript" src="/_ah/channel/jsapi"></script>
	
</head>

<body>
	<link rel="stylesheet" href="/css/jquery.mobile-1.0a4.1.min.css" charset="utf-8"/>
	<script src="/js/jquery-1.4.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/jquery.mobile-1.0a4.1.min.js" type="application/x-javascript" charset="utf-8"></script>
	<script type="text/javascript">
	<!--
		// html生成時にセットされる
		channelToken = "${f:h(channelToken)}";
	//-->
	</script>
	<script type="text/javascript" src="/js/message.js"></script>
	
	<script type="text/javascript">
	<!--
		$(document).ready(function(){
			//console.log("1");
			$("#btn1").click(function(){
				$.post("message", {pushedNum:'0'}, null,'text')
			});
			$("#btn2").click(function(){
				$.post("message", {pushedNum:'1'}, null,'text')
			});
			$("#btn3").click(function(){
				$.post("message", {pushedNum:'2'}, null,'text')
			});
			$("#btn4").click(function(){
				$.post("message", {pushedNum:'3'}, null,'text')
			});
		});
	//-->
	</script>
	
<!-- home ページ --> 
<div id="answer" data-role="page"> 
	<!-- header --> 
		<div data-role="header"> 
	 		<h1>回答ページ</h1> 
	 	</div> 
 	<!-- /header -->
 	 
 	<!-- content -->
 		<!-- ボタン -->
	 	<ul data-role="listview" data-inset="true">
			<li data-role="list-divider">${f:h(Question)}</li>
		
			<!-- 動的に質問文の書かれたボタンを生成  -->	
			<c:forEach var="e" items="${Answer}" varStatus="loop">
			 	<li><a href="javascript:void(0)" data-transition="fade" id=btn${loop.count} >${f:h(e)}</a></li>
			</c:forEach>
		</ul>
		
		<c:forEach var="e" items="${Count}" varStatus="loop">
			 <div id=result${loop.count} >${f:h(e)}</div>
		</c:forEach>
		
		<div data-role="content">
			<a data-role="button" data-transition="fade" href="question">質問作成ページへ</a> 
		</div>
	<!-- /content --> 
	
	<!-- footer --> 
		<div data-role="footer"> 
			<!-- footerは特になし --> 
		</div> 
	<!-- /footer --> 
</div> 
<!-- /home ページ --> 
 
<!-- 質問 ページ --> 
<div id="question" data-role="page"> 
	<!-- header --> 
		<div data-role="header"> 
			<h1>質問作成ページ</h1> 
		</div> 
	<!-- /header --> 
	
	<!-- content --> 
		<!-- テキストフィールド -->
		<form>
			<div data-role="fieldcontain">
				<ul data-role="listview" data-inset="true">
					<li data-role="list-divider">質問文</li>
					<li><input type="text" name="name" id="qtf" value=""/></li>
				 	
				 	<li data-role="list-divider">回答案</li>
					<li><input type="text" name="name" id="atf1" value=""/></li>
				 	<li><input type="text" name="name" id="atf2" value=""/></li>
				 	<li><input type="text" name="name" id="atf3" value=""/></li>
				 	<li><input type="text" name="name" id="atf4" value=""/></li>
				</ui>
				<input type="button" value="送信" onclick="myapp.postMessage()"/>
			</div> 
		</form>
		<form>
		<div data-role="content"> 
			<a data-role="button" data-transition="fade" onclick="myapp2.jump()">戻る</a> 
		</div>
		</form> 
	<!-- /content --> 
	
	<!-- footer --> 
		<div data-role="footer"> 
			<!-- footerは特になし --> 
		</div> 
	<!-- /footer --> 
</div> 
<!-- /hoge ページ --> 
</body>
</html>
