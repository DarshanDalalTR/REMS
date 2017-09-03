<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>

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

    #left-panel {
        height: 680px;
        padding: 10px;
    }

    #left-panel {
        min-height: 50vh;
    }
</style>

<div id="main">
    <div class="row" id="header">
        <h4 class="center-align">Solar Plant Management</h4>
    </div>
    <br>
    <div class="container">
        <div class="row">
            <div class="col m6 push-m3 s12">
                <div class="card" id="left-panel">
                    <div class="row">
                        <div class="col s12">
                            <h5>Edit plant details</h5>
                            <hr>
                        </div>
                    </div>
                    <div class="row">
                        <form:form cssClass="col s12" method="post" modelAttribute="plant">
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input path="s_plant_name" id="plantname" type="text"
                                                placeholder="Enter plant name..." required="true"/>
                                    <label for="plantname">Plant name</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input path="s_plant_lat" id="latitude" type="text"
                                                placeholder="Enter latitude..." pattern="([0-9]*[.])?[0-9]+"/>
                                    <label for="latitude">Latitude (in decimal)</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input path="s_plant_lon" id="longitude" type="text"
                                                placeholder="Enter longitude..." pattern="([0-9]*[.])?[0-9]+"/>
                                    <label for="longitude">Longitude (in decimal)</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:input path="avg_radiation" id="radiation" type="text"
                                                placeholder="Enter average radiation..." pattern="([0-9]*[.])?[0-9]+"/>
                                    <label for="radiation">Average Radiation (W / m<sup>2</sup>)</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s8 offset-s2">
                                    <form:select path="state_id" id="state-select">
                                        <form:options items="${states}" itemValue="state_id" itemLabel="state_name"/>
                                    </form:select>
                                    <label>State</label>
                                </div>
                            </div>
                            <div class="row center-align">
                                <div class="col s12" id="submit-button">
                                    <button type="submit" class="waves-effect waves-light btn blue lighten-2">SUBMIT</button>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <button type="reset" class="waves-effect waves-light btn white black-text" onclick="setTimeout(Materialize.updateTextFields, 10)">CLEAR</button>
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
        $("#state-select").material_select();
    });
</script>

<jsp:include page="footer.jsp"/>