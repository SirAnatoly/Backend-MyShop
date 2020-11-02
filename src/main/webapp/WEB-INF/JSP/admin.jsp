<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 12.10.2020
  Time: 16:00
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
                                <li class="active"><a href="/admin"><i class="menu-icon icon-dashboard"></i>Dashboard
                                </a></li>
                                <li><a href="/messages"><i class="menu-icon icon-inbox"></i>Messages </a></li>
                                <li><a href="/addProduct"><i class="menu-icon icon-paste"></i>Add Product </a></li>
                            </ul>
                        </div>
                        <!--/.sidebar-->
                    </div>
                    <!--/.span3-->
                    <div class="span9">
                        <div class="content">

                            ${success == null ? '' : ' <div class="alert alert-success"><button type="button" class="close" data-dismiss="alert">×</button><strong>Well done!</strong> Product deleted </div>' }


                            <div class="btn-controls">
                                <div class="btn-box-row row-fluid">
                                    <div class="btn-box big span4"><i class="icon-list-ul"></i><b>${CountOfProducts}</b>
                                        <p class="text-muted">
                                            Products</p>
                                    </div><div  class="btn-box big span4"><i class="icon-user"></i><b>${CountOfAccounts}</b>
                                    <p class="text-muted">
                                        Users</p>
                                </div><div  class="btn-box big span4"><i class="icon-money"></i><b>15,152</b>
                                    <p class="text-muted">
                                        Profit</p>
                                </div>
                                </div>
                            </div>
                            <!--/#btn-controls-->
                            <!--/.module-->
                            <div class="module hide">
                                <div class="module-head">
                                    <h3>
                                        Adjust Budget Range</h3>
                                </div>
                                <div class="module-body">
                                    <div class="form-inline clearfix">
                                        <a href="#" class="btn pull-right">Update</a>
                                        <label for="amount">
                                            Price range:</label>
                                        &nbsp;
                                        <input type="text" id="amount" class="input-" />
                                    </div>
                                    <hr />
                                    <div class="slider-range">
                                    </div>
                                </div>
                            </div>
                            <div class="module">
                                <div class="module-head">
                                    <h3>
                                        DataTables</h3>
                                </div>
                                <div class="module-body table">
                                    <table cellpadding="0" cellspacing="0" border="0"
                                           class="datatable-1 table table-bordered table-striped	 display"
                                           width="100%">
                                        <thead>
                                        <tr>
                                            <th>
                                                id
                                            </th>
                                            <th>
                                                name
                                            </th>
                                            <th>
                                                description
                                            </th>
                                            <th>
                                                image link
                                            </th>
                                            <th>
                                                price
                                            </th>
                                            <th>
                                                category
                                            </th>
                                            <th>
                                                producer
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="p" items="${Products }">
                                            <tr class="odd gradeX">
                                                <td>
                                                        ${p.getId() }
                                                </td>
                                                <td>
                                                        ${p.getName() }
                                                </td>
                                                <td>
                                                        ${p.getDescription()}
                                                </td>
                                                <td class="center">
                                                     <img src="${p.getImage_link()}">   
                                                </td>
                                                <td class="center">
                                                        ${p.getPrice() }
                                                </td>
                                                <td class="center">
                                                        ${p.getCategory().getName() }
                                                </td>
                                                <td class="center">
                                                        ${p.getProducer().getName()}
                                                </td>
                                                <td class="center">
                                                    <form method="post" action="/admin">
                                                        <button class="btn btn-danger"  id="product" name="product" value="${p.getId()}" type="submit">
                                                            delete
                                                        </button>
                                                    </form>

                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                            <!--/.module-->
                            <!--/.content-->
                        </div>
                        <!--/.span9-->

                    </div>
                </div>
                <!--/.container-->
            </div>
            <!--/.wrapper-->


        </div>
    </div>
    <footer>
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





