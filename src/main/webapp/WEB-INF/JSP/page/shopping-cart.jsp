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
        <tr id="product1" class="item">
            <td class="uii">
                <img class="img-responsive uii " alt="Responsive image "src="https://via.placeholder.com/400" ><br>Product name</td>
            <td class="price">$ 2.00</td>
            <td class="count">1</td>
            <td>
                <a class="btn btn-danger remove-product" data-id-product="1" data-count="1">Remove one</a>
            </td>
        </tr>
        <tr id="product2" class="item">
            <td class="uii">
                <img class="img-responsive uii " alt="Responsive image "src="https://via.placeholder.com/400" alt="i"><br>Product name</td>
            <td class="price">  $ 1.00</td>
            <td class="count">2</td>
            <td>
                <a class="btn btn-danger remove-product" data-id-product="2" data-count="1">Remove one</a><br><br>
                <a class="btn btn-danger remove-product all" data-id-product="2" data-count="2">Remove all</a>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="text-right"><strong>Total:</strong></td>
            <td colspan="2" class="total">$ 4.00</td>
        </tr>
        </tbody>
    </table>
    <div class="row">
    </div>
</div>