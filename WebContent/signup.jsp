<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Sign Up</title>
<style type="text/css">
.auto-style4 {
	font-family: "Arial Rounded MT Bold";
	color: #FFFFFF;
	background-color: #000080;
}
.auto-style5 {
	text-align: right;
}
.auto-style6 {
	text-align: left;
}
</style>
</head>

<body>

<div>
	<h1 class="auto-style4">SmartHealth</h1>
</div>

<table style="width: 100%">
	<tr align="center">
		<td class="auto-style5" valign="top">Sign up as:&nbsp;&nbsp;</td>
		<td>
		<form method="post" action="Signup">
			<div class="auto-style6">
				<select id="UserTypeSelect" name="Select1">
				<option value="EndUser">End&nbsp;User</option>
				<option value="Moderator">Moderator</option>
				<option value="Admin">Admin</option>
				</select>
				&nbsp;&nbsp;
				<input name="Submit1" type="submit" value="Go" />
				</div>
		</form>
		</td>
		</tr>
</table>

</body>

</html>
