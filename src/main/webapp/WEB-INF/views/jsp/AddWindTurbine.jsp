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

    #submit-button, #forgot-button {
        text-align: center;
    }

    #nav-mobile > li {
        padding-left: 10px;
        padding-right: 10px
    }
</style>


<div class="container" id="main">
    <!-- outer card -->
    <div class="row">
        <div class="col m8 s12 offset-m2 card" id="form-card">
            <!--inner card-->
            <div class="blue lighten-2 card-title" id="form-header">
                New Turbine
            </div>
            <div class="col s12 card-content" id="form-body">
                <div class="row">
                    <form:form cssClass="col s12" modelAttribute="turbine">
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <input id="plantname" type="text" value="<STATIC PLANT NAME>" disabled>
                                <label for="plantname">Plant Name</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <form:input path="turbine_name" id="turbine-name" placeholder="Enter turbine name..." required="true"/>
                                <!--<input id="turbine-name" type="text" placeholder="Enter turbine name...">-->
                                <label for="turbine-name">Turbine name</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <form:input path="blade_length" id="blade-length" placeholder="Enter blade length..." pattern="([0-9]*[.])?[0-9]+"/>
                                <!--<input id="blade-length" type="text" placeholder="Enter blade length...">-->
                                <label for="blade-length">Blade Length (in m)</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <form:input path="power_coeff" id="power-coefficient"
                                            placeholder="Enter power coefficient..." pattern="[0]*[.][0-9]+"/>
                                <!--<input id="power-coefficient" type="text" placeholder="Enter power coefficient...">-->
                                <label for="power-coefficient">Power Coefficient (0 - 1)</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <form:input path="qty" id="quantity" placeholder="Enter quantity..." pattern="[0-9]*"/>
                                <!--<input id="quantity" type="text" placeholder="Enter quantity...">-->
                                <label for="quantity">Quantity</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12" id="submit-button">
                                <button type="submit" class="waves-effect waves-light btn blue lighten-2">SUBMIT</button>
                            </div>
                        </div>
                        <div class="row">
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