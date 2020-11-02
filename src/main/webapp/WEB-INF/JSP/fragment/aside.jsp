<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 13.09.2020
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ishop" tagdir="/WEB-INF/tags"%>

<!--start search form--->
<form action="/search">
    <div class="panel panel-danger">
        <div class="panel-heading">
            <h3 class="panel-title">Find products</h3>
        </div>
        <div class="panel-body">
            <div class="input-group">
                <input type="text" name="query" class="form-control" placeholder="Search for...">
                <span class="input-group-btn">
                     <button class="btn btn-default" type="submit"><i class="fas fa-search"></i></button>
                   </span>
            </div>
        </div>
        <button class="btn btn-default btn-xs dropdown-toggle btn-block" role="button"
                data-toggle="collapse" href="#collapseExample" aria-expanded="false"
                aria-controls="collapseExample">
            More filters <span class="caret"></span>
        </button>
        <div class="collapse" id="collapseExample">
            <div class="well">
                <h4><span class="label label-default ">Category filters:</span></h4>

                <div class="panel-body categories">
                    <c:forEach var="category" items="${CATEGORY_LIST }">
                        <div class="form-group">
                            <div class="checkbox">
                                <label><input type="checkbox" name="category" value="${category.getId() }" class="search-option">
                                  <label class="myCategoryText">  ${category.getName() }  <span class="label label-primary myCategoryText2">${category.getProductCount() }</span></label>
                                </label>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <h4><span class="label label-default ">Producers filters:</span></h4>
                <div class="panel-body producers">
                    <c:forEach var="producer" items="${PRODUCER_LIST }">
                        <div class="form-group">
                            <div class="checkbox">
                                <label><input type="checkbox" name="producer" value="${producer.getId() }" class="search-option">
                                    <label class="myCategoryText">   ${producer.getName() } <span class="label label-primary myCategoryText2">${producer.getProductCount() }</span></label>
                                </label>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</form>
<!--end search form--->

<!---- start category---->
<div class="panel panel-danger">
    <div class="panel-heading">
        <h3 class="panel-title">Product catalog</h3>
    </div>
    <div class="list-group">
        <c:forEach var="category" items="${CATEGORY_LIST }">
            <div class="myCategoryText">

                <a href="/products${category.getUrl() }" class="list-group-item ${selectedCategoryUrl == category.getUrl() ? 'active' : '' }">

                        ${category.getIcon() } <span class="badge ">${category.getProductCount()}</span>   ${category.getName()}

            </a>
            </div>
        </c:forEach>
    </div>
</div>
<!----end category------->
