<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 14.09.2020
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="myshop" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="shoppingCart">
    <div class="alert alert-warning" role="alert">To make order, please sign in</div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Count</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>

            <c:forEach var="p" items="${CURRENT_SHOPPING_CART.getProducts() }">
        <tr id="product${p.getProduct().getId()}" class="item">
            <td class="uii">
                <img class="img-responsive uii " alt="Responsive image "src="${p.getProduct().getImage_link()}" ><br>${ p.getProduct().getName() }</td>
            <td class="price">${ p.getProduct().getPrice() }</td>
            <td class="count">${p.getCount()}</td>
            <td>
                <a id="button-remove" class="btn btn-danger remove-product remove-all" data-id-product="${p.getProduct().getId()}" data-count="${p.getCount()}">Remove</a>
            </td>
        </tr>
                </c:forEach>
        <tr>
            <td colspan="2" class="text-right"><strong>Total:</strong></td>
            <td colspan="2" class="total">$ ${CURRENT_SHOPPING_CART.getTotalCost()}</td>
        </tr>
        </tbody>
    </table>

</div>

