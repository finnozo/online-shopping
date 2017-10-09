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
	window.contextRoot = '${contextRoot}'
</script>
<!-- Bootstrap core CSS -->

<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="/css/bootstrap-readable-theme.css" rel="stylesheet">


<!-- Bootstrap DataTables -->
<link href="/css/dataTables.bootstrap.css" rel="stylesheet">


<!-- Custom CSS -->
<link href="/css/myapp.css" rel="stylesheet">

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
			
			
			<!-- Load only when user clicks show Products -->
			<c:if
				test="${userClickShowProduct == true }">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!-- Load only when user clicks show Products -->
			<c:if
				test="${userClickManageProducts == true }">
				<%@include file="manageProduct.jsp"%>
			</c:if>
			

		</div>

		<!-- /.container -->

		<!-- Footer -->
		<%@include file="share/footer.jsp"%>

		<!-- jQuery -->
		<script src="/js/jquery.js"></script>


		<!-- Bootstrap Core JavaScript -->
		<script src="/js/bootstrap.min.js"></script>

		<!-- DataTable Plugin -->
		<script src="/js/jquery.dataTables.js"></script>

		<!-- DataTable Bootstrap Script -->
		<script src="/js/dataTables.bootstrap.js"></script>



		<!-- Self coded javascript -->
		<script src="/js/myapp.js"></script>
	</div>
</body>

</html>

