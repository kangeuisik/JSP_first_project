$(function(){
	 let listForm = $('#listForm');
	 
	 $('.addRank').on('click',function(e){
		e.preventDefault();
		$('[name="mno"]').remove();
		let mnoData = "<input type='hidden'name='mno='"+$(this).attr('href')+"'/>";
		
		listForm.append(mnoData)
			.attr("action",`${contextPath}/edu/memberEduForm`)
			.submit();
	});
});