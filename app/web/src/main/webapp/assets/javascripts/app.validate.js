var cmn = cmn || {};

$(function() {

	$.validator.addMethod("mselectRequired", function(value, element, params){
		return $(element).val() !== params[0]; //不相等(非空):true; 相等(空):false
	}, "必须填写");
});


/**
 * 表单验证
 * @param rules 校验规则
 */
cmn.setFormValidation = function(options) {

	$(".validate-form").each(function(i, elem) {
        return $(elem).validate({
        	rules: options.rules || {},
        	ignore: options.ignore, //':hidden:not("#reqMode")',
            errorElement: "span",
            errorClass: "help-block has-error",
            errorPlacement: function(e, t) {
                t.parents(".valid-group").append(e);
            },
            highlight: function(t) {
            	$(t).siblings('button.multiselect').removeClass("has-error has-success").addClass("has-error");
                $(t).closest(".form-group").removeClass("has-error has-success").addClass("has-error");
            },
            unhighlight: function(t) {
            	$(t).siblings('button.multiselect').removeClass("has-error");
                $(t).closest(".form-group").removeClass("has-error");
            }
        });
    });

};