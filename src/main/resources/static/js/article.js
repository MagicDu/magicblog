$('#save').click(function(){
    var content= testEditor.getMarkdown();
    var title=$("#title").val();
    if(title==null||title.trim()==""){
        mdui.alert("请输入文章标题")
    }else if(content==null||content.trim()=="")
    {
        mdui.alert("请输入文章内容")
    }else{
        $.ajax({
            type:'POST',
            url:'/articles/savearticle',
            data:{
                "articletitle":$('#title').val(),
                "articlecontent":testEditor.getMarkdown(),

            },
            success : function(data) {
                mdui.alert(data.value)
            },
            error : function() {
                mdui.alert("server error")
            }
        })
    }

});
