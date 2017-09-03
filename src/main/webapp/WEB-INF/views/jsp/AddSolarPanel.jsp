<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<jsp:include page="header.jsp"/>

<style>

    #form-card {
        padding: 0 !important;
        margin-top: 8vh;
        border: 1px solid #64b5f6;
    }

    #form-header {
        color: white;
        text-shadow: 1px 1px 1px rgba(50, 50, 50, 0.1);
        text-align: center;
        font-size: 24px;
        padding: 10px 0;
    }

    #form-body {
        padding-top: 40px;
        padding-bottom: 10px;
    }

</style>

<div class="container" id="main">
    <!-- outer card -->
    <div class="row">
        <div class="col m8 s12 offset-m2 card" id="form-card">
            <!--inner card-->
            <div class="blue lighten-2 card-title" id="form-header">
                Panel Details
            </div>
            <div class="col s12 card-content" id="form-body">
                <div class="row">
                    <form:form method="post" modelAttribute="panel" cssClass="col s12">
                        <!--<form class="col s12">-->
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <input id="plantname" type="text" value="<STATIC PLANT NAME>" disabled>
                                <label for="plantname">Plant Name</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <form:input path="plate_name" id="plate-name"
                                            placeholder="Enter plate name..." required="true"/>
                                <!--<input id="plate-name" type="text" placeholder="Enter plate name...">-->
                                <label for="plate-name">Plate name</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <form:input path="plate_area" id="plate-area"
                                            placeholder="Enter plate area..." pattern="([0-9]*[.])?[0-9]+"/>
                                <!--<input id="plate-area" type="text" placeholder="Enter plate area...">-->
                                <label for="plate-area">Plate area (in m<sup>2</sup>)</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s6 offset-s3">
                                <div class="row">
                                    <div class="col s6 input-field">
                                        <form:input path="plate_efficiency" id="efficiency"
                                                    placeholder="Enter efficiency..." pattern="([0-9]*[.])?[0-9]+"/>
                                        <!--<input id="efficiency" type="text" placeholder="Enter efficiency...">-->
                                        <label for="efficiency">Efficiency (0 - 1)</label>
                                    </div>
                                    <div class="col s6 input-field">
                                        <form:input path="plate_perf_ratio" id="perf-ratio"
                                                    placeholder="Enter performance ratio..." pattern="([0-9]*[.])?[0-9]+"/>
                                        <!--<input id="perf-ratio" type="text" placeholder="Enter performance ratio...">-->
                                        <label for="perf-ratio">Performance Ratio (0 - 1)</label>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <form:input path="qty" id="quantity" placeholder="Enter quantity..." pattern="[0-9]*"/>
                                <!--<input id="quantity" type="text" placeholder="Enter quantity...">-->
                                <label for="quantity">Quantity</label>
                            </div>
                        </div>
                        <div class="row center-align">
                            <div class="col s12" id="submit-button">
                                <button type="submit" class="waves-effect waves-light btn btn-block blue lighten-2">SUBMIT</button>
                            </div>
                        </div>
                        <div class="row center-align">
                            <div class="col s12" id="forgot-button">
                                <button type="reset" class="waves-effect waves-light btn white black-text" onclick="setTimeout(Materialize.updateTextFields, 10)">CLEAR</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
            <!--end inner card-->
        </div>
    </div>
    <!-- end outer card -->
</div>
<!--Import jQuery before materialize.js-->
<jsp:include page="footer.jsp"/>