function attacheLargePreview(){
	var files = $(this).next()[0].files;
    var reader = new FileReader();
    reader.onload = (function(theFile) {
        return function(e) {
        	var $imgEle = $("<img id='popWinImg'/>");
            $imgEle[0].src=e.target.result;
                    
            var $dialogEle = $('<div></div>').dialog({});

            var $dialog_ = $(".modal-dialog");                      
            $dialog_.parent().append( $imgEle );
            $dialog_.remove()

            $imgEle.width($('.dialog').width());
            $imgEle.on('click',function(){
            	$dialogEle.dialog("destroy");    
                $(".dialog").remove();
                $(".modal-backdrop").remove();
                $("body").removeClass("modal-open");
            });
        };             
    })(files[0]);
    reader.readAsDataURL(files[0]);
};