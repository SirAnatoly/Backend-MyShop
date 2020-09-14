<%--
  Created by IntelliJ IDEA.
  User: mr
  Date: 13.09.2020
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                    <div class="form-group">
                        <div class="checkbox">
                            <label><input type="checkbox" name="category" value="1" class="search-option">E-book (78)</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="checkbox">
                            <label><input type="checkbox" name="category" value="2" class="search-option">Mp3-player
                                (75)</label>
                        </div>
                    </div>
                </div>
                <h4><span class="label label-default ">Producers filters:</span></h4>
                <div class="panel-body producers">
                    <div class="form-group">
                        <div class="checkbox">
                            <label><input type="checkbox" name="producer" value="1" class="search-option">Dell (56) </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="checkbox">
                            <label><input type="checkbox" name="producer" value="2" class="search-option">Apple (22) </label>
                        </div>
                    </div>
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
        <a href="/products/category1" class="list-group-item"><i class="fas fa-tablet"></i> <span class="badge">78</span> E-book</a>
        <a href="/products/category2" class="list-group-item"> <i class="fas fa-music"></i> <span class="badge">75</span>
            Mp3-player</a>
        <a href="/products/category3" class="list-group-item"> <i class="fas fa-laptop"></i> <span class="badge">110</span>
            Notebook</a>
        <a href="/products/category4" class="list-group-item"> <i class="fas fa-phone"></i> <span class="badge">113</span> Phone</a>
        <a href="/products/category5" class="list-group-item"> <i class="fas fa-mobile-alt"></i> <span class="badge">216</span>
            Smartphone</a>
        <a href="/products/category6" class="list-group-item"> <i class="far fa-clock"></i> <span class="badge">95</span>
            Smartwatch</a>
        <a href="/products/category7" class="list-group-item"> <i class="fas fa-tablet-alt"></i> <span class="badge">211</span> Tablet</a>
    </div>
</div>
<!----end category------->