$('#save').click(function(){
    $.ajax({
        type:'POST',
        url:'/articles/savearticle',
        data:{
            "title":$('#title').val(),
            "content":testEditor.getMarkdown()
    },
        success : function(data) {
           mdui.alert(data.value)
        },
        error : function() {
            mdui.alert("server error")
        }
    })
});