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
    </head>
    <body>
        <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <a class="navbar-brand" href="#">
                <img src="${pageContext.request.contextPath}/resources/images/1.png" alt="">
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
        <div style="margin-top: 30px" class="container" >
            <div class="row">
                <c:forEach var="products" items="${productList}">
                    <div class="col-md-3 col-sm-6"> 
                        <div class="card">
                            <div class="card-block">
                                <div><img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/${products.image}" alt=""></div>
                                <div class="card-title">
                                    <h4>${products.name}</h4>
                                    <h5>${products.price} $</h5>
                                    <p class="card-text"></p>
                                </div>
                                <a style="margin-top: 10px;" href="${pageContext.request.contextPath}/addToCart/${products.id}" class="btn btn-success">Mua</a>
                                <a style="margin-top: 10px;" href="" class="btn btn-danger">Xem Chi Tiết</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
