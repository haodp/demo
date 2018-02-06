var cmn = cmn || {};
$(function() {

    // multiselect组件左侧边框不显示对应([orig：hidden])
	$('button.multiselect').css('overflow', 'inherit');

	// 增强ajax#error,success方法，加入错误处理
    var _ajax = $.ajax;  

	$(":text").change( function() {
		checkStr($(this));
	});
    
    $.ajax = function(opt) {

        var fn = {
            error : function(XMLHttpRequest, textStatus, errorThrown){},
            appError : function(data, textStatus) {},
            success : function(data, textStatus){}
        };

        if (opt.error) {
            fn.error = opt.error;  
        }

        if (opt.appError) {
            fn.appError = opt.appError;  
        }

        if (opt.success) {
            fn.success = opt.success;  
        }  

        var _opt = $.extend(opt, {
            error : function(XMLHttpRequest, textStatus, errorThrown) {

            	$.extMessager.popup("E", '系统繁忙，请稍后重试！');
                fn.error(XMLHttpRequest, textStatus, errorThrown);
            },  
            success : function(data, textStatus) {

            	if (data.returnCode && data.returnCode !== 0) {
            		if (data.messageInfos[0].id == "fw.e.loginTimeout") {
            			$.extMessager.popup("E", data.messageInfos[0].content, function() {
            				top.window.location.href = contextPath + "/";
            			});

            		} else if (data.messageInfos[0].id == "fw.e.noAuth") {
            			$.extMessager.popup("E", data.messageInfos[0].content);

            		} else {
                        $('.loading-popover-mask').fadeOut(100);
            			$.extMessager.alert("E", null, data.messageInfos[0].content, function() {
							fn.appError(data, textStatus);
						});
            		}
                	return false;
            	}

                $('.loading-popover-mask').fadeOut(100);
                fn.success(data, textStatus);
            }
        });
        _ajax(_opt);
    };
    
});

/**@author 
 * @param valueString 传入的字符串
 * @param nAfterDotNum 保留位数
 * @returns
 */
function formatAfterDotNumber(valueString, nAfterDotNum) {
	if (valueString.trim() == "") {
		return "";
	}
	var resultStr, nTen;
	valueString = "" + Number(valueString) + "";
	strLen = valueString.length;
	dotPos = valueString.indexOf(".", 0);
	if (dotPos == -1) {
		resultStr = valueString + ".";
		for (var i = 0; i < nAfterDotNum; i++) {
			resultStr = resultStr + "0";
		}
		return resultStr;
	} else {
		if((strLen - dotPos - 1) == nAfterDotNum){
			resultStr = valueString;
			return resultStr;
		} else if ((strLen - dotPos - 1) > nAfterDotNum) {
			nAfter = dotPos + nAfterDotNum + 1;
			nTen = 1;
			for (var j = 0; j < nAfterDotNum; j++) {
				nTen = nTen * 10;
			}
			resultStr = Math.round(parseFloat(valueString) * nTen) / nTen;
			return resultStr;
		} else {
			resultStr = valueString;
			for (i = 0; i < (nAfterDotNum - strLen + dotPos + 1); i++) {
				resultStr = resultStr + "0";
			}
			return resultStr;
		}
	}
}

function checkStr(ele) {
	var patrn=/[`$^&*<>"{}\/'[\]]/im;
	if(patrn.test(ele.val())){  
		$.extMessager.popup("E", "您输入的数据含有非法字符");
	}
}

function checkAll(){
	var patrn=/[`$^&*<>"{}\/'[\]]/im;
	var eles = $(":text:not([readonly])");
	for ( var ele in eles) {
		if(patrn.test(eles.get(ele).value)){  
			return "<br>您输入的数据含有非法字符,请检查输入的内容";
		}
	}
	return "";
}

function replaceForbidden(ele){
	ele.value=ele.value.replace(/[`$^&*<>"{}\/'[\]]/img,"");
}