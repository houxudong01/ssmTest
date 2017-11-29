<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div id="content">
<div class="left" id="riji">
    <div class="weizi">
        <div class="wz_text">当前位置：<a href="/index.jsp">首页</a>><h1>个人日记</h1></div>
    </div>
    <div class="rj_content">
        <c:forEach items="${page.list}" var="diary">
            <div class="shiguang animated bounceIn">
                <div class="left sg_ico">
                    <img src="/images/my_1.jpg" width="120" height="120" alt=""/>
                </div>
                <div class="right sg_text">
                    <img src="/images/left.png" width="13" height="16" alt="左图标"/>
                        ${diary.content}
                </div>
                <div class="clear"></div>
            </div>
        </c:forEach>
    总页数:${page.pages}当前页码:${page.pageNum}总条数:${page.total}
        <a href="/diary/list.html?userId=1&pageNo=${page.prePage}">上一页</a>
            <c:forEach begin="${page.firstPage}" end="${page.lastPage}">

            </c:forEach>
        <a href="/diary/list.html?userId=1&pageNo=${page.nextPage}">下一页</a>
    </div>
</div>
    <jsp:include page="/common/right.jsp"/>

<div class="clear"></div>
</div>
<jsp:include page="/common/footer.jsp"/>
<!--footer end-->
</div>
</body>
</html>
