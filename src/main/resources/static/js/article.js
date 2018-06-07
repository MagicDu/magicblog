$('#save').click(function(){
    $.ajax({
        type:'POST',
        url:'/savearticle',
        data:{
            "title":$('#title').val(),
            "content":testEditor.getMarkdown()
    },
        success : function(data) {

        },
        error : function() {

        }
    })
});