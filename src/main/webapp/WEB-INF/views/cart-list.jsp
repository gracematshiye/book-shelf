
<%@include file="header.jsp" %>

<div class = "container">
    <div class = "container-fluid">
        <c:if test="${!empty cartList}">
           <a href = "${pageContext.request.contextPath}/shop-cart/cart-empty" class="btn btn-primary " style="float:left;"> Empty Cart </a>
           <a href = "${pageContext.request.contextPath}/shop-cart/cart-checkout"  class="btn btn-primary" style="float:right;"> Checkout </a>
        </c:if>

        <div class="row">
            <div class="col-xs-12">
                <div class="table-responsive">
                    <c:choose>
                        <c:when test="${!empty cartList}">
                            <c:forEach items="${cartList}" var="book">

                            <div class="list-group-item" style = "margin-top:10px; margin-bottom:10px">
                                <table class="table table-hover  results">
                                    <thead>
                                        <tr>
                                            <th class="col-md-2 col-xs-2">
                                                Book Name
                                            </th>

                                            <th class="col-md-2 col-xs-2">
                                                Book ISBN
                                            </th>

                                            <th class="col-md-2 col-xs-2">
                                                Book Price
                                            </th>

                                            <th class="col-md-4 col-xs-4">
                                                Book Description
                                            </th>

                                            <th class="col-md-1 col-xs-1">
                                                <a href="${pageContext.request.contextPath}/shop-cart/cart-remove/${book.id}"class = "glyphicon glyphicon-remove" style = "margin-left: 70px; color:red"></a>
                                            </th>
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

                                            <td>
                                                <img src = "<c:url value="/resources/images/book.jpg"/>" style="width:0px;height:40px;">
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            </c:forEach>

                        </c:when>
                        <c:otherwise>
                            <div class="list-group-item" style = "margin-top:10px; margin-bottom:10px">
                                <center>
                                    <div class="icon-large icon-shopping-cart"><h2> Cart list is empty</h2></div>
                                    <h1><span class="glyphicon glyphicon-shopping-cart" ></span></h1>
                               </center>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
         <c:choose>
            <c:when test="${!empty cartList}">
                <span class="label label-default" style="float:right; width:200px; ">
                    <h5>
                    Total: R ${cartTotal}
                    </h5>
                </span>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>

    </div>
</div>
<%@include file="footer.jsp" %>
