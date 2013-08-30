<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Session Login</title>
</head><body>
<form action="sessionLogin" method="post">
User id<input type="text" name="userId" /> <br/>
Password <input type="password" name="passwd" /> <br />
<input type="submit" value="Login"/>

<s:set var="message" value="%{'http://www.mkyong.com'}" />
<s:property value="message" />

</form>
</body>

</html>