<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div id="say">
    <div class="weizi">
        <div class="wz_text">当前位置：<a href="/index.jsp">首页</a>><h1>碎言碎语</h1></div>
    </div>
    <c:forEach items="${page.list}" var="shuo">
        <ul class="say_box">
            <div class="sy">
                <p>${shuo.content}</p>
            </div>
            <span class="dateview"><fmt:formatDate value="${shuo.createdDate}" pattern="yyyy-MM-dd"/></span>
        </ul>
    </c:forEach>
    总页数:${page.pages} 当前页码:${page.pageNum} 总条数:${page.total}
    <a href="/shuo/list.html?userId=6&pageNo=${page.prePage}">上一页</a>
    <c:forEach begin="${page.navigateFirstPage}" end="${page.navigateLastPage}" var="pn">
        <a href="/shuo/list.html?userId=6&pageNo=${pn}">${pn}</a>
    </c:forEach>
    <a href="/shuo/list.html?userId=6&pageNo=${page.nextPage}">下一页</a>
    <input type="number" id="jump" style="width: 50px"><input type="button" onclick="go()" value="跳转">
</div>
<jsp:include page="/common/footer.jsp"/>
<script type="text/javascript">
    function go() {
        var num = document.getElementById("jump").value;
        window.location.href="/shuo/list.html?userId=6&pageNo="+num;
    }
</script>
</body>
</html>
