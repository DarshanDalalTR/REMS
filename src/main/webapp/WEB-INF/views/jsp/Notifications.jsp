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
                    <span class="card-title center-align">Notifications</span>
                    <hr>
                </div>
                <div class="card-content">
                    <table class="bordered highlight" id="notification-table">
                        <thead>
                        <tr>
                            <th>Plant</th>
                            <th>Plant type</th>
                            <th>Notification</th>
                            <th>Component</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${notifications}" var="n">
                            <tr class="clickable-row" data-link="/plant/${n.plantType}/${n.plantId}/">
                                <td>${n.plantName}</td>
                                <td>${n.plantType}</td>
                                <td>${n.notif}</td>
                                <td>${n.plantComponent}</td>
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
    })
</script>

<jsp:include page="footer.jsp"/>