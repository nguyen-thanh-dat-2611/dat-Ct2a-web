<%-- 
    Document   : home
    Created on : Sep 23, 2020, 9:38:00 AM
    Author     : Laptop
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Đ&Đ Shop</title>
        <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/css/shop-homepage.css'/>" rel="stylesheet">
        <script src="<c:url value='/resources/jquery/jquery.js'/>" type="text/javascript"></script>

        <script src="<c:url value='/resources/jquery/jquery.min.js'/>"></script>
        <script src="<c:url value='/resources/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
        <link href="<c:url value='/resources/css/cart.css'/>" rel="stylesheet" type="text/css"/>
        <script src="https://use.fontawesome.com/c560c025cf.js"></script>
    </head>
    <body>
        <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <a class="navbar-brand" href="#">
                <img src="${pageContext.request.contextPath}/resources/images/14.png" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <form class="example" action="${pageContext.request.contextPath}/search" method="get" style="margin:auto;">
                    <input style=" mwidth: 500px; height: 50px" type="text" name="searchText" id="searchText" value="${model.productList}" placeholder="Search...">
                    <button style= "color: red ;width: 100px; height: 50px" type="submit">Tìm kiếm<i class="fa fa-search"></i></button>

                </form>
                    <li class="nav-item active">
                        <a class="nav-link" href="http://localhost:8080/web/">Trang chủ<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Sản phẩm
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <c:forEach var="category" items="${categoryList}">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/productListByCategory/${category.id}">${category.categoryname}</a>
                            </c:forEach>
                        </div> 
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="contact">Liên hệ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="#">Đăng nhập</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="register">Đăng ký</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="cart">Giỏ hàng</a>
                    </li>
                </ul>

            </div>
        </nav>
        </header>
        
        <div style="margin-top: 30px" class="row">
            <div class="col-md-12">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Images</th>
                            <th>Products Name</th>
                            <th>Configuration Info</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Amount</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="h" value="0"></c:set>
                        <c:forEach var="orderDetails" items="${cart.orderDetailsList}">
                            <tr>
                                <td>
                                    <img src="${pageContext.request.contextPath}/resources/images/${orderDetails.products.image}" class="img-cart" >
                                </td>
                                <td>${orderDetails.products.name}</td>
                                <td>${orderDetails.products.configurationInfo}</td>
                                <td>${orderDetails.products.price}</td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/update" method="post">
                                        <input type="hidden" name="id"
                                            value='${orderDetails.products.id}'/>
                                        <input type="number" name="quantity"
                                            accept=""value='${orderDetails.quantity}'style="width: 100px"/>
                                    </form>
                                </td>
                                <td>${orderDetails.total}</td>
                                <td><a href="${pageContext.request.contextPath}/delete/${orderDetails.products.id}"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tr>
                        <th colspan="2">Total Amount</th> 
                        <td colspan="5">${cart.total}</td>         
                    </tr>
                </table>
            </div>
        </div>
        <a href="http://localhost:8080/web/" class="btn btn-success"><span class="glyphicon glyphicon-arrow-left"></span>&nbsp;Continue Shopping</a>
        <a href="${pageContext.request.contextPath}/addNewOrder1" class="btn btn-primary pull-right">Check Out</a>
    </body>
</html>
