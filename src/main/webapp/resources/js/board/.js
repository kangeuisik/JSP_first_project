$(function(){
	 let listForm = $('#listForm');
	 
	 $('.title').on('click',function(e){
		e.preventDefault();
		$('[name="pbno"]').remove();
		let bnoData = "<input type='hidden'name='pbno'value='"+$(this).attr('href')+"'/>";
		
		listForm.append(bnoData)
			.attr("action",`${contextPath}/parentsboard/detail`)
			.submit();
	});
});