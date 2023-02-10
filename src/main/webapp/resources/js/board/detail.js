$(function(){
		$('.viewMode').hide(); 
	
	let viewForm = $('#viewForm');
	let titleObj = $('input[name="title"]');
	let contentObj = $('textarea[name="content"]');
	let imageFile= "${board.imageFileName}"; 
	let pTag = $('.preview p').html(); 
	
	let originImg = $('.originImg').clone(); 
	let titleVal = titleObj.val(); // 제목 
	let contentVal = contentObj.val(); // 내용
	
	// 수정
	$('.toModForm').on('click',function(){
		$('input[name="title"],textarea[name="content"]').attr("readonly",false);
		$('.viewMode').show();
		$(this).closest('tr').hide();
	});
	
	// 뷰
	$('.backViewMode').on('click',function(){
		$('input[name="title"],textarea[name="content"]').attr("readonly",true);
		$('.viewMode').hide();
		$(this).closest('tr').prev().show();
		$('.preview').html(originImg); // 수정전 이미지 복원
		$('input[type="file"]').val(''); // 파일폼 초기화
		titleObj.val(titleVal); // 수정전 제목 복원
		contentObj.val(contentVal); // 수정전 내용 복원
		if(imageFile==''||imageFile==null){ // 이거
			$('.preview').html(pTag);
		}
	});
	
	// 목록으로
	$('.toList').on('click',function(){
		viewForm.attr({
			"action" : `${contextPath}/board/list`,
			"method" : "get"
		}).empty() // 파라미터 정보 삭제
		.submit(); 
	});
	
	// 수정 처리 
	$('.modify').on('click',function(){
		let cate = $('.bidChoice').val();
		
		viewForm.attr({
			"action" : `${contextPath}/board/modBoard`,
			"method" : "post"
		}).submit();
		alert('수정되었습니다.')
		
	});
	
	// 삭제 처리 
	$('.remove').on('click',function(){
		viewForm.attr({
			"action" : `${contextPath}/board/removeBoard`,
			"method" : "post"
		}).submit();
	});
});


//ㄷ새글 관련 이벤트
$(function(){
	let bno = $('input[name="bno"]').val();
	// 댓글 목록 
	console.log(replyService);
	
	
	replyService.list(bno);
	
	// 댓글 쓰기 버튼 이벤트
	$('.reply_write').on('click',function(){
		let writer = $('.replyForm .reply_writer').val();
		let reply = $('.replyForm .reply_content').val();
		if(reply.length<5){
			$('.reply_content').attr('placeholder','최소5글자 이상 입력하세요')
							.addClass('reply_content_error');
			alert('no')
			return;
		}
		alert('ok')
		let replyVO = {
			bno : bno, 
			reply : reply, 
			writer : writer
		}		
		replyService.write(replyVO);
	});
	
	
	// 댓글 수정 버튼 이벤트
	$('.replyList').on('click','.reply_modBtn',function(){
		let rno = $(this).closest('div').data('rno');
		alert('수정입니다' + rno + '번')
	});
	
	// 댓글 삭제 버튼 이벤트
	$('.replyList').on('click','.reply_delBtn',function(){
		let rno = $(this).closest('div').data('rno');
		
		replyService.remove(rno);
	});
	
	
})