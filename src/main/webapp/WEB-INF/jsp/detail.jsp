<%-- 
    Document   : detail
    Created on : Oct 21, 2020, 9:30:47 AM
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
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="<c:url value='/resources/css/detail.css'/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div style="margin-top: 30px" class="container">
            <div class="card">
                <div class="row">
                    <aside class="col-sm-5 border-right">
                        <article class="gallery-wrap">
                            <div class="img-big-wrap">
                                <div>
                                    <a href="#"><img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/${products.image}" alt=""></a>
                                </div>
                            </div>
                        </article>
                    </aside>
                    <aside class="col-sm-7">
                        <article class="card-body p-5">
                            <h4>${products.name}</h4>
                            <p class="price-detail-wrap">
                                <span class="price h3 text-warning">
                                    <h5>${products.price} $</h5>
                                </span>
                                <span class="price h3 text-warning">
                                    <h6>${products.configurationInfo}</h6>
                                </span>
                            </p>
                            
                            <hr>
                            <a href="http://localhost:8080/web/" class="btn btn-lg btn-primary text-uppercase"> Continue Shopping </a>
                            <a href="${pageContext.request.contextPath}/addToCart/${products.id}" class="btn btn-lg btn-outline-primary text-uppercase"> <i class="fas fa-shopping-cart"></i> Add to cart </a>
                        </article>
                    </aside>            
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>