<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<style>
    #header {
        height: 84px;
        padding-top: 24px;
        padding-left: 24px;
        box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12), 0 3px 1px -2px rgba(0, 0, 0, 0.2);

    }

    #header > h4 {
        color: #ee6e73;
        margin: 0;
    }

    #left-panel, #right-panel {
        height: 680px;
        padding: 10px;
    }

    #right-panel, #left-panel {
        min-height: 50vh;
    }

    #right-panel {
        width: 100%;
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
        <h4 class="center-align">Solar Plant Management</h4>
    </div>
    <br>
    <div class="container">
        <div class="row">
            <div class="col m6 s12">
                <div class="card" id="left-panel">
                    <div class="row">
                        <div class="col s12">
                            <h5>Create new plant</h5>
                            <hr>
                        </div>
                    </div>
                    <div class="row">
                        <form:form class="col s12" method="post" modelAttribute="plant" action="add/">
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input id="plantname" path="s_plant_name" type="text"
                                                placeholder="Enter Plant name..." required="true"/>
                                    <label for="plantname">Plant name</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input id="latitude" path="s_plant_lat" type="text"
                                                placeholder="Enter latitude..." pattern="([0-9]*[.])?[0-9]+"/>
                                    <label for="latitude">Latitude</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input id="longitude" path="s_plant_lon" type="text"
                                                placeholder="Enter longitude..." pattern="([0-9]*[.])?[0-9]+"/>
                                    <label for="longitude">Longitude</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input id="radiation" path="avg_radiation" type="text"
                                                placeholder="Enter average radiation..." pattern="([0-9]*[.])?[0-9]+"/>
                                    <label for="radiation">Average Radiation</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:select path="state_id" id="state-select">
                                        <form:options items="${states}" itemValue="state_id"
                                                      itemLabel="state_name"/>
                                    </form:select>
                                    <label>State</label>
                                </div>
                            </div>
                            <div class="row center-align">
                                <div class="col s12" id="submit-button">
                                    <button type="submit" class="waves-effect waves-light btn blue lighten-2">SUBMIT</button>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <button type="reset" class="waves-effect waves-light btn white black-text"
                                            onclick="setTimeout(Materialize.updateTextFields, 10)">CLEAR
                                    </button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="col m6 s12">
                <div class="card" id="right-panel">
                    <div class="row">
                        <div class="col s12">
                            <h5>View existing plants</h5>
                            <hr>
                        </div>
                        <div class="col s12" id="users-list-wrapper">
                            <div class="col s12" id="users-list">
                                <c:forEach items="${plants}" var="p">
                                    <div class="user">
                                        <div class="row">
                                            <div class="user-name">${p.s_plant_name}</div>
                                        </div>
                                        <div class="row">
                                            <a class="delete btn red waves-effect waves-light"
                                               href="${p.plant_id}/delete/">
                                                Delete
                                            </a>
                                            <a class="modify btn"
                                               href="${p.plant_id}/edit/">
                                                Modify
                                            </a>
                                        </div>
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
        $("#state-select").material_select();
    });
</script>

<jsp:include page="footer.jsp"/>