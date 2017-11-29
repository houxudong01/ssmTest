<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>发表博客</title>
</head>
<body>
<link href="/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script src="/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" charset="utf-8" src="/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/kindeditor-4.1.10/lang/zh_CN.js"></script>
    <form action="/blog/add.html" method="post">
        <input type="hidden" name="user.id" value="${sessionScope.SESSION_USER.id}">
        博客分类:<input type="type" name="type"><br/>
        标题:<input type="type" name="title" placeholder="标题不能为空"><br/>
        内容:
        <textarea style="width:800px;height:300px;visibility:hidden;" name="content"
                  id="editor"></textarea><br/>
        <input type="submit" value="发表">
        <input type="hidden" name="picture" id="pic">
    </form>
<input type="file" name="file" id="file"/>
<input type="button" value="插入图片" onclick="upload()"/>
<div><img id="imgBox" src=""/> </div>
</body>
<script type="text/javascript">
    var kingEditorParams = {
        filePostName: "file",//指定上传文件参数名称
        uploadJson: '/blog/add.html',//指定上传文件请求的url。
        dir: "image"//上传类型，分别为image、flash、media、file
    }
    var editor;
    $(function () {
        editor = KindEditor.create($("#editor"), kingEditorParams);
    })
</script>
<script type="text/javascript">
    function upload(){
        var formdata=new FormData( );
        if(!$("#file").val()){
            return;
        }
        formdata.append("key1","efg");
        formdata.append("file" , $("#file")[0].files[0]);//获取文件法
        $.ajax({
            url: '/up/upload.html',
            type: 'POST',
            data: formdata,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (json) {
                $("#imgBox").attr("src", "http://localhost:8080/upload/" + json);
                $("#pic").val(json);
            }
        });
    }

</script>
</html>
