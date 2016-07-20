

<%@include file="header.jsp" %>


<div style = "margin-top:95px">
    <table>
        <tr>
            <td>
                <a href = "${pageContext.request.contextPath}/shop-cart/empty-cart" class="btn btn-primary btn-inverse" style = "margin-left: 150px;"> Empty Cart </a>
            </td>

            <td>
                <a href = "#" class="btn btn-primary btn-inverse" style = "margin-left:957px"> Checkout </a>
            </td>
        </tr>
    </table>
</div>

<div style = "margin-top:20px">

<c:choose>
    <c:when test="${!empty cartList}">
        <c:forEach items="${cartList}" var="book">
            <div >

                <!-- Displaying book cart list-->
                <div class="container" >

                    <ul class="list-group">
                        <li class="list-group-item">
                            <table class="table table-hover results">
                                <thead>
                                    <tr>
                                        <th class="col-md-2 col-xs-2">Book Name</th>
                                        <th class="col-md-2 col-xs-2">Book ISBN</th>
                                        <th class="col-md-2 col-xs-2">Book Price</th>
                                        <th class="col-md-4 col-xs-4">Book Description</th>
                                        <th class="col-md-1 col-xs-1"><a href="${pageContext.request.contextPath}/shop-cart/cart-remove/${book.id}"class = "glyphicon glyphicon-remove" style = "margin-left: 70px; color:red"></a></th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <td>
                                            ${book.name}
                                        </td>

                                        <td >
                                            ${book.isbn}
                                        </td>

                                        <td >
                                            ${book.price}
                                        </td>

                                        <td >
                                            ${book.description}
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </li>
                    </ul>

                </div>
            </div>

        </c:forEach>

    </c:when>

    <c:otherwise>
         <div style = "margin-top:20px; ">

            <!-- Displaying book cart list-->
            <div class="container" >

                <ul class="list-group">

                  <li class="list-group-item">
                    <center>
                        <div class="icon-large icon-shopping-cart"><h2> Cart list is empty</h2></div>
                        <h1>
                       <span class="glyphicon glyphicon-shopping-cart" ></span>
                       </h1>
                   </center>
                  </li>

                </ul>

            </div>
        </div>
    </c:otherwise>
</c:choose>
</div>


<%@include file="footer.jsp" %>
