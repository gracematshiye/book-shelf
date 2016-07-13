

<div style = "margin-top:70px; ">

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
                        <a href="${pageContext.request.contextPath}/shop-cart/${book.id}" class="btn btn-primary" style="margin-bottom:20px" >Add to Cart</a>
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

