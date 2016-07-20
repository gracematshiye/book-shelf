<%@include file="header.jsp" %>

<div style = "margin-top:95px">
    <div align="center" class="form-group" >
            <form method="POST" modelAttribute="customer">
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
                                <input type="text"  class="form-control" name="phone" />
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
                        <td ><input type="submit" class="btn btn-primary" value="Proceed" /></td>
                    </tr>
                </table>
            </form>
    </div>
</div>
<%@include file="footer.jsp" %>