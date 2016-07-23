<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous" >

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


<div class = "container" style="margin-bottom:75px; margin-top:10px">

    <nav class="navbar navbar-default navbar-fnt navbar-fixed-top navbar-backgrnd" style="box-shadow: 3px 3px 3px rgba(0,0,0,0.1)">
        <div class="container-fluid">

            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/books">Book Shelf</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/books"><span class = "glyphicon glyphicon-home"></span>Home</a>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <a class="navbar-brand"  href="${pageContext.request.contextPath}/shop-cart/cart-list">
                        <span class="glyphicon glyphicon-shopping-cart" ></span>
                        <c:choose>
                            <c:when test="${!empty cartSize}">
                                <span class="badge"  style = "margin-top: -40px; margin-left:-23px">${cartSize}</span>
                            </c:when>

                            <c:otherwise>
                                 <span class="badge" >0</span>
                            </c:otherwise>
                        </c:choose>
                    </a>
                    <span ></span>
                </ul>
            </div>

        </div>
    </nav>

</div>
