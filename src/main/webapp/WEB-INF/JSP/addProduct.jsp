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

						<div class="module">
							<div class="module-head">
								<h3>Forms</h3>
							</div>
							<div class="module-body">

								${success == null ? '' : ' <div class="alert alert-success"><button type="button" class="close" data-dismiss="alert">×</button><strong>Well done!</strong> Product added </div>' }

									<br />

									<form method="post" action="/addProduct">

										<div class="control-group">
											<label class="control-label" >Product Name</label>
											<div class="controls">
												<input  type="text"
													   placeholder="Name"
														id="name" name="name" class="span8 tip">
											</div>

										</div>
										<div class="control-group">
											<label class="control-label" >Product Description</label>
											<div class="controls">
												<textarea class="span8" rows="5"
														  placeholder="Text"
														  id="desc" name="desc"
												></textarea>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" >Product Foto</label>
											<div class="controls">
												<input  type="text"
													   placeholder="URL"
														id="url" name="url" class="span8 tip">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" >Product Price</label>
											<div class="controls">
												<div class="input-append">
													<input type="text" id="price" name="price" placeholder="0.00" class="span8"><span class="add-on">$</span>
												</div>
											</div>
										</div>



										<div class="control-group">
											<label class="control-label" >Category</label>
											<div class="controls">
												<select tabindex="1" id="category" name="category" data-placeholder="choose a category" class="span8">
													<c:forEach var="c" items="${Categories }">
														<option value="${c.getId()}">${c.getName()}</option>
													</c:forEach>
												</select>
											</div>
										</div>


										<div class="control-group">
											<label class="control-label" >Producer</label>
											<div class="controls">
												<select tabindex="1" id="producer" name="producer" data-placeholder="choose a producer" class="span8">
													<c:forEach var="p" items="${Producers }">
													<option value="${p.getId()}">${p.getName()}</option>
													</c:forEach>
												</select>
											</div>
										</div>





										<div class="control-group">
											<div class="controls">
												<button type="submit" class="btn">Submit Form</button>
											</div>

										</div>
									</form>


							</div>
						</div>

						
						
					</div><!--/.content-->
				</div><!--/.span9-->
			</div>
		</div><!--/.container-->
	</div><!--/.wrapper-->
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





