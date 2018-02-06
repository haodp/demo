var working = false;
$('.login').on('submit', function(e) {
    e.preventDefault();
    if (working) return;
    working = true;
    var $this = $(this),
    $state = $this.find('button > .state');
    $this.addClass('loading');
    $state.html('验证...');
    setTimeout(function() {
        $this.addClass('ok');
        $state.html('欢迎回来!');
        setTimeout(function() {
            $state.html('登录');
            $this.removeClass('ok loading');
            working = false;
        }, 4000);
    },3000);
});
