<%--
  Created by IntelliJ IDEA.
  User: achar
  Date: 29-07-2017
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="blank-header.jsp"/>

<style>
    #main {
        margin-top: 14vh;
    }

    #right {
        height: 375px;
    }
</style>

<div id="main">
    <div class="container">
        <div class="row">
            <h2 class="center-align red-text">OOPS! Something went wrong!</h2>
        </div>
        <div class="row">
            <div class="col s6">
                <img src="/resources/images/error.png">
            </div>
            <div class="col s6 valign-wrapper" id="right">
                <h4>${errorMsg}</h4>
            </div>
        </div>
        <div class="row">
            <div class="col s12 center-align">
                <a href="/" class="btn materialize-red">GO TO HOME</a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
