<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 9/24/2024
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglib.jsp"%>
<c:url value="/" var="URL"></c:url>
<!DOCTYPE html>
<html lang="en">
<!--<![endif]-->

<!-- Head BEGIN -->
<head>
    <meta charset="utf-8">
    <title>Metronic Shop UI</title>

    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <meta content="Metronic Shop UI description" name="description">
    <meta content="Metronic Shop UI keywords" name="keywords">
    <meta content="keenthemes" name="author">

    <meta property="og:site_name" content="-CUSTOMER VALUE-">
    <meta property="og:title" content="-CUSTOMER VALUE-">
    <meta property="og:description" content="-CUSTOMER VALUE-">
    <meta property="og:type" content="website">
    <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
    <meta property="og:url" content="-CUSTOMER VALUE-">

    <link rel="shortcut icon" href="favicon.ico">

    <!-- Fonts START -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css"><!--- fonts for slider on the index page -->
    <!-- Fonts END -->

    <!-- Global styles START -->
    <link href="${URL}assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="${URL}assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Global styles END -->

    <!-- Page level plugin styles START -->
    <link href="${URL}assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
    <link href="${URL}assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css" rel="stylesheet">
    <link href="${URL}assets/global/plugins/slider-layer-slider/css/layerslider.css" rel="stylesheet">
    <!-- Page level plugin styles END -->

    <!-- Theme styles START -->
    <link href="${URL}assets/global/css/components.css" rel="stylesheet">
    <link href="${URL}assets/frontend/layout/css/style.css" rel="stylesheet">
    <link href="${URL}assets/frontend/pages/css/style-shop.css" rel="stylesheet" type="text/css">
    <link href="${URL}assets/frontend/pages/css/style-layer-slider.css" rel="stylesheet">
    <link href="${URL}assets/frontend/layout/css/style-responsive.css" rel="stylesheet">
    <link href="${URL}assets/frontend/layout/css/themes/red.css" rel="stylesheet" id="style-color">
    <link href="${URL}assets/frontend/layout/css/custom.css" rel="stylesheet">
    <!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<!-- BEGIN STYLE CUSTOMIZER -->
<div class="color-panel hidden-sm">
    <div class="color-mode-icons icon-color"></div>
    <div class="color-mode-icons icon-color-close"></div>
    <div class="color-mode">
        <p>THEME COLOR</p>
        <ul class="inline">
            <li class="color-red current color-default" data-style="red"></li>
            <li class="color-blue" data-style="blue"></li>
            <li class="color-green" data-style="green"></li>
            <li class="color-orange" data-style="orange"></li>
            <li class="color-gray" data-style="gray"></li>
            <li class="color-turquoise" data-style="turquoise"></li>
        </ul>
    </div>
</div>
<!-- END BEGIN STYLE CUSTOMIZER -->

<!-- BEGIN TOP BAR -->
<div class="pre-header">
    <div class="container">
        <div class="row">
            <!-- BEGIN TOP BAR LEFT PART -->
            <div class="col-md-6 col-sm-6 additional-shop-info">
                <ul class="list-unstyled list-inline">
                    <li><i class="fa fa-phone"></i><span>+1 456 6717</span></li>
                    <!-- BEGIN CURRENCIES -->
                    <li class="shop-currencies">
                        <a href="javascript:void(0);">€</a>
                        <a href="javascript:void(0);">£</a>
                        <a href="javascript:void(0);" class="current">$</a>
                    </li>
                    <!-- END CURRENCIES -->
                    <!-- BEGIN LANGS -->
                    <li class="langs-block">
                        <a href="javascript:void(0);" class="current">English </a>
                        <div class="langs-block-others-wrapper"><div class="langs-block-others">
                            <a href="javascript:void(0);">French</a>
                            <a href="javascript:void(0);">Germany</a>
                            <a href="javascript:void(0);">Turkish</a>
                        </div></div>
                    </li>
                    <!-- END LANGS -->
                </ul>
            </div>
            <!-- END TOP BAR LEFT PART -->
            <!-- BEGIN TOP BAR MENU -->
            <div class="col-md-6 col-sm-6 additional-nav">
                <ul class="list-unstyled list-inline pull-right">
                    <li><a href="shop-account.html">My Account</a></li>
                    <li><a href="shop-wishlist.html">My Wishlist</a></li>
                    <li><a href="shop-checkout.html">Checkout</a></li>
                    <li><a href="page-login.html">Log In</a></li>
                </ul>
            </div>
            <!-- END TOP BAR MENU -->
        </div>
    </div>
</div>
<!-- END TOP BAR -->

<!--Begin header-->
<%@ include file="/commons/web/header.jsp"%>
<!--Begin header-->

<!-- BEGIN SLIDER -->
<%@ include file="/commons/web/slider.jsp"%>
<!-- END SLIDER -->

<div class="main">
    <div class="container">
        <!--Begin content-->
        <sitemesh:write property="body"/>
        <!--End content-->
    </div>
</div>

<!-- BEGIN BRANDS -->
<%@ include file="/commons/web/brands.jsp"%>
<!-- END BRANDS -->

<!-- BEGIN STEPS -->
<%@ include file="/commons/web/step.jsp"%>
<!-- END STEPS -->

<!-- BEGIN FOOTER -->
<%@ include file="/commons/web/footer.jsp"%>
<!-- END FOOTER -->

<!-- BEGIN fast view of a product -->
<div id="product-pop-up" style="display: none; width: 700px;">
    <div class="product-page product-pop-up">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-3">
                <div class="product-main-image">
                    <img src="${URL}assets/frontend/pages/img/products/model7.jpg" alt="Cool green dress with red bell" class="img-responsive">
                </div>
                <div class="product-other-images">
                    <a href="#" class="active"><img alt="Berry Lace Dress" src="${URL}assets/frontend/pages/img/products/model3.jpg"></a>
                    <a href="#"><img alt="Berry Lace Dress" src="${URL}assets/frontend/pages/img/products/model4.jpg"></a>
                    <a href="#"><img alt="Berry Lace Dress" src="${URL}assets/frontend/pages/img/products/model5.jpg"></a>
                </div>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-9">
                <h2>Cool green dress with red bell</h2>
                <div class="price-availability-block clearfix">
                    <div class="price">
                        <strong><span>$</span>47.00</strong>
                        <em>$<span>62.00</span></em>
                    </div>
                    <div class="availability">
                        Availability: <strong>In Stock</strong>
                    </div>
                </div>
                <div class="description">
                    <p>Lorem ipsum dolor ut sit ame dolore  adipiscing elit, sed nonumy nibh sed euismod laoreet dolore magna aliquarm erat volutpat
                        Nostrud duis molestie at dolore.</p>
                </div>
                <div class="product-page-options">
                    <div class="pull-left">
                        <label class="control-label">Size:</label>
                        <select class="form-control input-sm">
                            <option>L</option>
                            <option>M</option>
                            <option>XL</option>
                        </select>
                    </div>
                    <div class="pull-left">
                        <label class="control-label">Color:</label>
                        <select class="form-control input-sm">
                            <option>Red</option>
                            <option>Blue</option>
                            <option>Black</option>
                        </select>
                    </div>
                </div>
                <div class="product-page-cart">
                    <div class="product-quantity">
                        <input id="product-quantity" type="text" value="1" readonly name="product-quantity" class="form-control input-sm">
                    </div>
                    <button class="btn btn-primary" type="submit">Add to cart</button>
                    <a href="shop-item.html" class="btn btn-default">More details</a>
                </div>
            </div>

            <div class="sticker sticker-sale"></div>
        </div>
    </div>
</div>
<!-- END fast view of a product -->

<!-- Load javascripts at bottom, this will reduce page load time -->
<!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
<!--[if lt IE 9]>
<script src="${URL}assets/global/plugins/respond.min.js"></script>
<![endif]-->
<script src="${URL}assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${URL}assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<script src="${URL}assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${URL}assets/frontend/layout/scripts/back-to-top.js" type="text/javascript"></script>
<script src="${URL}assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
<script src="${URL}assets/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
<script src="${URL}assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js" type="text/javascript"></script><!-- slider for products -->
<script src='${URL}assets/global/plugins/zoom/jquery.zoom.min.js' type="text/javascript"></script><!-- product zoom -->
<script src="${URL}assets/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js" type="text/javascript"></script><!-- Quantity -->

<!-- BEGIN LayerSlider -->
<script src="${URL}assets/global/plugins/slider-layer-slider/js/greensock.js" type="text/javascript"></script><!-- External libraries: GreenSock -->
<script src="${URL}assets/global/plugins/slider-layer-slider/js/layerslider.transitions.js" type="text/javascript"></script><!-- LayerSlider script files -->
<script src="${URL}assets/global/plugins/slider-layer-slider/js/layerslider.kreaturamedia.jquery.js" type="text/javascript"></script><!-- LayerSlider script files -->
<script src="${URL}assets/frontend/pages/scripts/layerslider-init.js" type="text/javascript"></script>
<!-- END LayerSlider -->

<script src="${URL}assets/frontend/layout/scripts/layout.js" type="text/javascript"></script>
<script type="text/javascript">
    jQuery(document).ready(function() {
        Layout.init();
        Layout.initOWL();
        LayersliderInit.initLayerSlider();
        Layout.initImageZoom();
        Layout.initTouchspin();
        Layout.initTwitter();

        Layout.initFixHeaderWithPreHeader();
        Layout.initNavScrolling();
    });
</script>
<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
