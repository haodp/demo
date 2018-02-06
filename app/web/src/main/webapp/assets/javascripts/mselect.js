/*
 * 下拉菜单控件
 */

function Select(selector, option) {
	var self = this;
	if (option.buttonWidth === undefined) {
		option.buttonWidth = "125px";
	}
	option.allSelectedText='';
	option.nonSelectedText='请选择';
	selector.multiselect(option);
	if (option.data === undefined) {
		if (option.url !== undefined) {
			$.ajax({
				url : option.url,
				type : 'POST',
				dataType : 'json',
				data : option.param,
				async : option.async ===undefined?true: option.async,
				success : function(data) {
					self.initSelectData(selector, option, data);
				}
			});
		}
	} else {
		self.initSelectData(selector, option, option.data);
	}
}

Select.prototype = {
	initSelectData : function(selector, option, data) {
		if (option.root !== undefined) {
			data = data[option.root];
		}
		var dataprovider = [];
		if (option.blankItem) {
			dataprovider.push({title:'请选择', label:'请选择'});
		}
		if (option.valueField !== undefined
				|| option.textField === undefined) {
			for (var i in data) {
				var item = {};
				if (option.valueField !== undefined) {
					item.value = data[i][option.valueField];
				}
				if (option.textField !== undefined) {
					item.label = data[i][option.textField];
					item.title = data[i][option.textField];
				}
				dataprovider.push(item);
			}
		}
		selector.multiselect('dataprovider', dataprovider);
		if (option.blankItem) {
			selector.val(null);
			selector.next().find("input[type='radio']").prop("checked", false);
		}
		
		if (option.onLoadSuccess !== undefined) {
			option.onLoadSuccess(data);
		}
	},
	reload : function(param, selector, self) {
		var options = selector.data("options");
		var url = options.url;
		if (url) {
			$.ajax({
				url : url,
				type : 'POST',
				dataType : 'json',
				data : param,
				async : options.async ===undefined?true: options.async,
				success : function(data) {
					self.initSelectData(selector, options, data);
				}
			});
		} else {
			self.initSelectData(selector, options, selector.data("options")['data']);
		}
	},
	select : function(param, selector, self) {
		selector.multiselect("select", param, true);
	}
};

$.fn.mselect = function(opt, param, extraOptions) {
	var self = $(this).data("self");
	// 执行方法
	if (typeof(opt) === "string" ) {
		if (self[opt]) {
			self[opt](param, $(this), self);
		} else {
			$(this).multiselect(opt, param, extraOptions);
		}
		
	// 初始化
	} else if (typeof(opt) === "object" ) {
		$(this).data("options", $.extend(true, $(this).data("options"), opt));
		if (!self) {
			self = new Select($(this), opt);
			$(this).data("self", self);
		}
	}
};

