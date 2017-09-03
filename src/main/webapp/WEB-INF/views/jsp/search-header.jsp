<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

        /*  Fix for search bar*/
        #search {
            height: 64px !important; /* or height of nav */
        }

        #main {
            padding-bottom: 48px;
        }

        #main-logo {
            margin-left: 24px;
        }

        #search {
            min-width: 14em;
        }

        #nav-mobile > li {
            padding-left: 10px;
            padding-right: 10px
        }

        #user-dropdown {
            margin-top: 64px;
        }

    </style>

</head>
<body>

<ul id="user-dropdown" class="dropdown-content">
    <li><a href="/logout">Log Out</a></li>
</ul>

<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper">
            <a href="/" class="brand-logo" id="main-logo">Renewable Energy Monitoring System</a>
            <form:form modelAttribute="search" action="/search/" method="post">
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li>
                        <div class="input-field">
                            <form:input path="text" id="search" type="search" required="true" placeholder="Search for a plant..."/>
                            <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                            <i class="material-icons">close</i>
                        </div>
                    </li>
                    <li>
                        <button type="submit" class="waves-effect waves-light btn">Go</button>
                    </li>
                    <li>
                        <a href="/notifications/">
                            <i class="large material-icons">chat_bubble_outline</i>
                        </a>
                    </li>
                    <c:if test="${userDetails.role == 0}">
                        <li>
                            <a href="/admin/" class="btn white black-text">ADMIN</a>
                        </li>
                    </c:if>
                    <li>
                        <a class="dropdown-button" href="#!" data-activates="user-dropdown">
                            Hello, ${userDetails.name}
                            <i class="material-icons right">arrow_drop_down</i>
                        </a>
                    </li>

                </ul>
            </form:form>
        </div>
    </nav>
</div>