<%@page import="com.model.CategoryBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Category List</h3>

<%-- <%
List<CategoryBean> catlist = (List<CategoryBean>) request.getAttribute("CatList");
for (CategoryBean obj : catlist) {
%>
	
<% 
}
%> --%>

<c:forEach items="${ CatList }" var="category">
<a href="Movie_List_Servlet?catId=${category.id}">${category.name}</a>
</c:forEach>


</body>
</html>