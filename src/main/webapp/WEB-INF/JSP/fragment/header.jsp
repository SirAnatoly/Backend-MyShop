<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 13.09.2020
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" 	  		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 	  	uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" 	  		uri="http://java.sun.com/jsp/jstl/functions"%>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand text-center" href="/products">MyShop</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <p class="navbar-text text-center"><i class="fas fa-phone-alt"></i>+48 512-148-921</p>

                <img  class="visible-lg navbar-right " src="/static/logo-dhl-copy.svg">

            </ul>

            <ul class="nav navbar-nav navbar-right">
                
                ${admin == null ? '' : '<li > <form action="/admin" method="get"><li class="text-center"><button class="sign-in" style="margin: 15px" type="submit"> Admin board</button> </li></form></li>' }

                <c:choose>
                    <c:when test="${CURRENT_ACCOUNT != null }">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a class=" text-center">Welcome: ${CURRENT_ACCOUNT.description }</a></li>
                            <li><a class=" text-center" href="/my-orders">My orders</a></li>
                            <li><a class=" text-center" href="/sign-out">Sign out</a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <li > <form action="/sign-in" method="post">
                        <li class="text-center">
                        <button class="sign-in" style="margin: 15px" type="submit">
                            <i class="fab fa-facebook "></i> Sign in
                        </button> </li>
                        </form>
                        </li>
                    </c:otherwise>
                </c:choose>


<%--   <button  type="submit" class="btn btn-primary navbar-btn navbar-right sign-in text-center">
--%>


    <ul id="currentShoppingCart" class="nav navbar-nav navbar-right text-center">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
               aria-expanded="false">
                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                Shopping cart <span class="label label-warning"><span class="total-count">${CURRENT_SHOPPING_CART.getTotalCount()}</span></span><span class="caret"></span>
            </a>
            <div class="dropdown-menu shopping-cart-desc ">
                <p class="text-center"> Total count: <span class="total-count">${CURRENT_SHOPPING_CART.getTotalCount()}</span><br>
                    Total cost: $ <span class="total-cost">${CURRENT_SHOPPING_CART.getTotalCost()}</span><br>
                </p>
                <a href="/shopping-cart" class="btn btn-warning btn-block">View cart</a>
            </div>
        </li>
    </ul>
</ul>
</div><!-- /.navbar-collapse -->
</div><!-- /.container-fluid -->
</nav>
