<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>HOME</title>
<style type="text/css">
<!--
.titlediv {
	background-position: center top;
	text-align: center;
	font-family: "Arial Rounded MT Bold";
	color: #FFFFFF;
	background-color: #000080;
}

-->
</style>
</head>

<body>
<div align="center" class="titlediv" id="title"><h1> FRIENDSZONE </h1></div>

<table width="1024" height="50" border="1" align="center">
  <tr>
    <th width="328" height="44" scope="col"><a href="/SmartHealthWeb/validuser/loggedin.jsp"> HOME </a></th>
    <th width="328" scope="col"><a href="#"> DISCUSSION FORUM </a></th>
    <th width="346" scope="col"><a href="#"> FRIENDSZONE </a></th>
	<th width="346" scope="col"><a href="#"> HEALTH REPORT</a></th>
  </tr>
</table>

<br />

<% ArrayList<String> pendingrequests = (ArrayList<String>)session.getAttribute("pendingrequests");
out.write("<p> Select a checkbox if you want to accept a request, leave blank to reject a request</p><br />");
out.write("<form action='../../ProcessRequest' method='post' onsubmit=alert(/requests-processed/)>");
out.write("<table>");

for(int i = 0; i<pendingrequests.size();i++)
{
out.write("<tr><td>" + pendingrequests.get(i) + "</td> <td><input type='checkbox' name='" + i + "' /></td></tr>"  );
}
out.write("<tr><td> </td><input type='submit' name='acceptrejectstatus' id='acceptrejectstatussubmit'/></tr></table></form>");
%>

</body>
</html>