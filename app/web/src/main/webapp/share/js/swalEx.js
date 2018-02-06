function swalAlert( text ){
	swal({
        title:"",       
		text: "<font color='#000'>" + text + "</font>",   
	    html: true,
	    confirmButtonText:"确定",
	    confirmButtonColor: "#9E9E9E"
	});
}

/**
 * 如果有变化，返回false. 如果没有变化，返回true.
 */
 function checkNumber( idStr){
      
	  var ele =  $(idStr);
	  console.log( ele.val() );    
	  var v1 = ele.val();
	  var v2 = parseInt( v1 );	  
	  console.log(  v2 );	  
	  ele.val( v2 );
	  if( (v1+"") !==(v2+"") ){
		  ele.val("");
	  }
	  return (v1+"")===(v2+"");
 };
 /**
 //判断手机Ios or Android
 //return:
 //  Android  安卓手机
 //  iOS      苹果手机 
 //  other    其它类型手机  
 */  
 function GetPhoneType(){
	    var PhoneType="other";
	    
		var u = navigator.userAgent, app = navigator.appVersion;
		//android终端或者uc浏览器
		var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1; 
		//ios终端
		var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
		if (isAndroid==true){
			//alert('是否是Android：'+isAndroid);		
			PhoneType="Android";
		}
		if (isiOS==true){
			//alert('是否是iOS：'+isiOS);
			PhoneType="iOS";
		
		}

		return PhoneType;
		
	}