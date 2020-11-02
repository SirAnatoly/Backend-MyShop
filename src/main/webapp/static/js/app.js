;$(function(){
    var init = function (){
        initBuyBtn();
        $('#addToCart').click(addProductToCart);
        $('#addProductPopup .count').change(calculateCost);
        $('#loadMore').click(loadMoreProducts);
        $('.remove-product').click(removeProductFromCart);
        var btn = $('#button');
        $(window).scroll(function() {
            if ($(window).scrollTop() > 300) {
                btn.addClass('show');
            } else {
                btn.removeClass('show');
            }
        });
        btn.on('click', function(e) {
            e.preventDefault();
            $('html, body').animate({scrollTop:0}, '300');
        });
    };
    var initBuyBtn = function(){
        $('.buy-btn').click(showAddProductPopup);
    };
    var showAddProductPopup = function (){
        var idProduct = $(this).attr('data-id-product');
        var product = $('#product'+idProduct);

        $('#addProductPopup').attr('data-id-product', idProduct);
        $('#addProductPopup .product-image').attr('src', product.find('.thumbnail img').attr('src'));
        $('#addProductPopup .name').text(product.find('.name').text());
        var price = product.find('.price').text();
        $('#addProductPopup .price').text(price);
        $('#addProductPopup .category').text(product.find('.category').text());
        $('#addProductPopup .producer').text(product.find('.producer').text());
        $('#addProductPopup .count').val(1);
        $('#addProductPopup .cost').text(price);
        $('#addToCart').removeClass('hidden');
        $('#addToCartIndicator').addClass('hidden');
        $('#addProductPopup').modal({
            show:true
        });
    };

    var addProductToCart = function (){
        var idProduct = $('#addProductPopup').attr('data-id-product');
        var count = $('#addProductPopup .count').val();
        $.ajax({
            url : '/ajax/json/product/add',
            method : 'POST',
            data : {
                idProduct : idProduct,
                count : count
            },
            success : function(data) {
                console.log(idProduct);
                $('#currentShoppingCart .total-count').text(data.totalCount);
                $('#currentShoppingCart .total-cost').text(data.totalCost);
                $('#currentShoppingCart').removeClass('hidden');
                $('#addProductPopup').modal('hide');
            },
            error : function(data) {
                alert('Error');
            }
        });
    };
    var calculateCost = function(){
        var priceStr = $('#addProductPopup .price').text();
        var price = parseFloat(priceStr.replace('$',' '));
        var count = parseInt($('#addProductPopup .count').val());
        var min = parseInt($('#addProductPopup .count').attr('min'));
        var max = parseInt($('#addProductPopup .count').attr('max'));
        if(count >= min && count <= max) {
            var cost = price * count;
            $('#addProductPopup .cost').text('$ '+cost.toFixed(2));
        } else {
            $('#addProductPopup .count').val(1);
            $('#addProductPopup .cost').text(priceStr);
        }
    };
    var convertButtonToLoader = function (btn, btnClass) {
        btn.removeClass(btnClass);
        btn.removeClass('btn');
        btn.addClass('load-indicator');
        var text = btn.text();
        btn.text('');
        btn.attr('data-btn-text', text);
        btn.off('click');
    };
    var convertLoaderToButton = function (btn, btnClass, actionClick) {
        btn.removeClass('load-indicator');
        btn.addClass('btn');
        btn.addClass(btnClass);
        btn.text(btn.attr('data-btn-text'));
        btn.removeAttr('data-btn-text');
        btn.click(actionClick);
    };
    var loadMoreProducts = function (){
        let btn = $('#loadMore');
        let productCount = parseInt($('#productList').attr('data-count'));
        convertButtonToLoader(btn, 'btn-success');
        let url = '/ajax/html/more' + location.pathname + '?' + location.search.substring(1);
        $.ajax({
            url : url,
            success : function(html) {
                if ( productCount > 0) {
                    $('#myshopp ').append(html);
                    convertLoaderToButton(btn, 'btn-success', loadMoreProducts);
                    productCount -=  12;
                    $('#productList').attr('data-count', productCount);
                    if ( productCount < 12) btn.remove();
                }

            },
            error : function(data) {
                convertLoaderToButton(btn, 'btn-success', loadMoreProducts);
                alert('Error');
            }
        });
    };
    var confirm = function (msg, okFunction) {
        if(window.confirm(msg)) {
            okFunction();
        }
    };
    var removeProductFromCart = function (){
        var btn = $(this);
        confirm('Are you sure?', function(){
            executeRemoveProduct(btn);
        });
    };

    var refreshTotalCost = function () {
        var total = 0;
        $('#shoppingCart .item').each(function(index, value) {
            var count = parseInt($(value).find('.count').text());
            var price = parseFloat($(value).find('.total-cost').text().replace('$', ' '));
            var val = price * count;
            total = total + val;
        });
        $('#shoppingCart .total-cost').text('$'+total.toFixed(2));
    };

    var executeRemoveProduct = function (btn) {
        var idProduct = btn.attr('data-id-product');
        var count = btn.attr('data-count');
        convertButtonToLoader(btn, 'btn-danger');

        $.ajax({
            url: '/ajax/json/product/remove',
            method: 'POST',
            data: {
                idProduct: idProduct,
                count: count
            },
            success: function (data) {
                if (data.totalCount == 0) {
                    window.location.href = '/products';
                } else {
                    var prevCount = parseInt($('#product' + idProduct + ' .count').text());
                    var remCount = parseInt(count);
                    if (remCount >= prevCount) {
                        $('#product' + idProduct).remove();
                    } else {
                        convertLoaderToButton(btn, 'btn-danger', removeProductFromCart);
                        $('#product' + idProduct + ' .count').text(prevCount - remCount);
                        if (prevCount - remCount == 1) {
                            $('#product' + idProduct + ' a.remove-all').remove();
                        }
                    }
                    $('#currentShoppingCart .total-count').text(data.totalCount);
                    $('#currentShoppingCart .total-cost').text(data.totalCost);
                    $('#shoppingCart .total').text(data.totalCost);
                }
            },
            error: function (data) {
                convertLoaderToButton(btn, 'btn-danger', removeProductFromCart);
                alert('Error');
            }
        });
    }

    init();
});


