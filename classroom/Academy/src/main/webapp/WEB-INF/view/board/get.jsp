<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<%@include file="../include/header.jsp"%>

<body class="bg-gradient-primary">

	<script type="text/javascript">
		$(function() {
			
			const formObj = $("#operForm"); //id라서 #을 붙인다. role이 아님

			$('button').on("click", function(e) {
				e.preventDefault();

				const operation = $(this).data("oper");

				console.log(operation);

				if (operation === 'remove') {
					formObj.attr("action", "/board/remove");
				} else if (operation === 'list') {
					//self.location = "/board/list";
					formObj.find("#bno").remove();
					formObj.attr("action","/board/list")
				}
				formObj.submit();
			});
		});
	</script>
	<script type="text/javascript" src="/resources/js/reply.js">
	
	var bnoValue = '<c:out value="${board.bno}"/>';
	
	replyService.add({
		reply : "js test",
		replyer : "tester",
		bno : bnoValue
	}, function(result){
		alert("result: " + result);
	});
	 // 게시글을 읽을때 자동으로 댓글 1개 등록.
	
	</script>

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-5">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">게시글 1개 조회</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Board Read Page</div>
							<!-- /.panel-heading -->
							<div class="panel-body">

								<div class="form-group">
									<label>Bno</label> <input class="form-control" name='bno'
										value='<c:out value="${board.bno }"/>' readonly="readonly" />
								</div>

								<div class="form-group">
									<label>Title</label> <input class="form-control" name='title'
										value='<c:out value="${board.title }"/>' readonly="readonly" />
								</div>

								<div class="form-group">
									<label>Text area</label>
									<textarea class="form-control" rows="3" name='content'
										readonly="readonly"><c:out value="${board.content}" /> </textarea>
								</div>

								<div class="form-group">
									<label>Writer</label> <input class="form-control" name='writer'
										value='<c:out value="${board.writer }"/>' readonly="readonly" />
								</div>


								<!-- 	<button data-oper='modify' class="btn btn-default">Modify</button> -->
								<!-- 	<button data-oper='list' class="btn btn-info">List</button>  -->
								<!-- 버튼을 누르고 수정을 완료하는것이 아닌, 수정창을 띄우는 버튼이 되어야한다. -->
								<%-- 	<button data-oper='modify' class="btn btn-default">
								<a href="/board/modify?bno=<c:out value="${board.bno}"/>">Modify</a>
								</button>
								<!-- 삭제버튼 -->
								<button data-oper='remove' class="btn btn-danger">
									<a href="/board/remove?bno=<c:out value="${board.bno}"/>">Remove</a>
								</button>
								<!-- 리스트 버튼 -->
								<button data-oper='list' class="btn btn-info">
									<a href="/board/list">List</a>
								</button> --%>

								<!-- submit 버튼으로 대체 -->
								<button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
								<button type="submit" data-oper="remove" class="btn btn-default">Remove</button>
								<button type="submit" data-oper="list" class="btn btn-default">List</button>

								<form id='operForm' action="/board/modify" method="get">
									<!-- get방식, 수정창 띄워야함 -->
									<input type='hidden' id='bno' name='bno'
										value='<c:out value="${board.bno }"/>'>
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