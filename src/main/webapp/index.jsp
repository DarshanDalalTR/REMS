<%--
  Created by IntelliJ IDEA.
  User: achar
  Date: 24-06-2017
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:url value="/welcome" var="showform"/>
  <form:form action="${showform}">
      <input type="submit" value="Hit me">
  </form:form>
  </body>
</html>
