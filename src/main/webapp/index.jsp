<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<s:form action="login">
	<s:textfield name="username" label="Username"/>
	<s:textfield name="password" label="Password"/>
	<s:submit/>
</s:form>

</body>
</html>
