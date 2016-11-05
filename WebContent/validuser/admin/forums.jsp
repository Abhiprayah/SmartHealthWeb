<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.User,java.util.*,beans.ForumIdentifier" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>forums</title>
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
</div>
<br />
<table align="center" class="auto-style5" style="width: 100%">
<%
models.ForumList model = new models.ForumList();
ArrayList<ForumIdentifier> forums = model.listOpenForums();
for(ForumIdentifier f : forums){
	out.print("<tr>");
	out.print("<td>");
	out.print("<a href=\"/SmartHealthWeb/validuser/forum.jsp?id="+f.getForumID()+"\">"+f.getForumDesc()+"</a>");
	out.print("</td>");
	out.print("</tr>");
}
%>
</table>
</body>
</html>
