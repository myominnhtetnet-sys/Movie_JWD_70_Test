<%@page import="com.model.Movie_Bean"%>
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

	<h3>Movie List</h3>

	<%-- <%
	List<Movie_Bean> movlist = (List<Movie_Bean>) request.getAttribute("mov_List");
	%> --%>
	<form action="Selected_Servlet" method="post">
		<select name="manme">
			<option value="none">None</option>
			<%-- <%
			for (Movie_Bean obj : movlist) {
			%>
			<option value="<%=obj.getId()%>"><%=obj.getTitle()%>,<%=obj.getReleseYear().getYear()%></option>
			<%
			}
			%> --%>
			
			<c:forEach items="${mov_List}" var="movie">
				<option value="${movie.id}">${movie.title},${movie.preShow}</option>
			</c:forEach>
			
		</select><br> 
		<input type="submit" value="chose">

	</form>

</body>
</html>