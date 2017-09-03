<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"/>
<style>
    #header {
        height: 84px;
        padding-top: 24px;
        padding-left: 24px;
        box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14),
        0 1px 5px 0 rgba(0, 0, 0, 0.12),
        0 3px 1px -2px rgba(0, 0, 0, 0.2);
    }

    #header > h4 {
        color: #ee6e73;
        margin: 0;
    }

    #left-panel {
        min-height: 50vh;
        padding: 10px;
    }
</style>

<div id="main">
    <div class="row" id="header">
        <h4 class="center-align">User Management</h4>
    </div>
    <br>
    <div class="container">
        <div class="row">
            <div class="col offset-m3 m6 s12">
                <div class="card" id="left-panel">
                    <div class="row">
                        <div class="col s12">
                            <h5>Edit user details</h5>
                            <hr>
                        </div>
                    </div>
                    <div class="row">

                        <form:form class="col s12" method="post" modelAttribute="user">
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input path="name" id="username" type="text" placeholder="Enter username..."
                                                required="true"/>
                                    <label for="username">Username</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input path="email" id="email" type="email" placeholder="Enter email..."/>
                                    <label for="email">E-mail</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:select path="role" name="role" id="role">
                                        <form:option value="0">Admin</form:option>
                                        <form:option value="1">Normal</form:option>
                                    </form:select>
                                    <label>Role</label>
                                </div>
                            </div>
                            <div class="row center-align">
                                <div class="col s12" id="submit-button">
                                    <button type="submit" class="waves-effect waves-light btn blue lighten-2">SUBMIT
                                    </button>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <button type="reset" class="waves-effect waves-light btn white black-text"
                                            onclick="setTimeout(Materialize.updateTextFields, 10)">
                                        CLEAR
                                    </button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(() => {
        $('#role').material_select();
    });
</script>

<jsp:include page="footer.jsp"/>