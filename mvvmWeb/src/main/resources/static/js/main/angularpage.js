var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {
	$scope.massgae = "提示信息";
	$scope.userList = "";

	$scope.updateAge = function(user) {
		user.age = user.age + 1;
		$scope.massgae = "增加年龄成功！";
	};

	$scope.getData = function(user) {

		$http({
			method : "GET",
			url : "http://localhost:9999/mvvmweb/getUserList",
			headers : {
				"dataType" : "json"
			},
			data : {}
		}).success(function(data) {
			$scope.userList = data;
		}).error(function(error) {

		});
	};

	$scope.addData = function() {
		var last = $scope.userList[$scope.userList.length - 1];
		var newUser = {
			id : last.id + 1,
			age : last.age + 10,
			name : "haichen"
		}
		$scope.userList.push(newUser);
		$scope.massgae = "添加成功！";
	};

	$scope.reverseData = function() {
		$scope.userList.reverse();
	};
	$scope.showData = function(user) {
		alert("id: " + user.id + " ,name: " + user.name + " ,age: " + user.age);
	};
});
