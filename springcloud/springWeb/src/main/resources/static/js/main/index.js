$(function(){
	$("#username").bind("click",function(){
		$(this).removeClass("styleRed");
	});
	
	wx.ready(function(){
	    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
	});
	wx.error(function(res){
	    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
	});
	
	
		wx.config({
		    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		    appId: 'appId', // 必填，公众号的唯一标识
		    timestamp: "2923874863", // 必填，生成签名的时间戳
		    nonceStr: 'nonceStr', // 必填，生成签名的随机串
		    signature: 'signature',// 必填，签名，见附录1
		    jsApiList: [] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
		});
		
		//注入微信权限配置
		var param = {
				authUrl:window.location.href
//			alert(window.location.href);
		};
/*	Weixin.asyncGetAuthInfo(param).done(function(result) {
		
		wx.config({
		    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		    appId: result.appId, // 必填，公众号的唯一标识
		    timestamp: result.timestamp, // 必填，生成签名的时间戳
		    nonceStr: result.noncestr, // 必填，生成签名的随机串
		    signature: result.signature,// 必填，签名，见附录1
		    jsApiList: [result.interface1,result.interface2,result.interface3,result.interface4,result.interface5,result.interface6] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
		});
	}).fail(function(result) {
//		alert('微信注入权限认证失败，请重试。');
//		alert(result);
	});*/
	
/*		selectImg = function(vm, evt){
			wx.chooseImage({
			    count: 1, // 默认9
			    sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
			    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
			    success: function (res) {
			        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
			        
			        //上传图片
			        wx.uploadImage({
			            localId: localIds[0], // 需要上传的图片的本地ID，由chooseImage接口获得
			            isShowProgressTips: 1, // 默认为1，显示进度提示
			            success: function (res) {
			                var serverId = res.serverId; // 返回图片的服务器端ID 即media_id
			                
		                	//将微信服务器上的图片存入oss
		                	var param = {
	                			serverId:serverId
		                	};
		                	Weixin.asyncSaveUserPic(param).done(function(result){
			                	$("#user_picture").attr("src",result.userPicUrl);
			                	$('.modalBg').fadeOut();
		                	}).fail(function(data){
			            		alert('将微信服务器上的图片存入oss出错。');
			            	});
			                	
			            }
			        });
			    }
			});
		};*/

	
	
});