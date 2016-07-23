
<%@include file="header.jsp" %>

<div style = "margin-top:70px; " class="container">

    <!-- Displaying books-->
    <div class="container-fluid">
        <c:choose>
            <c:when test="${!empty books}">
                <ul>
                    <c:forEach items="${books}" var="book">
                        <div class="list-group-item" style = "width:800px; margin-top:30px; margin-left:100px">
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

                            <div style=" margin-left: 670px; ">
                                <a href="${pageContext.request.contextPath}/shop-cart/${book.id}" class="btn btn-primary btn-inverse" style="margin-bottom:5px" >Add to Cart</a>
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

<%@include file="footer.jsp" %>
