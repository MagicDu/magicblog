/* my script */

//初始几个对话框
inst = new mdui.Dialog("#edit_bookmarks_dialog"); //编辑书签对话框
login_dialog=new mdui.Dialog("#user_login_dialog");//用户登录对话框
regist_dialog=new mdui.Dialog('#user_regist_dialog');//注册对话框
addbookmrak_dialog=new mdui.Dialog('#add_bookmarks_dialog');//添加书签对话框
navbar=new mdui.Drawer('#drawer')

var selector={
	
}
var options={
	
	
}

$(function(){
	if(localStorage.getItem('*-@5679sdf')!=null){
		//divDisplay('#menubarwithlogin','display:none');
		init();
	}
	else{
		//divDisplay('#menubarwithbookmark','display:none');
		$('#menubarwithbookmark').hide();
        /*$('a').each(function(){
             $(this).attr('onclick',"return aClick(this);");
        });*/

	}
})

function aClick(a){
	$("#container").innerHTML("<div th:replace="+a.href+"></div>")
    $(".mdui-collapse-item-open").removeClass("mdui-collapse-item-open");
    $(".mdui-list-item-active").removeClass("mdui-list-item-active");
    console.log(a.parent().parent());
	a.parent().parent().addClass("mdui-collapse-item-open");
	a.addClass("mdui-list-item-active");
	return false;
}

/**
 * 设置某个元素的css属性
 * @param id
 * @param css_str
 * @returns
 */
function divDisplay(id,css_str){
	$(id).css(css_str);
}

function init(){
					$('#menubarwithlogin').hide();
					$('#menubarwithbookmark').show();
					$.ajax({
								type : 'POST',
								url : '../bookmarks/selectBookmarks',
								data : {
									"user_id" : 'test'
								},
								headers:{
									"Authorization":localStorage.getItem("authtoken")
								},
								dataType : 'json',
								success : function(data) {
									// alert(data);
									$.each(data.value,function(i, item) {
														// console.log(item.url);

														$('#bookmarks_list')
																.append(
																		"<div class=\"mdui-chip\"><a class=\"mdui-chip-title mdui-btn\" href="
																				+ item.url
																				+ ">"
																				+ item.name
																				+ "</a> <span id="
																				+ item.id
																				+ " class=\"mdui-chip-delete\"><i class=\"mdui-icon material-icons\">edit</i></span></div>");

													})
								},
								error : function(data) {
									mdui.alert("服务器错误");
								}

							});
}

				

/*$(document).ready(function(){
	$
	.ajax({
		type : 'POST',
		url : '../selectBookmarks.action',
		data : {
			"user_id" : 'test'
		},
		dataType : 'json',
		success : function(data) {
			// alert(data);
			$
					.each(
							data,
							function(i, item) {
								// console.log(item.url);

								$('#bookmarks_list')
										.append(
												"<div class=\"mdui-chip\"><a class=\"mdui-chip-title mdui-btn\" href="
														+ item.url
														+ ">"
														+ item.name
														+ "</a> <span id="
														+ item.id
														+ " class=\"mdui-chip-delete\"><i class=\"mdui-icon material-icons\">edit</i></span></div>");

							})
		},
		error : function(data) {
			alert(data);
		}

	});
})*/
//管理员登录
$('#admin_login_btn').click(function() {
	$.ajax({
		type : 'POST',
		url : '../../adminLogin.action',
		data : {
			"name" : $('#name').val(),
			"password" : $('#password').val()
		},
		dataType : 'json',
		success : function(data) {
			alert(data.name);
		},
		error : function() {
			alert("用户名或密码错误");
		}
	});
});

/**
 * 用户注册开始
 */ 
$('#user_regist_btn_dialog').click(function(){
	regist_dialog.open();
})
$("#regist_btn").click(function() {
	$.ajax({
		type : 'POST',
		url : '/register',
		data : {
			"username" : $('#username').val(),
			"useremail" : $('#email').val(),
			"password" : $('#password').val()
		},
		dataType : 'json',
		success : function(data) {
			// 处理对话框
            regist_dialog.close();
			$('#username').val("");
            $('#email').val("");
            $('#password').val("");
            $('#password1').val("");
			if(data.key=="ERROR"){

			}

			mdui.alert('注册成功,请查收激活邮件');
		},
		error : function() {
			// 处理错误
			regist_dialog.close();
			mdui.alert('注册失败');
			// window.location.href='login.html';
		}
	});
})
//--用户注册结束


/**
 * 用户登录 开始
 */
$('#user_login_btn_dialog').click(function() {
	login_dialog.open();
});
$('#login_btn').click(function(){
	$.ajax({
		type : 'POST',
		url : '/login',
		data : {
			"username" : $('#login_username').val(),
			"password" : $('#login_password').val()
		},
		dataType : 'json',
		success : function(data) {
			login_dialog.close();
			$('#login_username').val("");
			$('#login_password').val("");
			if(data.key=="ERROR"){
				mdui.alert("用户名或者密码错误");
			}else{
                mdui.alert("登录成功");
                localStorage.setItem("authtoken",data.value);
                init();
			}
		},
		error : function() {
			login_dialog.close();
			$('#login_username').val("");
			$('#login_password').val("");
			mdui.alert("用户名或密码错误");
			
		}
	});
})
//-- 用户登录结束


/**
 * 添加书签
 */ 
$('#add_bookmark').click(function(){
	addbookmrak_dialog.open();
})


$('#add_bookmark_btn').click(function() {
	if ($('#state').prop('checked')) {
		state = 1;
	} else {
		state = 0;
	}
	$.ajax({
		type : 'POST',
		headers:{
		"Authorization":localStorage.getItem("authtoken")
		},
		url : '../bookmarks/addBookmark',
		data : {
			"name" : $('#name').val(),
			"url" : $('#url').val(),
			"description" : $('#description').val(),
			"state" : state
		},
		dataType : 'json',
		success : function(data) {
			mdui.alert('添加成功');
			//alert(data.key);
		},
		error : function(data) {
			mdui.alert('添加失败');
			//alert(data.msg);
		}
	})
})


$('#selectBookmarks')
		.click(
				function() {
					$
							.ajax({
								type : 'POST',
								url : '../../selectBookmarks.action',
								data : {
									"user_id" : 'test'
								},
								dataType : 'json',
								success : function(data) {
									// alert(data);
									$
											.each(
													data,
													function(i, item) {
														// console.log(item.url);

														$('#bookmarks_list')
																.append(
																		"<div class=\"mdui-chip\"><a class=\"mdui-chip-title mdui-btn\" href="
																				+ item.url
																				+ ">"
																				+ item.name
																				+ "</a> <span id="
																				+ item.id
																				+ " class=\"mdui-chip-delete\"><i class=\"mdui-icon material-icons\">edit</i></span></div>");

													})
								},
								error : function(data) {
									alert(data);
								}

							});
				})

$('#selectBookmarksVo').click(function() {
	$.ajax({
		type : 'POST',
		url : '../../selectBookmarksVo.action',
		data : {
			"user_id" : 'test'
		},
		dataType : 'json',
		success : function(data) {
			// alert(data);
			$.each(data, function(i, item) {
				// console.log(item.url);
				// console.log(item.category.name);
				// $('#test').append("<a
				// href="+item.url+">"+item.name+"</a></br>");

			})
		},
		error : function(data) {
			alert(data);
		}

	});
})


// 修改书签
$('#bookmarks_list').on('click','span',(function(e) {
	$.ajax({
		type : 'POST',
		url : '../selectBookmarksById.action',
		data : {
			"id" :$(e.currentTarget)[0].id
		},
		dataType : 'json',
		success : function(data) {
			  $('#b_id').val($(e.currentTarget)[0].id)
			  $('#b_name').val(data.name); 
			  $('#b_url').val(data.url);
			  $('#b_description').val(data.description);
			 // alert( $('#state').prop('checked'))
			  if(data.state==1){
				  $('#b_state').prop('checked',true)
			  }
			  //var inst = new mdui.Dialog("#edit_bookmarks_dialog");
			 // console.log(inst.$dialog[0]); 
			  inst.open();
			  
			 
		},
		error : function(data) {
			//console.log($(e.currentTarget)[0].id)
			mdui.alert('服务器错误')
		}
	});

}))


$('#edit_bookmarks_btn').click(function(e) {
	
	//mdui.alert("修改成功");
	if ($('#b_state').prop('checked')) {
		state = 1;
	} else {
		state = 0;
	}
	$.ajax({
		type:'POST',
		url:'../updateBookmarksById.action',
		data:{
			"id":$('#b_id').val(),
			"name":$('#b_name').val(),
			"url":$('#b_url').val(),
			"description":$('#b_description').val(),
			"state":state
		},
		success:function(data){
			inst.close();
			mdui.alert('修改成功',function(){
				$('#bookmarks_list').html('');
				init();
			});
			
		},
		error:function(){
			mdui.alert('服务器错误')
		}
	});
	
});

$('#test').click(function (){
	$.ajax({
		type:'POST',
		url:'../menu/getMenus',
        headers:{
            "Authorization":localStorage.getItem("authtoken")
        },
		data : {

		},
		success:function(data){
			//mdui.alert(data.resultMap['test,计算机'][0].userid)
			//parseDataToView(data);
			console.log(data);
		},
		error:function(){
			mdui.alert('服务器错误')
		}
	});
});

// 解析数据到页面上
function parseDataToView(data){
	var resultMap=data.resultMap;
	for(var prop in resultMap){
		//mdui.alert(resultMap[prop][0].userid)
		var category=prop.split(',')[1];
		var categoryid=prop.split(',')[0];
		var bmList=resultMap[prop]
		//mdui.alert(category)
		for(var i=0;i<bmList.length;i++){
			//mdui.alert(bmList[i].url)
			$('#bookmarks_list')
			.append(
					"<div class=\"mdui-chip\"><a class=\"mdui-chip-title mdui-btn\" href="
							+ bmList[i].url
							+ ">"
							+ bmList[i].name
							+ "</a> <span id="
							+ bmList[i].id
							+ " class=\"mdui-chip-delete\"><i class=\"mdui-icon material-icons\">edit</i></span></div>");
			
		}
	}
}



$('#edit_bookmarks_btn1').click(function() {
	alert("名字:"+$('#name').val())
})

$('#test_btn').click(function() {
	window.location.href = 'http://www.baidu.com';
})

/*$('#edit').click(function () {
	$.ajax({
		type:'POST',
		url:"/articles/edit/",
        data : {
            "user_id" : 'test'
        },
        success:function(data){
			console.log(data)
        },
        error:function(){
            mdui.alert('服务器错误')
        }
	});
});*/
