
<%@include file="header.jsp" %>

<div style = "margin-top:95px" class="container">
<c:forEach items="${customers}" var="customer">
${customer.name}
</c:forEach>
    <c:url var="addAction" value="/shop-cart/customer/add" ></c:url>

    <div align="center" class="form-group" >
        <h4 style="box-shadow: 3px 3px 3px rgba(0,0,0,0.1); width:450px; margin-bottom: 20px; height:80px; color: rgb(0, 51, 204)"> Fill in your personal details below </h4>
            <form method="post" action="${addAction}" modelAttribute="customer">
                <table border="0">
                    <tr>
                        <td>
                            <div class="form-group">
                                <label  class="col-xs-2 control-label pull-left">Name</label>
                                <input type="text"  class="form-control" name="name" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="form-group">
                                <label  class="col-xs-2 control-label pull-left">Surname</label>
                                <input type="text"  class="form-control" name="surname" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="form-group">
                                <label  class="col-xs-2 control-label pull-left">Contact</label>
                                <input type="text"  class="form-control" name="contact" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="form-group">
                                <label  class="col-xs-2 control-label pull-left">Email</label>
                                <input type="email"  class="form-control" name="email" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="form-group">
                                <label  class="col-xs-2 control-label pull-left">Address</label>
                                <textarea type="text"  class="form-control" name="address" ></textarea>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td ><input type="submit" class="btn btn-primary" value="Proceed" style="float:right;"/></td>
                    </tr>
                </table>
            </form>
    </div>
</div>

<%@include file="footer.jsp" %>