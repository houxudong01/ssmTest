<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>用户详细详情</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>头像</th>
            <th>用户编号</th>
            <th>姓名</th>
            <th>昵称</th>
            <th>工作</th>
            <th>个性签名</th>
        </tr>
        <tr>
            <td><img src="http://localhost:8080/upload/${sessionScope.SESSION_USER.avatar}"></td>
            <td>${sessionScope.SESSION_USER.id}</td>
            <td>${sessionScope.SESSION_USER.userName}</td>
            <td>${sessionScope.SESSION_USER.nickname}</td>
            <td>${sessionScope.SESSION_USER.job}</td>
            <td>${sessionScope.SESSION_USER.description}</td>
        </tr>
    </table>
<a href="/blog/index.html">返回主页</a>
</body>
</html>
