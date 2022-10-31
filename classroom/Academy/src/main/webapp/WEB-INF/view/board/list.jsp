<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<!DOCTYPE html>
<html lang="utf-8">

<head>
  

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- side bar -->
		<%@include file="../include/sidebar.jsp"%>
		<!-- side bar END -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- main content -->
			<%@include file="../include/content.jsp"%>
			<!-- main content END -->

			<!-- footer -->
			<%@include file="../include/footer.jsp"%>
			<!-- footer END -->
		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> 
	<i class="fas fa-angle-up"></i>
	</a>

	<!-- 모달 -->
	<%@include file="../include/modal.jsp"%>

</body>

</html>