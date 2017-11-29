<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>注册</title>
    <script src="/js/jquery-1.10.1.min.js" type="text/javascript"></script>
</head>
<body>


    <form action="/user/regist.html" method="post">
        用户名:<input id="name" type="text" name="userName" onblur="check('username')" value="${blogUser.userName}">
        <span id="msg"></span>
        ${error.getFieldError("userName").defaultMessage}<br>
        密码:<input id="pwd1" type="password" name="passWord"><br>
        确认密码:<input id="pwd2" type="password" name="repwd"><span id="msg2"></span><br>
        <input type="button" value="注册" onclick="check('btn')">
    </form>
    <script type="text/javascript">

        function check(obj){
            var pwd1 = $("#pwd1").val();
            var pwd2 = $("#pwd2").val();
            $.ajax({
                url:"/user/check.html",
                data:"userName="+$("#name").val(),
                success:function (data) {
                    $("#msg").html(data.msg)
                    if(data.status==true&&obj=='btn'){
                        if(pwd1!=pwd2){
                            $("#msg2").html('两次输入密码不一致')
                        }else{
                            $("form").submit();
                        }

                    }
                }
            });
        }
    </script>
</body>
</html>
