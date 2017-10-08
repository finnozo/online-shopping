<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">

<head>
<title>Online Shopping - ${title }</title>
<script type="text/javascript">
	window.menu = '${title }';
</script>
<!-- Bootstrap core CSS -->

<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/shop-homepage.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="share/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!-- Load only when user clicks Home -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>
			<!-- Load only when user clicks about -->
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>
			<!-- Load only when user clicks contact -->
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Load only when user clicks all Products -->
			<c:if
				test="${userClickAllProducts == true or  userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>

		</div>

		<!-- /.container -->

		<!-- Footer -->
		<%@include file="share/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="/vendor/jquery/jquery.min.js"></script>
		<script src="/vendor/popper/popper.min.js"></script>
		<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="/js/myApp.js"></script>
	</div>
</body>

</html>
