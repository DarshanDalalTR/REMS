<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<jsp:include page="header.jsp"/>
<style>
    .main {
        margin-top: 48px;
    }

    .add-card {
        height: 418px !important;
    }

    .no-mar-bot {
        margin-bottom: 0;
    }

    .add-card > .card-content {
        padding: 0;
        height: 100%;
    }

    .add-card > .card-content > .valign-wrapper {
        height: 100%;
    }

    .add-card > .card-content > .valign-wrapper > .center-align {
        width: 100%;
    }

    .card-icon {
        width: 48px;
        height: 48px;
        position: relative;
        top: 10px;
    }

    .card-desc {
        height: 32px;
        font-size: 18px;
        padding-top: 3px !important;
    }

</style>

<c:set var="admin" value="${userDetails.role == 0}"/>

<div class="main container">

    <div class="row no-mar-bot">
        <div class="col s12 center-align">
            <h4>${plant.s_plant_name}</h4>
        </div>
    </div>

    <div class="row">
        <div class="col s12 center-align">
            <a href="chart/" class="btn blue white-text">VIEW CHART</a>
        </div>
    </div>

    <div class="row">
        <div class="col s6 m4 no-mar-bot">
            <div class="card card-alert blue lighten-3 hoverable">
                <div class="col s3 no-mar-bot">
                    <img src="/resources/images/s.png" alt="turbine"
                         class="circle alert-circle card-icon">
                </div>
                <div class="col s9 no-mar-bot">
                    <div class="col s12 center-align no-mar-bot num">
                        ${plates.size()}
                    </div>
                </div>
                <div class="col s12 card-desc white center-align card-desc">
                    No. of panels
                </div>
            </div>
        </div>
        <div class="col s6 m4 no-mar-bot">
            <div class="card card-alert blue lighten-3 hoverable">
                <div class="col s3 no-mar-bot">
                    <img src="/resources/images/fastcharching.jpg" alt="turbine"
                         class="circle alert-circle card-icon">
                </div>
                <div class="col s9 no-mar-bot">
                    <div class="col s12 center-align no-mar-bot num">
                        <fmt:formatNumber value="${total_energy}" maxFractionDigits="2"/> MW
                    </div>
                </div>
                <div class="col s12 card-desc white center-align card-desc">
                    Total energy (MW)
                </div>
            </div>
        </div>
        <div class="col s6 m4 no-mar-bot">
            <div class="card card-alert blue lighten-3 hoverable">
                <div class="col s3 no-mar-bot">
                    <img src="/resources/images/sun.jpg" alt="turbine"
                         class="circle alert-circle card-icon">
                </div>
                <div class="col s9 no-mar-bot">
                    <div class="col s12 center-align no-mar-bot num">
                        <fmt:formatNumber value="${plant.avg_radiation}" maxFractionDigits="0"/>
                    </div>
                </div>
                <div class="col s12 card-desc white center-align card-desc">
                    Average Radiation (W/m<sup>2</sup>)
                </div>
            </div>
        </div>
    </div>

    <div class="cardholder">
        <div class="row">
            <div class="col s12 l12">
                <div class="backcard card blue-grey lighten-5 valign  z-depth-3">
                    <div class="card-content ">
                        <div class="row">
                            <c:forEach var="plate" items="${plates}">
                                <div class="col s12 l3 m4">
                                    <div class="turbinecard card grey lighten-4">
                                        <div class="card-content content1">
                                            <p class="turbinename">${plate.plate_name}
                                                <img src="/resources/images/solar-panel-icon.png" alt="turbine"
                                                     class="responsive-img valign circle card-circle"></p>
                                        </div>
                                        <div class="card-content blue lighten-4 content2">
                                            <p class="date" style="color:#757575;">
                                                    <%--<fmt:parseDate value="${plate.last_updated}"/>--%>
                                            </p>
                                            <c:forEach var="msg" items="${plate.notifs}">
                                                <p class="urgent"><span style="color: red;">URGENT</span>:
                                                        ${msg.text}
                                                </p>
                                            </c:forEach>
                                            <p class="total" style="color:darkblue">
                                                <fmt:formatNumber
                                                        value="${plate.qty*plate.plate_efficiency*plate.plate_area*plate.plate_perf_ratio*plant.avg_radiation / 1000000}"
                                                        maxFractionDigits="2"/> MW
                                            </p>
                                        </div>
                                        <div class="card-content content3">
                                            <div class="row value">
                                                <div class="col s9 data">
                                                    <p>Plate Area:</p>
                                                </div>
                                                <div class="col s3 coef"> ${plate.plate_area}</div>
                                                <div class="col s9 data">
                                                    <p>Plate-efficiency:</p>
                                                </div>
                                                <div class="col s3 blade"> ${plate.plate_efficiency}</div>
                                                <div class="col s9 data">
                                                    <p>Quantity:</p>
                                                </div>
                                                <div class="col s3 blade"> ${plate.qty}</div>
                                                <div class="col s9 data">
                                                    <p>Plate Perf. ratio:</p>
                                                </div>
                                                <div class="col s3 blade"> ${plate.plate_perf_ratio}</div>
                                            </div>
                                        </div>
                                        <c:if test="${admin}">
                                            <div class="card-content content4">
                                                <div class="row">
                                                    <div class="col s12 right-align">
                                                        <a href="editPanel/${plate.plate_id}/"
                                                           class="btn-floating btn-large waves-effect waves-light blue lighten-2"><i
                                                                class="material-icons">edit</i></a>
                                                        <a href="deletePlate/${plate.plate_id}/"
                                                           class="btn-floating btn-large waves-effect waves-light red"><i
                                                                class="material-icons">delete</i></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </c:forEach>
                            <c:if test="${admin}">
                                <div class="col s12 l3 m4">
                                    <div class="turbinecard card grey lighten-4 add-card">
                                        <div class="card-content">
                                            <div class="valign-wrapper">
                                                <div class="center-align">
                                                    <a href="addPanel/"
                                                       class="btn-floating btn-large waves-effect waves-light red"><i
                                                            class="material-icons">add</i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${!admin && plates.size() == 0}">
                                <div class="col s12 center-align no-mar-bot">
                                    <h5 class="no-mar-bot">No plates present in the selected plant.</h5>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>