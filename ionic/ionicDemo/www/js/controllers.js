angular.module('starter.controllers', [])

  .controller('HomeCtrl', function ($scope, Local) {
    Local.set("username", "haichen");
  })

  .controller('OrdersCtrl', function ($scope, $rootScope, $ionicHistory, $ionicSlideBoxDelegate, $stateParams, Session, $state, PopModel, Orders) {
    var user = {
      id: 1,
      name: "haichen"
    };

    Orders.getOrderList(user)
      .then(function (res) {
        $scope.orderList = res.data;
        //PopModel.showAlert('提示信息','获取订单失败！');
        prompt4m('获取订单成功！', 'bottom');
      }, function (err) {

      });
    $scope.orderDetail = function (order) {
      Session.set("selectOrder", order);
      $state.go("app.orderdetail");
    };
  })

  .controller('OrderDetailCtrl', function ($scope, $stateParams, Session, Orders) {
    if (Session.hasItem("selectOrder")) {
      $scope.order = Session.get("selectOrder");
    }
  })

  .controller('UserCtrl', function ($scope,Local) {
    $scope.settings = {
      enableFriends: true
    };
    $scope.username = Local.get("username");
  });
