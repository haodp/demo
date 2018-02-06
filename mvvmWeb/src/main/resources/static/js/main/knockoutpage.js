$(function() {
	// start ko
	var ViewModel = function() {
		var self = this;
		self.userList = ko.observableArray();
		self.massage = ko.observable("提示信息");
		self.deleteItem = function(vm, evt) {
			self.userList.remove(vm);
			self.massage("删除成功！");
		};
		self.getData = function(vm, evt) {
			$.ajax({
				type : "GET",
				url : "http://localhost:9999/mvvmweb/getUserList",
				data : {},
				dataType : "json",
				success : function(data) {
					self.userList(data);
					self.massage("获取数据成功！");
				}
			});
		};
		self.addData = function(vm, evt) {
			var last = self.userList()[self.userList().length - 1];
			var newUser = {
				id : last.id + 1,
				name : "haichen",
				age : last.age + 10
			}
			self.userList.push(newUser);
			self.massage("添加成功！");

		};
		self.updateAge = function(vm, evt) {
			var updUser = {
				id : vm.id,
				name : vm.name,
				age : vm.age
			};
			updUser.age = updUser.age + 1;
			self.userList.remove(vm);
			self.userList.push(updUser);
			self.userList.sort(function(left, right) {
				return left.id == right.id ? 0 : (left.id < right.id ? -1 : 1)
			});
			self.massage("年龄更新成功！");
		};
		self.reverseData = function(vm, evt) {
			self.userList.reverse();
		};
		self.deleteData = function(vm, evt) {
			self.userList.removeAll();
		};
		self.showData = function(vm, evt) {

			alert("id: " + vm.id + " ,name: " + vm.name + " ,age: " + vm.age);
		};

	};
	
	viewModel = new ViewModel();
	ko.applyBindings(viewModel);
	// end ko
});