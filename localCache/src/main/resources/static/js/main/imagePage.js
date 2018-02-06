$(function() {
	$("#uploadBtn").bind("click", function() {
		alert("up");
		var formData = new FormData($("#uploadForm")[0]);
		$.ajax({
			url : '/file/uploadFile',
			type : 'POST',
			data : formData,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(returndata) {
				alert(returndata);
			},
			error : function(returndata) {
				alert(returndata);
			}
		});
	});

});