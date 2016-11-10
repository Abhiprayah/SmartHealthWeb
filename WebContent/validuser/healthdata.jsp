<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Health Zone</title>
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

<div align="center" class="titlediv" id="title"><h1> HEALTH REPORT </h1></div>

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
<form action="../HealthData" method="post">
<p> Enter new Health Data</p>
<table>
<tr><td> Distance ran </td> <td> <input type="text" name="distance" id="distanceinput" placeholder="distance in Km"/> </td></tr>
 <tr> <td> Calories Burned </td> <td> <input type="text" name="caloryinput" placeholder="calories burned in cal"/> </td></tr>
<tr> <td> Systolic blood pressure </td> <td> <input type="text" name="sysbpinput" placeholder="systolic blood pressure in mm HG"/> </td></tr>
<tr> <td> Diastolic blood pressure </td> <td> <input type="text" name="diabpinput" placeholder="diastolic blood pressure in mm HG"/> </td></tr>
</table>
<input type="submit" name="adddata" id="adddataSubmit" value="save new data" />
<br />
<br />
<input type="submit" name="userhealthreport" id="userhealthreportsubmit" value="View your Health Report" />
<br />
<br />
<p> View a friend's Health Report by entering his name below:</p>
Friend's name:<input type = "text" name="friendusername" id="friendnameinput" placeholder="Friend name" />
<input type="submit" name="friendreportsubmit" id="friendSubmit" value="Submit" />
</form>
</div>


<div>
${requestScope.addDataOutput}
</div>

<div>
${requestScope.healthReportOutput}
</div>

<div>
${requestScope.friendReportOutput}
</div>
</body>
</html>
