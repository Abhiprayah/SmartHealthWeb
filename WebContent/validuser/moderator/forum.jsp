<%@page import="java.util.ArrayList"%>
<%@page import="beans.Post"%>
<%@page import="beans.Forum"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Forum</title>
<style type="text/css">
.auto-style4 {
	font-family: "Arial Rounded MT Bold";
	color: #FFFFFF;
	background-color: #000080;
}
.auto-style5 {
	background-color: #E1FFFF;
}
</style>
</head>

<body>

<div>
	<h1 class="auto-style4">SmartHealth</h1>
</div>
<% 
models.Forums model = new models.Forums();
Forum forum = model.getForumContent(Integer.parseInt(request.getParameter("id")));
String id = (String)request.getParameter("id");
%>
<!-- <form method="post"> -->
<form method="post" action=<%= "/SmartHealthWeb/Forum?forumID=" + id %>>
	<label id="Label1" style="font-size: x-large"><strong>Forum Title : </strong><%=forum.getTopic() %></label>
	<br />
	<label id="Label2" style="font-size: large"><strong>Summary : </strong><%=forum.getSummary() %></label>
	<br />
	<label id="Label1">Enter Post Text:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
	<input name="post" type="text" style="width: 400px" />
	<br />
	<label id="Label1">Enter Photo Link:&nbsp;&nbsp;&nbsp;&nbsp;</label>
	<input name="photoLocation" type="text" style="width: 400px" />
	<br />
	<label id="Label1">Enter Video Link:&nbsp;&nbsp;&nbsp;&nbsp;</label>
	<input name="videoLocation" type="text" style="width: 400px" />
	<br />
	<label id="Label1">Enter Link Location:</label>
	<input name="linkLocation" type="text" style="width: 400px" />
	<br />
	<input name="postSubmit" type="submit" value="Post" />
	<br />
	<br />
	<input name="closeForum" style="text-transform: capitalize; color: #FF0000; font-weight: bolder;" type="submit" value="Close Forum" />
</form>
<p><strong>Posts:</strong></p>
	<%
	ArrayList<Post> posts = forum.getPosts();
	for(Post p : posts){
		out.print("<hr />");
		out.print("<form method=\"post\" action=\"/SmartHealthWeb/Forum?forumID=" + id + "&postID=" + p.getID() + " \">");
		out.print(p.display());
		out.print("</form>");
	}
	%>
<!-- </form> -->

</body>

</html>
