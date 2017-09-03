<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="/resources/css/materialize.min.css" media="screen,projection"/>
    <link rel="stylesheet" href="/resources/css/style.css">
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/materialize.min.js"></script>
    <script type="text/javascript" src="/resources/js/Chart.bundle.min.js"></script>

    <title>REMS</title>

    <style>

        #main {
            padding-bottom: 48px;
        }

        #main-logo {
            margin-left: 24px;
        }

        #nav-mobile > li {
            padding-left: 10px;
            padding-right: 10px
        }

        #user-dropdown {
            margin-top: 64px;
        }

    </style>

    <title>${title}</title>

</head>
<body>

<ul id="user-dropdown" class="dropdown-content">
    <li><a href="/logout">Log Out</a></li>
</ul>

<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper">
            <a href="/" class="brand-logo" id="main-logo">Renewable Energy Monitoring System</a>
            <form>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li>
                        <a href="/notifications/">
                            <i class="large material-icons">chat_bubble_outline</i>
                        </a>
                    </li>
                    <li>
                        <a href="/map/" class="btn">MAP</a>
                    </li>
                    <c:if test="${userDetails.role == 0}">
                        <li>
                            <a href="/admin/" class="btn white black-text">ADMIN PANEL</a>
                        </li>
                    </c:if>
                    <li>
                        <a class="dropdown-button" href="#!" data-activates="user-dropdown">
                            Hello, ${userDetails.name}
                            <i class="material-icons right">arrow_drop_down</i>
                        </a>
                    </li>

                </ul>
            </form>
        </div>
    </nav>
</div>