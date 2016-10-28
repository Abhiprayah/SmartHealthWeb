<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
.auto-style5 {
	text-align: center;
}
.auto-style6 {
	text-align: right;
}
</style>
</head>

<body>

<div>
	<h1 class="auto-style4">SmartHealth</h1>
</div>
<form method="post" action="SignUpAdmin">
<table align="center" style="width: 50%">
	<tr>
		<td class="auto-style5" valign="top">First Name:</td>
		<td><input name="firstName" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Last Name:</td>
		<td><input name="lastName" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Primary Email:</td>
		<td><input name="primaryEmail" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Secondary Email:</td>
		<td><input name="secondaryEmail" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Password:</td>
		<td><input name="password" type="password" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Username:</td>
		<td><input name="username" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Street Number:</td>
		<td><input name="streetNumber" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Street Name:</td>
		<td><input name="streetName" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Major Municipality:</td>
		<td><input name="majorMunicipality" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Governing District:</td>
		<td><input name="governingDistrict" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Postal Area:</td>
		<td><input name="postalArea" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">About:</td>
		<td><textarea cols="20" name="about" rows="4"></textarea></td>
	</tr>
	<tr>
		<td class="auto-style5">Profile Pic link1:</td>
		<td><input name="profilePicLink1" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Profile Pic link2:</td>
		<td><input name="profilePicLink2" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Profile Pic link3:</td>
		<td><input name="profilePicLink3" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Emergency Contact:</td>
		<td><input name="emergencyContact" type="text" /></td>
	</tr>
	<tr>
		<td class="auto-style6">
		<input name="Submit" type="submit" value="Register" /></td>
		<td></td>
	</tr>
</table>
</form>
</body>

</html>
