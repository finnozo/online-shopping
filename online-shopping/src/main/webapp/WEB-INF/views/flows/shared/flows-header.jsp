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

<link href="${contextRoot }/static/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${contextRoot }/static/css/bootstrap-readable-theme.css"
	rel="stylesheet">


<!-- Bootstrap DataTables -->
<link href="${contextRoot }/static/css/dataTables.bootstrap.css"
	rel="stylesheet">


<!-- Custom CSS -->
<link href="${contextRoot }/static/css/myapp.css" rel="stylesheet">

</head>

<body>


	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="flows-navbar.jsp" %>

		<!-- Page Content -->
		<div class="content">