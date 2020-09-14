<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 13.09.2020
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="myshop" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="productList">
    <jsp:include page="../fragment/product-list.jsp" />
    <div class="text-center">
        <a id="loadMore" class="btn btn-info btn-lg btn-block">Load more products</a>
    </div>
</div>
<myshop:add-product-popup />