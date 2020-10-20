<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<h1>Main page</h1>
<form action="${pageContext.request.contextPath}/user/inject" target="_self">
    <button>Inject test data into DB</button>
</form>
</body>
</html>
