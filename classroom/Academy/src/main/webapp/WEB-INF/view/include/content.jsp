<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html lang="utf-8">
<!-- 메인 컨텐츠 -->

<div id="content">

	<!-- topbar -->
	<%@include file="../include/content_topbar.jsp"%>

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">Tables</h1>
		<p class="mb-4">
			DataTables is a third party plugin that is used to generate the demo
			table below. For more information about DataTables, please visit the
			<a target="_blank" href="https://datatables.net">official
				DataTables documentation</a>.
		</p>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">DataTables
					Example</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>#번호</th>
								<th>수강과정</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								
								
								
							</tr>
						</thead>

						<c:forEach items="${list}" var="Bbs">
							<tr>
								<td><c:out value="${Bbs.bbsID}" /></td>

								<td><c:out value="${Bbs.studycode}" /></td>
								
								<td><a href='/board/get?bbsID=<c:out value="${Bbs.bbsID}"/>'>
										<c:out value="${Bbs.bbsTitle }" />
								</a></td>

								<td><c:out value="${Bbs.userid}" /></td>
								
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${Bbs.bbsDate}" /></td>
										
										
							</tr>
						</c:forEach>
					</table>
					<!-- 글쓰기 버튼 넣기 -->
					<div class="modal-footer">
				<button type="button" onclick="location.href='register' " class="btn btn-info">글쓰기</button>
			</div>
			<!-- 글쓰기 버튼 넣기 끝 -->
				</div>
			</div>
		</div>

	</div>
	<!-- /.container-fluid -->

</div>
<!-- 컨텐츠 끝 -->
</html>
