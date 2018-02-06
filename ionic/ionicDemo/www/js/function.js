//判断变量是否存在
function isExitsVariable(variableName) {
    try {
        if (typeof(variableName) == "undefined") {
            //alert("value is undefined");
            return false;
        } else {
            //alert("value is true");
            return true;
        }
    } catch(e) {}
    return false;
}

//获取URL参数
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}

//二维数组排序
function listSortBy(arr, field, order){
    var refer = [], result=[], order = order=='asc'?'asc':'desc', index;
    for(i=0; i<arr.length; i++){
        refer[i] = arr[i][field]+':'+i;
    }
    refer.sort();
    if(order=='desc') refer.reverse();
    for(i=0;i<refer.length;i++){
        index = refer[i].split(':')[1];
        result[i] = arr[index];
    }
    return result;
}

//检查元素是否在数组中
function inArray(needle,arr){
    for(var i in arr){
        if(arr[i] == needle){
            return true;
        }
    }
    return false;
}

//合并对象
function extend(o,n,override){
    for(var p in n)
        if(n.hasOwnProperty(p) && (!o.hasOwnProperty(p) || override))
            o[p]=n[p];
}

//验证手机格式
function validatemobile(tel){
    mobile = tel.toString();
    if(mobile.length==0)
    {
        return false;
    }
    if(mobile.length!=11)
    {
        return false;
    }
    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1})|147|145)+\d{8})$/;
    if(!myreg.test(mobile))
    {
        return false;
    }
    return true;
}

//将数组元素插入到指定的位置
Array.prototype.insert = function(index,item){
    this.splice(index, 0, item);
}

//比对购物车中是否有当前预约的这个商品
function contains(arr,obj) {
    var i = arr.length;
    while(i--){
        if (arr[i].id == obj.id) {
            return true;
        }
    }
    return false;
}

if (!Array.prototype.forEach) {
    Array.prototype.forEach = function(callback, thisArg) {
        var T, k;
        if (this == null) {
            throw new TypeError(" this is null or not defined");
        }
        var O = Object(this);
        var len = O.length >>> 0; // Hack to convert O.length to a UInt32
        if ({}.toString.call(callback) != "[object Function]") {
            throw new TypeError(callback + " is not a function");
        }
        if (thisArg) {
            T = thisArg;
        }
        k = 0;
        while (k < len) {
            var kValue;
            if (k in O) {
                kValue = O[k];
                callback.call(T, kValue, k, O);
            }
            k++;
        }
    };
}

Array.prototype.remove = function(val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
}

function getCookie(cookie_name) {
    var allcookies = document.cookie;
    var cookie_pos = allcookies.indexOf(cookie_name);   //索引的长度
    // 如果找到了索引，就代表cookie存在，
    // 反之，就说明不存在。
    if (cookie_pos != -1){
    // 把cookie_pos放在值的开始，只要给值加1即可。
        cookie_pos += cookie_name.length + 1;      //这里我自己试过，容易出问题，所以请大家参考的时候自己好好研究一下。。。
        var cookie_end = allcookies.indexOf(";", cookie_pos);
        if (cookie_end == -1) {
            cookie_end = allcookies.length;
        }
        var value = unescape(allcookies.substring(cookie_pos, cookie_end)); //这里就可以得到你想要的cookie的值了。。。
    }
    return value;
}

//判断是否微信浏览器
function isWeiXin(){
    var ua = window.navigator.userAgent.toLowerCase();
    if(ua.match(/MicroMessenger/i) == 'micromessenger'){
        return true;
    }else{
        return false;
    }
}

//获取两位数的月份数
function getMonthForTwoNum(date){
    if((date.getMonth()) < 9){
        return '0'+(date.getMonth()+1);
    }else{
        return date.getMonth()+1;
    }
}

//获取两位数的日期数
function getDateForTwoNum(date){
    if((date.getDate()) < 10){
        return '0'+(date.getDate());
    }else{
        return date.getDate();
    }
}

//弹出提示框
function prompt4m() {
    //默认设置
    var dcfg={
        msg:"提示信息",
        postion:"top",//展示位置，可能值：bottom,top,middle,默认top：是因为在mobile web环境下，输入法在底部会遮挡toast提示框
        time:3000,//展示时间
    };
    //*********************以下为参数处理******************
    var len = arguments.length;
    if(arguments.length>0){
        dcfg.msg =arguments[0];
        var arg1 =arguments[1];
        var regx = /(bottom|top|middle)/i;
        var numRegx = /[1-9]\d*/;
        if(regx.test(arg1)){
            dcfg.postion=arg1;
        }else if(numRegx.test(arg1)){
            dcfg.time=arg1;
        }

        var arg2 =arguments[2];
        var numRegx = /[1-9]\d*/;
        if(numRegx.test(arg2)){
            dcfg.time=arg2;
        }
    }
    //*********************以上为参数处理******************
    if ($(".prompt4m").length <= 0) {
        $("body").append("<div class='prompt4m'>" + dcfg.msg + "</div>");
    } else {
        $(".prompt4m").html(dcfg.msg);
    }
    var w = $(".prompt4m").width(),ww = $(window).width();
    $(".prompt4m").fadeIn(1000);
    $(".prompt4m").css("left",(ww-w)/2-10);
    if("bottom"==dcfg.postion){
        $(".prompt4m").css("bottom",80);
        $(".prompt4m").css("top","");//这里为什么要置空，自己琢磨，我就不告诉
    }else if("top"==dcfg.postion){
        $(".prompt4m").css("bottom","");
        $(".prompt4m").css("top",80);
    }else if("middle"==dcfg.postion){
        var h = $(".prompt4m").height(),hh = $(window).height();
        $(".prompt4m").css("bottom",(hh-h)/2-10);
    }
    setTimeout(function() {
        $(".prompt4m").fadeOut();
    }, dcfg.time);
}

var base64EncodeChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
var base64DecodeChars = new Array(
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,
    52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
    -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,
    15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
    -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
    41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1);
//Base64图片解码
function base64decode(str) {
    var c1, c2, c3, c4;
    var i, len, out;
    len = str.length;
    i = 0;
    out = "";
    while(i < len) {
        /* c1 */
        do {
            c1 = base64DecodeChars[str.charCodeAt(i++) & 0xff];
        } while(i < len && c1 == -1);
        if(c1 == -1)
            break;
        /* c2 */
        do {
            c2 = base64DecodeChars[str.charCodeAt(i++) & 0xff];
        } while(i < len && c2 == -1);
        if(c2 == -1)
            break;
        out += String.fromCharCode((c1 << 2) | ((c2 & 0x30) >> 4));
        /* c3 */
        do {
            c3 = str.charCodeAt(i++) & 0xff;
            if(c3 == 61)
                return out;
            c3 = base64DecodeChars[c3];
        } while(i < len && c3 == -1);
        if(c3 == -1)
            break;
        out += String.fromCharCode(((c2 & 0XF) << 4) | ((c3 & 0x3C) >> 2));
        /* c4 */
        do {
            c4 = str.charCodeAt(i++) & 0xff;
            if(c4 == 61)
                return out;
            c4 = base64DecodeChars[c4];
        } while(i < len && c4 == -1);
        if(c4 == -1)
            break;
        out += String.fromCharCode(((c3 & 0x03) << 6) | c4);
    }
    return out;
}