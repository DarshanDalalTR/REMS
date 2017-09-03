<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>

<style>

    #right-panel, #left-panel {
        padding: 10px;
        min-height: 580px;
    }

    #right-panel {
        height: 100px;
        width: 100%;
        max-height: 50vh;
        overflow-y: scroll;
        overflow-x: hidden;
    }

    #users-list {
        height: 100%;
        display: inline-block;
        vertical-align: top;
    }

    #users-list-wrapper {
        padding-top: 10px;
        height: 100%;
        display: table-row;
    }

    .modify, .delete {
        position: relative;
        top: -7px;
        margin-left: 10px;
        float: right;
    }

    .user {
        padding: 10px;
        clear: both;
    }

    .user-name {
        margin-top: 10px;
        display: inline;
    }
</style>

<div id="main">
    <div class="row" id="header">
        <h4 class="center-align">User Management</h4>
    </div>
    <br>
    <div class="container">
        <div class="row">
            <div class="col m6 s12">
                <div class="card" id="left-panel">
                    <div class="row">
                        <div class="col s12">
                            <h5>Create new user</h5>
                            <hr>
                        </div>
                    </div>
                    <div class="row">
                        <form:form cssClass="col s12" method="post" modelAttribute="user" action="add/">
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input id="username" path="name" placeholder="Enter username..."
                                                required="true"/>
                                        <%--<input id="username" type="text" placeholder="Enter username...">--%>
                                    <label for="username">Username</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input id="email" path="email" placeholder="Enter email..." required="true"/>
                                        <%--<input id="email" type="text" placeholder="Enter email...">--%>
                                    <label for="email">E-mail</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input id="password" type="password" path="password"
                                                placeholder="Enter password..." required="true"/>
                                    <label for="password">Password</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:select path="role">
                                        <form:option value="1">Normal</form:option>
                                        <form:option value="0">Admin</form:option>
                                    </form:select>
                                    <label>Role</label>
                                </div>
                            </div>
                            <div class="row center-align">
                                <button type="submit" class="waves-effect waves-light btn blue lighten-2">SUBMIT
                                </button>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="reset" class="waves-effect waves-light btn white black-text"
                                        onclick="setTimeout(Materialize.updateTextFields, 10)">CLEAR
                                </button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="col m6 s12">
                <div class="card" id="right-panel">
                    <div class="row">
                        <div class="col s12">
                            <h5>View existing users</h5>
                            <hr>
                        </div>
                        <div class="col s12" id="users-list-wrapper">
                            <div class="col s12" id="users-list">
                                <c:forEach var="u" items="${users}">
                                    <div class="user">
                                        <div class="user-name">${u.name}</div>
                                        <a class="delete btn red waves-effect waves-light"
                                           href="/admin/user/${u.id}/delete/">
                                            Delete
                                        </a>
                                        <a class="modify btn"
                                           href="/admin/user/${u.id}/edit/">
                                            Modify
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(() => {
        $("#role").material_select();
    });
</script>

<jsp:include page="footer.jsp"/>