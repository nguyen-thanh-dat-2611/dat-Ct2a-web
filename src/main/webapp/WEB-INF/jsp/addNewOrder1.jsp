<%-- 
    Document   : addNewOrder
    Created on : 01-08-2020, 20:00:27
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đ&Đ Shop</title>
        
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    </head>
    <body>
        <div class="container wrapper">
            <div class="row cart-body">
                <mvc:form class="form-horizontal" modelAttribute="order" action="${pageContext.request.contextPath}/addNewOrder" method="post" >
                    <div class="panel panel-info">
                        <div class="panel-heading">Address</div>
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <h4>Shipping Address</h4>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>Full Name:</strong></div>
                                <div class="col-md-12">
                                    <mvc:input type="text" class="form-control" id="validationDefault03" placeholder="Full Name" path="customerName" required="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>Address:</strong></div>
                                <div class="col-md-12">
                                    <mvc:input type="text" class="form-control" id="validationDefault03" placeholder="Address" path="customerAddress" required="true"  />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>Phone Number:</strong></div>
                                <div class="col-md-12">
                                    <mvc:input type="text" class="form-control" id="validationDefault03" placeholder="Phone Number" path="phone" required="true" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>Email Address:</strong></div>
                                <div class="col-md-12">
                                    <mvc:input type="text" class="form-control" id="validationDefault03" placeholder="Email Address" path="email" required="true" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <button type="submit" value="Save" class="btn btn-success">Submit</button>
                                </div>
                            </div>
                        </div>
                    </div>
            </mvc:form>
            </div>
        </div>
    </body>
</html>