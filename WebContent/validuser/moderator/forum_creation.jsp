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
.auto-style3 {
	text-align: left;
}
.auto-style4 {
	font-family: "Arial Rounded MT Bold";
	color: #FFFFFF;
	background-color: #000080;
}
.auto-style5 {
	text-align: right;
}
</style>
</head>

<body>

<div>
	<h1 class="auto-style4">SmartHealth</h1>
</div>
<br />
<form method="post" action="/SmartHealthWeb/ForumCreation">
	<div class="auto-style1">
	<table style="width: 100%">
		<tr>
			<td class="auto-style5"><label id="Label1">Forum Title</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="auto-style3">
			<textarea cols="20" name="forumTitle" rows="2"></textarea></td>
		</tr>
		<tr>
			<td class="auto-style5"><label id="Label2">Forum Description</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="auto-style3">
			<textarea cols="40" name="forumDesc" rows="2"></textarea></td>
		</tr>
	</table>
	<br />
	<input name="Create" type="submit" value="Create" />
</div>
</form>

</body>

</html>
    