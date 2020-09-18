<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 13.09.2020
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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

                <p class="navbar-text text-center "><i class="fas fa-map-marker-alt"></i>Uganda</p>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="text-center"><a href="#"> <i class="fab fa-facebook"></i> Sign in</a></li>
                <ul id="currentShoppingCart" class="nav navbar-nav navbar-right text-center">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">
                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                            Shopping cart (<span class="total-count">0</span>)<span class="caret"></span>
                        </a>
                        <div class="dropdown-menu shopping-cart-desc ">
                            <p class="text-center"> Total count: <span class="total-count">0</span><br>
                                Total cost: <span class="total-cost">0</span><br>
                            </p>
                            <a href="/shopping-cart" class="btn btn-warning btn-block">View cart</a>
                        </div>
                    </li>
                </ul>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>