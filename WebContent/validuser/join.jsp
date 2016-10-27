<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Login</title>
<style type="text/css">
.auto-style4 {
	font-family: "Arial Rounded MT Bold";
	color: #FFFFFF;
	background-color: #000080;
}

.auto-style6 {
	text-align: right;
}
.auto-style7 {
	background-color: #000080;
}
.auto-style8 {
	text-align: center;
}
</style>
</head>

<body>

<div class="auto-style7">
	<h1 class="auto-style4">SmartHealth</h1>
</div>

<div class="auto-style6">
<label id="userWelcome">Welcome&nbsp;<%= ((User)session.getAttribute("curUser")).getUserId() %></label>
</div>

<br />
<br />
<br />
<form method="post" action="/SmartHealthWeb/Join">
	<div class="auto-style8">
		<input name="join_Again" type="submit" value="Join Again" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input name="logout" type="submit" value="Logout" />
	</div>
</form>
</body>

</html>
