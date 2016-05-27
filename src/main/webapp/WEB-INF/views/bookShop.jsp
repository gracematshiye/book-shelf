<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div style="margin-top:100px;">

<c:choose>
  <c:when test="${!empty books}">
    <div class="panel panel-primary" style = "margin-top:100px; width: 500px; height: 300px; margin-left:500px;">
  <table class="table">
    <thead>
    <c:forEach items="${books}" var="book">
      <tr>
        <th>Book name</th>
        <th>Book ISBN NO.</th>
        <th>Book description</th>
        <th>Book price</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${book.name}</td>
        <td>${book.isbn}</td>
         <td>${book.description}</td>
        <td>${book.price}</td>
      </tr>
    </tbody>
  </table>
</c:forEach>
  </table>
  </div>
  </c:when>

  <c:otherwise>
    <h1>Book shelf is empty</h1>
  </c:otherwise>
</c:choose>

</div>
<hr>
<footer>
	<p>&copy; 2016</p>
</footer>
</body>
</html>
