<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 13.10.2020
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 	  		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 	  	uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" 	  		uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MyShop</title>

    <link type="text/css" href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="/static/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link type="text/css" href="/static/css/theme.css" rel="stylesheet">
    <link type="text/css" href="/static/images/icons/css/font-awesome.css" rel="stylesheet">
    <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
          rel='stylesheet'>

</head>

<body>
<header>
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                    <i class="icon-reorder shaded"></i></a><a class="brand" href="/">MyShop </a>

                <ul class="nav pull-right">
                    <li><a href="/sign-out">Logout</a></li>
                </ul>
                </li>
                </ul>
            </div>
            <!-- /.nav-collapse -->
        </div>
    </div>
    <!-- /navbar-inner -->
    </div>
    <!-- /navbar ---------------------------------------->
</header>
<div class="container-fluid">
    <div class="row">
        <div class="wrapper">
            <div class="container">

                <div class="row">
                    <div class="span3">
                        <div class="sidebar">
                            <ul class="widget widget-menu unstyled">
                                <li class="active"><a href="admin"><i class="menu-icon icon-dashboard"></i>Dashboard
                                </a></li>
                                <li><a href="messages"><i class="menu-icon icon-inbox"></i>Messages </a></li>
                                <li><a href="addProduct"><i class="menu-icon icon-paste"></i>Add Product </a></li>
                            </ul>
                        </div>
                        <!--/.sidebar-->
                    </div>
                    <!--/.span3-->
                    <div class="span9">
                        <div class="content">
                            <div class="module message">
                                <div class="module-head">
                                    <h3 class="align-center">
                                        Messages</h3>
                                </div>
                                </div>
                                <div class="module-body table">
                                    <table class="table table-bordered">

                                        <tbody>
                                            <tr class="warning">

                                                <td >
                                                    <h4 class="align-center">name</h4>
                                                </td>
                                                <td >
                                                    <h4 class="align-center">email</h4>
                                                </td>
                                                <td >
                                                    <h4 class="align-center">description</h4>
                                                </td>
                                                <td >
                                                    <h4 class="align-center">date</h4>
                                                </td>

                                            </tr>

                                            <c:forEach var="o" items="${OrderItems }">
                                                <tr >
                                                    <td >
                                                        <p class="align-center">${o.getOrder().getAccount().getName()}</p>
                                                    </td>
                                                    <td >
                                                        <p class="align-center">${o.getOrder().getAccount().getEmail()}</p>
                                                    </td>
                                                    <td >
                                                        <p class="align-center">${o.describeItems()}</p>
                                                    </td>
                                                    <td >
                                                        <p class="align-center">${o.getOrder().getCreated()}</p>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>

                                    </table>
                                    <div class="text-center">
                                        <a id="loadMore" class="btn btn-info btn-block">Load more products</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>
                <!--/.container-->
            </div>
            <!--/.wrapper-->




        </div>
    </div>
    <footer >
        <div class="footer">
            <div class="container">

            </div>
        </div>
    </footer>

    <script src="/static/scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="/static/scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/static/scripts/flot/jquery.flot.js" type="text/javascript"></script>
    <script src="/static/scripts/flot/jquery.flot.resize.js" type="text/javascript"></script>
    <script src="/static/scripts/datatables/jquery.dataTables.js" type="text/javascript"></script>
    <script src="/static/scripts/common.js" type="text/javascript"></script>

</body>
</html>









