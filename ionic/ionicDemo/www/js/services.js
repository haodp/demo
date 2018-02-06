angular.module('starter.services', [])

  .factory('Orders', function ($http, API_URL, REQUEST, TOKEN) {
    var orders = new Object();
    orders.getOrderList = function (user) {
      return $http.post(
        API_URL + REQUEST.ORDER_LIST,
        {
          "token": TOKEN,
           "id":user.id
        }
        );
    };
    orders.getOneOrder = function () {

    };
    return orders;
  })
  .factory('PopModel', function ($ionicLoading, $ionicBackdrop, $ionicPopup) {
    return {
      //背景黑幕
      locks: 0,
      //手动调用的加载框
      myLoading: function (msg) {
        $ionicLoading.show({
          template: '<div class="text-center"><ion-spinner class="circles"></ion-spinner><br />' + msg + '</div>'
        });
      },
      //隐藏加载框
      myhide: function () {
        $ionicLoading.hide();
      },
      //自动调用的加载框
      loading: function (msg) {
        $ionicLoading.show({
          template: '<div class="text-center"><ion-spinner class="circles"></ion-spinner><br />' + msg + '</div>'
        });
      },
      //隐藏加载框
      hide: function () {
        $ionicLoading.hide();
      },
      //保持背景幕
      retain: function () {
        $ionicBackdrop.retain();
        this.locks++;
      },
      //释放背景幕
      release: function () {
        $ionicBackdrop.release();
        this.locks > 0 ? this.locks-- : 0;
      },
      //确认对话框
      showConfirm: function (content) {
        var confirmPopup = $ionicPopup.confirm({
          title: '<h3>' + title + '</h3>',
          template: '<p style="text-align:center;margin:20px auto;">' + content + '</p>'
        });
        confirmPopup.then(function (res) {
          if (res) {
            console.log('You are sure');
          } else {
            console.log('You are not sure');
          }
        });
      },
      //提示对话框（居中）
      showAlert: function (title, content) {
        var alertPopup = $ionicPopup.alert({
          title: '<h2 class="alert-title red-color no-margin-padding">' + title + '</h2>',
          template: '<p class="alert-content">' + content + '</p>',
          okText: '确 认'
        });
        alertPopup.then(function (res) {
          //console.log('Thank you for not eating my delicious ice cream cone');
        });
      },
      //提示对话框(左对齐)
      showAlertLeft: function (title, content) {
        var alertPopup = $ionicPopup.alert({
          title: '<h2 class="alert-title royal no-margin-padding">' + title + '</h2>',
          template: '<p class="alert-content-left">' + content + '</p>',
          okText: '确 认'
        });
        alertPopup.then(function (res) {
          //console.log('Thank you for not eating my delicious ice cream cone');
        });
      },
      //提示对话框
      showNotice: function (title, content) {
        var alertPopup = $ionicPopup.alert({
          title: '<h2 class="alert-title red-color no-margin-padding">' + title + '</h2>',
          template: '<p class="alert-notice">' + content + '</p>',
          okText: '确 认'
        });
        alertPopup.then(function (res) {
          //console.log('Thank you for not eating my delicious ice cream cone');
        });
      }
    }
  })

  .factory('Session', function () {
    return {
      set: function (key, data) {
        return window.sessionStorage.setItem(key, angular.toJson(data));
      },
      get: function (key) {
        return angular.fromJson(window.sessionStorage.getItem(key));
      },
      remove: function (key) {
        return window.sessionStorage.removeItem(key);
      },
      clear: function () {
        return window.sessionStorage.clear();
      },
      hasItem: function (item) {
        return window.sessionStorage.hasOwnProperty(item);
      }
    }
  })

  .factory('Local', function () {
    return {
      set: function (key, data) {
        return window.localStorage.setItem(key, angular.toJson(data));
      },
      get: function (key) {
        return angular.fromJson(window.localStorage.getItem(key));
      },
      remove: function (key) {
        return window.localStorage.removeItem(key);
      },
      clear: function () {
        return window.localStorage.clear();
      },
      hasItem: function (item) {
        return window.localStorage.hasOwnProperty(item);
      }
    }
  });
