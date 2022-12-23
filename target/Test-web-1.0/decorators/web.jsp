<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv = "Content-Type" content = "text/html" charset="UTF-8">
<title><dec:title default = "Trang chủ"/></title>

<!-- css -->
<link href = "<c:url value = 'template/web/bootstrap/css/styles.css	'/>" rel = stylesheet type = "text/css" media = "all" /> 
</head>
<body>
 <!-- header -->
 <%@ include file = "/common/web/header.jsp" %>
 <div class ="container">
 	<dec:body/>
 </div>
 <!-- footer -->
 <%@ include file = "/common/web/footer.jsp" %>
 
</body>
</html>