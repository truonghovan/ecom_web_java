<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/views/web/static" var="url"> </c:url>
<!DOCTYPE html>
<html lang="en">
<header>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Footer</title>
	<link href="${url}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${url}/css/font-awesome.min.css" rel="stylesheet">
	<link href="${url}/css/main.css" rel="stylesheet">
	<link href="${url}/css/responsive.css" rel="stylesheet">
</header>
<body>
<footer id="footer"><!--Footer-->
	<div class="footer-top">
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
					<div class="companyinfo">
						<img src="${url}/images/logowebsite.png" alt="" height="40" width="180px">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="footer-widget">
		<div class="container">
			<div class="row">
				<div class="col-sm-7">
					<div class="single-widget">
						<h2>Thông tin nhóm</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">Hồ Văn Trường</a></li>
							<li><a href="#">Nguyễn Đức Sáng</a></li>
							<li><a href="#">Nguyễn Bảo Ngọc</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-5">
					<div class="single-widget">
						<h2>Thông tin liên hệ</h2>
					</div>
					<h2>Fanpage</h2>
					<br>
					<br>
					

				</div>
			</div>
		</div>
	</div>
</footer><!--/Footer-->

<!-- mesenger -->
<!-- Load Facebook SDK for JavaScript -->
<div id="fb-root"></div>
<script>
	window.fbAsyncInit = function() {
		FB.init({
			xfbml            : true,
			version          : 'v9.0'
		});
	};

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) return;
		js = d.createElement(s); js.id = id;
		js.src = 'https://connect.facebook.net/en_US/sdk/xfbml.customerchat.js';
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>

<!-- Your Chat Plugin code -->
<div class="fb-customerchat"
	 attribution=setup_tool
	 page_id="113857990536966">
</div>
</body>
</html>