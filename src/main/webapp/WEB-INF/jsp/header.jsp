<%-- 
    Document   : header
    Created on : Oct 16, 2020, 11:05:08 AM
    Author     : Laptop
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    </body>
</html>
