<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String contextPath = request.getContextPath() + "/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息提示</title>
<link href='<%=contextPath%>/stylesheets/bootstrap/bootstrap.min.css' rel='stylesheet' type='text/css' />
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
<link href='<%=contextPath%>/stylesheets/admin-lte/AdminLTE.min.css' rel='stylesheet' type='text/css' />
<style type="text/css">
* {
	font-family: Microsoft YaHei, "微软雅黑", Arial, Helvetica, sans-serif;
}
</style>
</head>
<body style="background-color: #ecf0f5;">
	<section class="content">
		<div class="error-page">
			<h2 class="text-red" style="text-align:center;">
				<i class="fa fa-warning"></i>
				系统繁忙，请稍后重试！
			</h2>
			
<!-- 			<h2 class="headline text-red" style="margin-top:10px;"></h2> -->
			<div  style="text-align:center;">
				<p style="font-size:20px;text-align:center;">
					<span style="text-align: left;">给您带来的不便我们深表歉意，请联系管理员，我们会以最快的速度解决您的问题！</span>
<%-- 					<c:if test="${sessionScope.indexUrl != ''}"> --%>
						<br><br>
						<a href="<%=contextPath%>">重新登录</a>
<%-- 					</c:if> --%>
				</p>
			</div>
		</div>
	</section>
</body>
</html>