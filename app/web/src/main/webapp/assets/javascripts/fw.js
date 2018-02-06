contextPath = window.document.location.pathname.substring(0,
		window.document.location.pathname.substr(1).indexOf('/') + 1);

ws_url_district = "/doctors/districtDoctors";
ws_url_ventilator = "/doctors/ventilatorDoctors";

$.extMessager = (function() {

	var alert = function(type, title, message, callback) {
		var model = $.extMessager.model;
		var dialogClass = null;
		var btnClass = "btn-default";
		if (type === "I") {
			defalutTitle = "提示";
			dialogClass = "modal-dialog-info";
			btnClass = "btn btn-info";
		} else if (type === "W") {
			defalutTitle = "警告";
			dialogClass = "modal-dialog-warning";
			btnClass = "btn btn-warning";
		} else if (type === "E") {
			defalutTitle = "错误";
			dialogClass = "modal-dialog-error";
			btnClass = "btn btn-danger";
		}

		$('<div>' + message + '</div>').dialog({
			title : title || defalutTitle,
			dialogClass : dialogClass,
			onClose : function() {
				$(this).dialog("destroy");
				callback && callback();
			},
			buttons : [ {
				text : model.ok.text,
				classed : model.ok.classed || btnClass,
				click : function() {
					$(this).dialog("destroy");
					callback && callback();
				}
			} ]
		});
	};

	/*
	 * popup message
	 */
	var msghtml = ''
		    + '<div class="dialog modal fade msg-popup">'
				+ '<div class="modal-dialog modal-sm">'
					+ '<div class="modal-content">'
					    + '<div class="modal-body text-center"></div>'
					+ '</div>'
				+ '</div>'
			+ '</div>';

	var $msgbox = undefined, offTimer = null;

	var popup = function(type, message, callback) {
		if (!$msgbox) {
			$msgbox = $(msghtml);
			$('body').append($msgbox);
		}

		newMessage = message;
		if (type === "S") {
			popupClass = 'popup-success';
		} else if (type === "I") {
			popupClass = 'popup-info';
		} else if (type === "W") {
			popupClass = 'popup-warning';
		} else if (type === "E") {
			popupClass = 'popup-error';
		}

		$msgbox.find(".modal-body").removeClass("popup-success");
		$msgbox.find(".modal-body").removeClass("popup-info");
		$msgbox.find(".modal-body").removeClass("popup-warning");
		$msgbox.find(".modal-body").removeClass("popup-error");
		$msgbox.find(".modal-body").addClass(popupClass || "");
		$msgbox.find(".modal-body").html(message);
		$msgbox.modal({
			show : true,
			backdrop : false
		});

		clearTimeout(offTimer);
		offTimer = setTimeout(function() {
			$msgbox.modal('hide');
			callback && callback();
		}, 1500);//提示消息弹出时间
	};

	return {
		alert : alert,
		popup : popup
	};

})();

$.extMessager.model = {
	ok : {
		text : "确定"
	}
};

$.messager.model = {
	ok:{ text: "确定", classed: 'btn-default' },
	cancel: { text: "取消", classed: 'btn-default' }
};