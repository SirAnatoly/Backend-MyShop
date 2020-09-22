<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 13.09.2020
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" 	  		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 	  	uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" 	  		uri="http://java.sun.com/jsp/jstl/functions"%>

<div id="listProd" class="row" data-id="${startID }" data-count="${countOfProduct}">
    <c:forEach var="p" items="${products }">
    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 ">
        <div id="product ${p.getId() }" class="panel panel-default product">
            <div class="panel-body">
                <div class="thumbnail">
                    <img src="${p.getImage_link()}" alt="${p.getName() }">
                    <div class="desc">
                        <div class="cell">
                            <p><span class="title">Details</span> ${p.getDescription()}</p>
                        </div>
                    </div>
                </div>
                <h4 class="name">${p.getName() }</h4>
                <div class="price">$ ${p.getPrice() }</div>
                <a class="btn btn-danger pull-right btn-block buy-btn" data-id-product="1"><b>Buy</b></a>
                <div class="code">Code: ${p.getId() }</div>
                <div class="list-group">
                    <span class="list-group-item"> <small>Category:</small> <span class="category">${p.getCategory().getName() }</span></span>
                    <span class="list-group-item"> <small>Producer:</small> <span class="producer">${p.getProducer().getName()}</span></span>
                </div>
            </div>
        </div>
    </div>
    </c:forEach>
</div>
