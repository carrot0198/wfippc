$(document).ready(function(){
	$("button").click(function(){
		//alert($("#userid").val());
		var userid = $("input[name='userid']").val();
        var password = $("input[name='password']").val();
        if (userid == "" || password == "") {
            layer.msg('用户名或密码不能为空', {icon: 2});
            return;
        }
        $.ajax({
            type: "POST",
            url: "/login",
            data: {
                "userid": username,
                "password": password
            },
            success: function (e) {
                layer.msg(e.msg, {icon: 1});
                setTimeout(function () {
                    location.href = 'success.html';
                }, 1500);
            },
            error: function (e) {
                console.log(e.responseText);
                layer.msg(JSON.parse(e.responseText).msg, {icon: 2});
            }
        });
	});
});
