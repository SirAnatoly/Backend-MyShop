<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 26.09.2020
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    ${info }

<table class="table table-bordered">
    <thead>
    <tr>
        <th>Code order</th>
        <th>User</th>
        <th>Date</th>
        <th>Items</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${OrderItems }">
    <tr>
        <td>${p.getOrder().getId() }</td>
        <td>${p.getOrder().getAccount().getName() }</td>
        <td>${p.getOrder().getCreated() }</td>
        <td>${p.describeItems() }</td>

    </tr>
        </c:forEach>
    </tbody>
</table>
