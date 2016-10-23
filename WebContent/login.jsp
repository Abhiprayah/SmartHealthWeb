<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Login</title>
<style type="text/css">
.auto-style1 {
	text-align: center;
}
.auto-style2 {
	text-align: right;
}
.auto-style3 {
	text-align: left;
}
.auto-style4 {
	font-family: "Arial Rounded MT Bold";
	color: #FFFFFF;
	background-color: #000080;
}
</style>
</head>

<body>

<div>
	<h1 class="auto-style4">SmartHealth</h1>
</div>

<form method="post" action="Login">
	<table style="width: 100%">
		<tr>
			<td class="auto-style2"><label id="Label1">Primary Email ID</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="auto-style3"><input name="EmailID" type="text" /></td>
		</tr>
		<tr>
			<td class="auto-style2"><label id="Label1">Password</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="auto-style3"><input name="Password" type="password" /></td>
		</tr>
		<tr>
			<td class="auto-style2"><input name="Login" type="submit" value="Login" /></td>
			<td class="auto-style3"><input name="SignUp" type="button" value="Register" /></td>
		</tr>
	</table>
</form>

</body>

</html>
