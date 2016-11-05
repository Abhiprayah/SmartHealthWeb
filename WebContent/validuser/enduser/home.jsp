<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Home</title>
<style type="text/css">
.auto-style4 {
	font-family: "Arial Rounded MT Bold";
	color: #FFFFFF;
	background-color: #000080;
}
.auto-style5 {
	border: 1px solid #000000;
	background-color: #F6FFFF;
}
.auto-style6 {
	text-align: right;
}
.auto-style7 {
	background-color: #000080;
}

</style>
</head>

<body>
<div class="auto-style7">
	<h1 class="auto-style4">SmartHealth</h1>
<table align="center" class="auto-style5" style="width: 100%">
	<tr>
		<td><a href="/SmartHealthWeb/Display">Display</a></td>
		<td><a href="update.jsp">Update</a></td>
		<td><a href="Friends.jsp">Friends</a></td>
		<td><a href="forums.jsp">Forums</a></td>
		<td><a href="/health_data">Health Data</a></td>
		<td><a href="/SmartHealthWeb/Quit">Quit Profile </a></td>
		<td><a href="/SmartHealthWeb/Logout">Logout</a></td>
	</tr>
</table>
</div>
<div class="auto-style6">
<label id="userWelcome">Welcome&nbsp;<%= ((User)session.getAttribute("curUser")).getUserId() %></label>
</div>
</body>
</html>
