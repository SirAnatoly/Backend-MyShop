<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 14.09.2020
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="alert alert-info">
    <p>Found <strong>${productCount }</strong> products</p>
</div>

<jsp:include page="products.jsp" />
