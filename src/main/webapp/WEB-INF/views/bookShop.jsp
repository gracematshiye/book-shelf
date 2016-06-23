<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    //<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous" >

</head>

<body>

<nav class="navbar navbar-default navbar-fixed-top" style="margin-top:20px">
  <div class="container-fluid">
    <div class="navbar-header">
 			<a class="navbar-brand" href="#">Home</a>
 			<a class="navbar-brand"  href="#">
                <span class="glyphicon glyphicon-shopping-cart" style="margin-left: 1200px; margin-top:10px"></span>
                <span class="badge" style="margin-top:-40px; margin-left:-22px" >1</span>
            </a>
 		</div>
 	</div>
 </nav>

<div style = "margin-top:120px; margin-bottom:50px;">

<!-- Displaying books-->
<div class="container">
<center>
    <c:choose>
        <c:when test="${!empty books}">
            <ul>
                <c:forEach items="${books}" var="book">
                    <div style="box-shadow: 5px 5px 5px 5px #888888; width: 700px;">

                      <div class = "thumbnail" style="height: 200px; width:200px; margin-left:10px; margin-top:10px; ">
                             <img alt="Mountain View" style="width:100px;height:100px;">
                      </div>

                      <div class = "caption">
                          <div class="panel-heading"> ${book.name}</div>
                          <div class="panel-body"> <i style="color:red;"> R${book.price}</i></br><br/> ${book.description}</div>
                      </div>
                          <button type="button" class="btn btn-primary" style="margin-left:500px; margin-top:-50px;" onClick="click()">Add to Cart</button>

                    </div>
                </c:forEach>
            </ul>
        </c:when>

        <c:otherwise>
            <div style="box-shadow: 5px 5px 5px 5px #888888; width: 700px">
                <br/>
                <center>
                    <div class="icon-large icon-shopping-cart"><h2> Book shelf is empty</h2></div>
                    <h1>
                    <span class="glyphicon glyphicon-shopping-cart" style="height:200px; width: 200px"></span>
                    </h1>
                </center>
            </div>
        </c:otherwise>
    </c:choose>


</center>
</div>
</div>

<hr>
<footer>
<center>
	<p>&copy; 2016</p>
</center>
</footer>
</body>
</html>
