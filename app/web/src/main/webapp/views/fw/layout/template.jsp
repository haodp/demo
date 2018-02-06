<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragrma","no-cache");
response.setDateHeader("Expires",0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" ></meta>
<title><tiles:insertAttribute name="title" /></title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<meta HTTP-EQUIV="pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
<meta HTTP-EQUIV="expires" CONTENT="0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<%@ include file="/views/fw/static-res.jsp"%>

<script type="text/javascript">
</script>
</head>
<body class="skin-black-light sidebar-mini">
	<div class="wrapper">
		<header class="main-header" style="border-bottom: 1px solid #d2d6de;">
			<div class="logo" style="text-aling:center;">
				<span class="logo-mini"><span style="height: 32px;width:48px;"><span class="logo-lg" style="font-size: 14px;"><b><img src="<%=contextPath%>/images/logo-m.png" width="40"></b></span></span></span>
				<span class="logo-lg"><img src="<%=contextPath%>/images/favicon.ico" width="60"></span>
			</div>
			<tiles:insertAttribute name="header" />
		</header>

		<div><tiles:insertAttribute name="navi" /></div>

		<div class="content-wrapper" style="border-left:0px;">
			<section class="content">
			   <tiles:insertAttribute name="content" />
			</section>
		</div>
	</div>
</body>
</html>
