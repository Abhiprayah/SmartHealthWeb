<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <th width="328" height="44" scope="col"><a href="#"> HOME </a></th>
    <th width="328" scope="col"><a href="#"> DISCUSSION FORUM </a></th>
    <th width="346" scope="col"><a href="#"> FRIENDSZONE </a></th>
	<th width="346" scope="col"><a href="#"> HEALTH REPORT</a></th>
	<th width="346" scope="col"><a href="#"> LOGOUT</a></th>
  </tr>
</table>

<br />
<div>

<!-- still need to handle action url -->
<form action="../../Friends" method="post">
<input type="submit" name="viewfriends" id="viewFriendsSubmit" value="Show Friends" />
<br />
<br />
Send Friend request to <input type = "text" name="reqfriendusername" id="friendusernameinput" placeholder="username"/>
<input type="submit" name="sendrequest" id="friendRequestSubmit" value="Submit" />

<br />
<br />
Unfriend this person ....:<input type = "text" name="friendusername" id="unfriendinput" placeholder="username"/>
<input type="submit" name="unfriend" id="unfriendSubmit" value="Submit" />

</form>
</div>


<div>
<ul>
${requestScope.viewFriendsOutput}
</ul>


</div>
<br />
<div>
${requestScope.sendFriendRequestOutput}
</div>


<div>
${requestScope.unfriendOutput}
</div>
</body>
</html>
