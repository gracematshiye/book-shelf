<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Title</title>

    <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous" >

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
</head>

<body>

<nav class="navbar navbar-default navbar-fixed-top" style="Height:70px; margin-top:-5px">
  <div class="container-fluid" style="margin-top:20px">
    <div class="navbar-header">
 			<a class="navbar-brand" href="#">Home</a>
 			<a class="navbar-brand"  href="#">
                <span class="glyphicon glyphicon-shopping-cart" style="margin-left: 1200px; margin-top:10px"></span>
                <span class="badge" style="margin-top:-40px; margin-left:-22px" >${book_size}</span>
            </a>
 		</div>
 	</div>
 </nav>

<div style = "margin-top:120px; margin-bottom:50px;">

<!-- Displaying books-->
<div class="container" style="margin-left: 350px">

<c:choose>
    <c:when test="${!empty books}">
        <ul>
            <c:forEach items="${books}" var="book">
                <div style="box-shadow: -1px 0px 5px 3px rgba(212,212,219,1); width: 700px; margin-bottom: 20px;">
                    <u><h3><b>Book Number #${book.id}</b></h3></u>

                    <div style="margin-left:20px">
                        <img src = "<c:url value="/resources/images/book.jpg"/>" style="width:200px;height:200px;">
                    </div>

                    <div style="margin-top:-200px; margin-left:250px">
                        <b>${book.name}</b>
                    </div>

                    <div style="margin-left: 235px;">
                        <div class="panel-body" style="margin-bottom:130px; color:red;"> R ${book.price}</div>
                    </div>

                    <div style="margin-top:150px">
                        <ul>
                            <ol>
                                ${book.description}
                            </ol>
                        </ul>
                    </div>

                    <div style=" margin-left: 550px; ">
                        <a href="#" class="btn btn-primary" style="margin-bottom:20px" >Add to Cart</a>
                    </div>

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



</div>
</div>


<footer style="background-color:#f5f5f5">
<hr>
<div class="container">
    <center>
        <p>&copy; 2016</p>
    </center>
    <hr>

    <div class="text-center center-block">
    <p class="txt-railway">- book-shelf.com -</p>
        <br />
            <a href="#"><i id="social-fb" class="fa fa-facebook-square fa-3x social"></i></a>
            <a href="#"><i id="social-tw" class="fa fa-twitter-square fa-3x social"></i></a>
            <a href="#"><i id="social-gp" class="fa fa-google-plus-square fa-3x social"></i></a>
    </div>

</footer>
</body>
</html>
