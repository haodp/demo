$(function() {
	var app = new Vue({
		el : '#app',
		data : {
			message : '提示信息!',
			rowdata : ''
		},
		methods : {
			getData : function() {
				$.ajax({
					type : "GET",
					url : "http://localhost:9999/mvvmweb/getUserList",
					data : {},
					dataType : "json",
					success : function(data) {
						app.message = "获取成功！";
						app.rowdata = data;
					}
				});

			},
			updatAge : function(user, index, $event) {
				user.age = user.age + 1;
				this.message = "增加年龄成功！";
			},
			addData : function() {
				var last = app.rowdata[app.rowdata.length - 1];
				var newUser = {
						id : last.id + 1,
						name :"haichen",
						age : last.age +10
				}
				app.rowdata.push(newUser);
				this.message = "添加数据成功！";
			},
			reverseData : function() {
				this.rowdata.reverse();
				this.message = "反序成功！";
			},
			showData : function(user) {
				alert("id: " + user.id + " ,name: " + user.name + " ,age: " + user.age);
			},
		}
	})
});