//6/19日做一个前端注册表格限制器
function change(img){
	img.src = "getCode?"+new Date().getTime();
}
var flag = true;//写一个标记位，来判断是否都符合验证的规则
function Fous(obj){
	$(obj).next('span').html('').removeClass('error');
}
function check(obj){
	var msgBox = $(obj).next('span');
	switch($(obj).attr('name')){
	case "userName":
		if(obj.value==""){
			msgBox.html('账号不能为空');
			msgBox.addClass('error');
			flag = false;
		}else{
			var url ="userNamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();//ajax验证账号主键是否冲突，加上日期是防止刷新不更换
			$.get(url,function(data){
				if(data =="false"){
					msgBox.html('账号已被占用，换一个');
					msgBox.addClass('error');
					flag = false;
				}else{
					flag = true;
					msgBox.html().removeClass('error');
				}
			});
		}
		break;
	case "name":
		if(obj.value==""){
		msgBox.html('昵称不能为空');
		msgBox.addClass('error');
		flag = false;
		}else{
		flag = true;
		msgBox.html().removeClass('error');
		}
		break;
	
	case "repassword":
		if(obj.value==""){
		msgBox.html('确认密码不能为空');
		msgBox.addClass('error');
		flag = false;
		}else if($(obj).val()!=$('input[name="password"]').val()){
		msgBox.html('与上面密码不符');
		msgBox.addClass('error');
		flag = false;
		}else{
			flag = true;
			msgBox.html().removeClass('error');
		}
		break;
	case "verycode":
		if(obj.value==""){
		flag = false;
		alert('验证码没输入哦');
		}else{//与上面得判断账号唯一是一样的操作，这个是判断验证码是否输入正确
			var url ="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
			$.get(url,function(numdata){
				if(numdata=='false'){
					flag = false;
					alert('验证码没有写对哦');
				}else{
					flag = true;
				}
			});
		}
		break;
	}
}
function checkForm(fim){
	var els = fim.getElementsByTagName('input');
	for(var i=0; i<els.length; i++){
		if(els[i] != null){
			if(els[i].getAttribute("onblur")){
				check(els[i]);
			}
		}
	}
	return flag;
}