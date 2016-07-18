<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous" >

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>

<header>
<nav class="navbar navbar-default navbar-fixed-top" style="Height:70px; margin-top:-5px">
  <div class="container-fluid" style="margin-top:20px">
    <div class="navbar-header">
 			<a class="navbar-brand" href="${pageContext.request.contextPath}/books">Home</a>
 			<a class="navbar-brand"  href="${pageContext.request.contextPath}/shop-cart/cart-list">
                <span class="glyphicon glyphicon-shopping-cart" style="margin-left: 1185px; margin-top:10px"></span>
                <c:choose>
                    <c:when test="${!empty cartSize}">
                        <span class="badge" style="margin-top:-40px; margin-left:-22px" >${cartSize}</span>
                    </c:when>

                    <c:otherwise>
                         <span class="badge" style="margin-top:-40px; margin-left:-22px" >0</span>
                    </c:otherwise>
                </c:choose>
            </a>
 		</div>
 	</div>
 </nav>
</header>

