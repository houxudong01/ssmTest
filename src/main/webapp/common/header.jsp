<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/index.css"/>
<link rel="stylesheet" href="/css/style.css"/>
<div id="header">
    <h1>个人博客</h1>
    ${sessionScope.SESSION_USER.userName}，欢迎您！
    <a href="/regist.jsp">用户注册</a>
    <a href="/login.jsp">用户登录</a>
    <a href="/blog/add.jsp">发表博客</a>
    <a href="/user/go_update.html">用户信息修改</a>
    <a href="/shuo/add.jsp">发表说说</a>
    <a href="/diary/add.jsp">写日记</a>
    <a href="/shuo/list.html">查看说说</a>
    <a href="/diary/list.html">查看日记</a>
    <a href="/user/loginout.html">退出登录</a>
</div>