<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="utf-8">

<head>
<%@include file="../include/header.jsp"%>
</head>
<body class="bg-gradient-primary">

	<script type="text/javascript">
		$(function() {
			const formObj = $("form");

			$('button').on("click", 
				function(e) 
				{
				
				e.preventDefault();

				const operation = $(this).data("oper");

				console.log(operation);

				if (operation === 'remove') 
				{
					formObj.attr("action", "/board/remove");
				} else if (operation === 'list') 
				{
					//self.location = "/board/list";
					formObj.attr("action", "/board/list").attr("method", "get");
					formObj.empty();
					//return;
				}
				formObj.submit();
			});
		});
	</script>


	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-5">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">게시글 수정</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Board Modify</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<form role="form" action="/board/modify" method="post">
									<!-- 입력 시작 -->
									<div class="form-group">
										<label>bbsID</label> <input class="form-control" name='bbsID'
											value='<c:out value="${board.bbsID }"/>' readonly="readonly" />
									</div>

									<div class="form-group">
										<label>Title</label> <input class="form-control" name='bbsTitle'
											value='<c:out value="${board.bbsTitle }"/>'>
									</div>

									<div class="form-group">
										<label>Text area</label>
										<textarea class="form-control" rows="3" name='bbsContent'>
									<c:out value="${board.bbsContent}" /></textarea>
									</div>

									<div class="form-group">
										<label>Writer</label> <input class="form-control"
											name='userid' value='<c:out value="${board.userid }"/>'
											readonly="readonly" />
									</div>

									<div class="form-group">
										<label>bbsDate</label> <input class="form-control"
											name='bbsDate'
											value='<fmt:formatDate pattern = "yyyy/MM/dd"
										value="${board.bbsDate }"/>'
											readonly="readonly" />
									</div>

									<%-- <div class="form-group">
										<label>Update Date</label> <input class="form-control"
											name='updateDate'
											value='<fmt:formatDate pattern = "yyyy/MM/dd"
										value="${board.updateDate }"/>'
											readonly="readonly" />
									</div> --%>
									<!-- 수정 날짜를 넣는것이 좋을까? 일단 빼자, 최초 업로드일만 남겨놓는다. -->
									
									<button data-oper='submit' data-oper='modify'
										class="btn btn-info">Modify</button>
									<button data-oper='submit' data-oper='remove'
										class="btn btn-danger">remove</button>
									<button data-oper='submit' data-oper='list'
										class="btn btn-info">List</button>
								</form>

							</div>
							<!-- panel-body 끝 -->
						</div>
						<!-- end panel-body -->
					</div>
					<!-- end panel-->
				</div>
				<!-- /.row -->


			</div>

		</div>
	</div>


	<!-- null -->

</body>

</html>