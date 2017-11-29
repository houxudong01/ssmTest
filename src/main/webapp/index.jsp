<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>${sessionScope.SESSION_USER.userName}的博客</title>
</head>
<body>
<jsp:include page="/common/header.jsp"/>

<!--content start-->
<div id="content">
    <!--left-->
    <div class="left" id="c_left">
        <div class="s_tuijian">
            <h2>文章<span>推荐</span></h2>
        </div>
        <div class="content_text">
            <c:forEach items="${page.list}" var="blog">
                <div class="wz">
                    <h3><a href="blog_1.jsp">${blog.title}</a></h3>
                    <dl>
                        <dt><img src="/upload/${blog.picture}" width="200"  height="123" alt=""></dt>
                        <dd>
                            <p class="dd_text_1">${blog.content}</p>
                            <p class="dd_text_2">
                                <span class="left author">${blog.user.userName}</span><span class="left sj">时间:<fmt:formatDate value="${blog.createdDate}" pattern="yyyy-MM-dd"/></span>
                                <span class="left fl">分类:<a href="#" title="学无止境">${blog.type}</a></span><span class="left yd"><a href="#" title="阅读全文">阅读全文</a>
               </span>
                            <div class="clear"></div>
                        </dd>
                        <div class="clear"></div>
                    </dl>
                </div>
            </c:forEach>
            总页数:${page.pages}
            当前页码:${page.pageNum}
            共有${page.total}条博客
            <a href="/blog/index.html?pageNo=${page.prePage}">上一页</a>
            <a href="/blog/index.html?pageNo=${page.nextPage}">下一页</a>
        </div>
    </div>
    <!--left end-->
<jsp:include page="/common/right.jsp"/>

    <div class="clear"></div>
    <div class="clear"></div>
</div>
<jsp:include page="/common/footer.jsp"/>
<!--footer end-->

</body>
</html>
