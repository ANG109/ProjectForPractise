var countdown = 5;
function setTime(obj,func){
	if(countdown==0){
		obj.bind("click",func);
		obj.text("发送验证码");
		countdown = 5;
		return;
	}else{
		obj.text("重新发送("+countdown+"s)");
		countdown--;
	}
	setTimeout(function(){
		setTime(obj,func);
	},1000);
	
}