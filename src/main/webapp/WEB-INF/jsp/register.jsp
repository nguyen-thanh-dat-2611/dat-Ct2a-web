<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <title>Đ&Đ Shop</title>
    
    <link href="${pageContext.request.contextPath}/resources/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/datepicker/daterangepicker.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" media="all"> 
    </head>
    <body>
<div class="page-wrapper bg-gra-01 p-t-180 p-b-100 font-poppins">
        <div class="wrapper wrapper--w780">
            <div class="card card-3">
                <div class="card-heading"></div>
                <div class="card-body">
                    <h2 class="title">Welcome to register</h2>
                    <mvc:form modelAttribute="customer" action="addnewCustomer" method="post">
            
                        <div class="input-group">
                            <mvc:input class="input--style-3" type="text" path="firstname" placeholder="firstName" name="firstname" />
                        </div>    
                        <div class="input-group">
                            <mvc:input class="input--style-3" type="text" path="name" placeholder="Name" name="name" />
                        </div>
                        <div class="input-group">
                            <mvc:input class="input--style-3 js-datepicker" type="date" path="birthdate" placeholder="Birthdate" name="birthday"/>
                            <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                        </div>
                        <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                                <mvc:select path="sex"  items="${sexed}"/>
                                    <option disabled="disabled" selected="selected">Gender</option>
                                <div class="input-group">
                            <mvc:input class="input--style-3" type="text" path="address" placeholder="address" name="Address" />
                        </div>   
                            </div>
                        </div>
                        <div class="input-group">
                            <mvc:input class="input--style-3" type="email" path="email" placeholder="email" name="email"/>
                        </div>
                        <div class="input-group">
                            <mvc:input class="input--style-3" type="text" path="phone" placeholder="phone" name="phone" />
                        </div>
                        <div class="input-group">
                            <mvc:input class="input--style-3" type="text" path="user" placeholder="user" name="user"/>
                        </div>
                        <div class="input-group">
                            <mvc:input class="input--style-3" type="text" path="passwork" placeholder="passwork" name="passwork"/>
                        </div>
                        <div class="p-t-10">
                            <button class="btn btn--pill btn--green" href="home" type="submit">Submit</button>
                        </div>
                    </mvc:form>
                </div>
            </div>
        </div>
    </div>

     
    <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/select2/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/datepicker/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/datepicker/daterangepicker.js"></script>
    <script src="${pageContext.request.contextPath}/resources/global.js"></script>
      
    </body>
</html>