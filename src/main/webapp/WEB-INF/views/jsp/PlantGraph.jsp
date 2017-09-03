<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: achar
  Date: 27-07-2017
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Graph</title>
</head>
<body>
${plantType}
<br>
<script>
    var a = ${readings};
</script>
<script>
    console.log(a);
</script>
</body>
</html>
