<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<style>
    #main {
        padding-top: 100px;
    }

    .clickable-row {
        cursor: pointer;
    }
</style>

<div id="main" class="valign-wrapper">
    <div class="container">
        <div class="row">
            <div class="col s12 card">
                <div class="card-content">
                    <span class="card-title">Displaying search results for: <b>${query}</b></span>
                    <hr>
                </div>
                <div class="card-content">
                    <table class="bordered highlight" id="notification-table">
                        <thead>
                        <tr>
                            <th>Plant Type</th>
                            <th>Plant Name</th>
                            <th>State</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${plants}" var="p">
                            <tr class="clickable-row" data-link="/plant/${p.plant_type}/${p.plant_id}/">
                                <td>${p.plant_type}</td>
                                <td>${p.plant_name}</td>
                                <td>${p.state}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <br>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(() => {
        $('.clickable-row').on('click', function () {
            window.location = $(this).data('link');
        });
    });
</script>

<jsp:include page="footer.jsp"/>