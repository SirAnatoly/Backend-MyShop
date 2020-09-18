<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 13.09.2020
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="myshop" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" 	  		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 	  	uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" 	  		uri="http://java.sun.com/jsp/jstl/functions"%>

<div id="productList">
    <div id="myshopp">
    <jsp:include page="../fragment/product-list.jsp" />
    </div>
    <div class="text-center ">
        <a id="loadMore" class="btn btn-info btn-lg btn-block">Load more products</a>
    </div>
</div>

<myshop:add-product-popup />