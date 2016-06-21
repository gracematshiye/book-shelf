<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Title</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
 </head>

 <body>

 <nav class="navbar navbar-inverse navbar-fixed-top">
 	<div class="container">
 		<div class="navbar-header">
 			<a class="navbar-brand" href="#">Home</a>
 		</div>
 	</div>
 </nav>

<div style = "margin-top: 50px; margin-bottom:50px;">

<!-- Displaying books-->
<hr>
<div class="container">
<center>
    <c:choose>
        <c:when test="${!empty books}">
            <ul>
                <c:forEach items="${books}" var="book">
                <div class="panel panel-primary" style = "width: 600px; ">
                      <div class = "thumbnail" style="height: 200px; width:200px; margin-left:10px; margin-top:10px">
                             <img alt="Mountain View" style="width:100px;height:100px;">
                      </div>

                      <div class = "caption">
                          <div class="panel-heading"> ${book.name}</div>
                          <div class="panel-body"> <i style="color:red;"> R${book.price}</i></br><br/> ${book.description}</div>
                      </div>
                          <a href="#" class="btn btn-primary" style="margin-left:500px; margin-top:-50px;">Add to Cart</a>
                </div>
                </c:forEach>
            </ul>
        </c:when>

        <c:otherwise>
            <center>
                <div class="icon-large icon-shopping-cart"><h2> Book shelf is empty</h2></div>
            </center>
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
