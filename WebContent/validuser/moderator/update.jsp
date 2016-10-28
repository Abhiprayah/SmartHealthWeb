<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.User,beans.Moderator" %>
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
<form method="post" action="/SmartHealthWeb/UpdateModerator">
<table align="center" style="width: 50%">
	<tr>
		<td class="auto-style5" valign="top">First Name:</td>
		<td><input name="firstName" type="text" value="<%= ((User)session.getAttribute("curUser")).getFirstName() %>" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Last Name:</td>
		<td><input name="lastName" type="text" value="<%= ((User)session.getAttribute("curUser")).getLastName() %>" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Secondary Email:</td>
		<td><input name="secondaryEmail" type="text" value="<%= ((User)session.getAttribute("curUser")).getSecondaryEmail() %>" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Password:</td>
		<td><input name="password" type="password" value="<%= ((User)session.getAttribute("curUser")).getPassword() %>" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Street Number:</td>
		<td><input name="streetNumber" type="text" value="<%= ((User)session.getAttribute("curUser")).getPostalAddress().getStreetNumber() %>" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Street Name:</td>
		<td><input name="streetName" type="text" value="<%= ((User)session.getAttribute("curUser")).getPostalAddress().getStreetName() %>" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Major Municipality:</td>
		<td><input name="majorMunicipality" type="text" value="<%= ((User)session.getAttribute("curUser")).getPostalAddress().getMajorMunicipality() %>"/></td>
	</tr>
	<tr>
		<td class="auto-style5">Governing District:</td>
		<td><input name="governingDistrict" type="text" value="<%= ((User)session.getAttribute("curUser")).getPostalAddress().getGoverningDistrict() %>"/></td>
	</tr>
	<tr>
		<td class="auto-style5">Postal Area:</td>
		<td><input name="postalArea" type="text" value="<%= ((User)session.getAttribute("curUser")).getPostalAddress().getPostalArea() %>" /></td>
	</tr>
	<tr>
		<td class="auto-style5">About:</td>
		<td><textarea cols="20" name="about" rows="4" ><%= ((User)session.getAttribute("curUser")).getAboutMe() %></textarea></td>
	</tr>
	<tr>
		<td class="auto-style5">Profile Pic link1:</td>
		<td><input name="profilePicLink1" type="text" value="<%= ((User)session.getAttribute("curUser")).getPicURL()[0] %>"/></td>
	</tr>
	<tr>
		<td class="auto-style5">Profile Pic link2:</td>
		<td><input name="profilePicLink2" type="text" value="<%= ((User)session.getAttribute("curUser")).getPicURL()[1] %>"/></td>
	</tr>
	<tr>
		<td class="auto-style5">Profile Pic link3:</td>
		<td><input name="profilePicLink3" type="text" value="<%= ((User)session.getAttribute("curUser")).getPicURL()[2] %>"/></td>
	</tr>
	<tr>
		<td class="auto-style5">Emergency Contact:</td>
		<td><input name="emergencyContact" type="text" value="<%= ((Moderator)session.getAttribute("curUser")).getEmergencyContact() %>" /></td>
	</tr>
	<tr>
		<td class="auto-style5">Qualifications:&nbsp;<%=(new models.SignUp()).qualificationsToString()%></td>
		<td><input name="qualifications" type="text" value="<%= ((Moderator)session.getAttribute("curUser")).displayQualifications() %>" /></td>
	</tr>
	<tr>
		<td class="auto-style6">
		<input name="Submit" type="submit" value="Update" /></td>
		<td></td>
	</tr>
</table>
</form>
</body>

</html>
