<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="blank-header.jsp"/>
<style>
    #login-card {
        padding: 0 !important;
        margin-top: 8vh;
        border: 1px solid #64b5f6;
    }

    #login-header {
        color: white;
        text-shadow: 1px 1px 1px rgba(50, 50, 50, 0.1);
        text-align: center;
        font-size: 24px;
        padding: 10px 0;
    }

    #login-body {
        padding-top: 40px;
        padding-bottom: 10px;
    }

    #submit-button, #forgot-button {
        text-align: center;
    }

</style>

<div class="container">
    <!-- outer card -->

    <div class="row">
        <div class="col m8 s12 offset-m2 card" id="login-card">
            <!--inner card-->
            <div class="col s12 blue lighten-2 card-title" id="login-header">
                Login
            </div>
            <div class="col s12 card-content" id="login-body">
                <c:if test="${requestScope.get(\"error\") != null}">
                    <div class="row">
                        <div class="col s12 center-align materialize-red-text">
                            <div>ERROR: ${requestScope.get("error")}</div>
                        </div>
                    </div>
                </c:if>
                <div class="row">
                    <form:form class="col s12" modelAttribute="user" method="post">
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <form:input path="name" id="username" placeholder="Enter username..." required="true"/>
                                    <%--<input id="username" type="text" placeholder="Enter username...">--%>
                                <label for="username">Username</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <form:input path="password" id="password" type="password"
                                            placeholder="Enter password..." required="true"/>
                                    <%--<input id="password" type="password" placeholder="Enter password...">--%>
                                <label for="password">Password</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <form:select path="role" id="role">
                                    <form:option value="0">Admin</form:option>
                                    <form:option value="1">Normal</form:option>
                                </form:select>
                                <label>Select a role</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12" id="submit-button">
                                <input type="submit" class="waves-effect waves-light btn blue lighten-2" value="LOGIN">
                            </div>
                        </div>
                        <%--<div class="row">--%>
                        <%--<div class="col s12"  id="forgot-button">--%>
                        <%--<a class="waves-effect waves-light btn white black-text">FORGOT PASSWORD?</a>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                    </form:form>
                </div>
            </div>
            <!--end inner card-->
        </div>
    </div>
    <!-- end outer card -->
</div>

<script>
    $(document).ready(() => {
        $("#role").material_select();
    });
</script>

<jsp:include page="footer.jsp"/>