 /**
 * 
 */

console.log("Reply module.....");

var replyService = (function() {
	function add(reply, callback, error) {
		// reply : 덧글 객체
		// callback : 덧글 등록 후 수행할 메소드. 비동기
		// 주문과 동시에 처리할 내용도 전달. 페이지 이동없이 새로운 내용 갱신.
		console.log("add reply.....");

		$.ajax({
			type: 'post',
			url: '/replies/new',
			data: JSON.stringify(reply),
			// 전달 받은 객체를 json으로 변환.
			contentType: "application/json; charset=utf-8",
			success: function(result) {
				if (callback) {
					callback(result);
				}
			},
			error: function(er) {
				if (error) {
					error(er);
				}
			}
		});
	}
	return {
		add: add // 변수명.호출명 예) replyService.add
	};
})(); // 즉시 실행 함수: 명시하는 것과 동시에 메모리에 등록.