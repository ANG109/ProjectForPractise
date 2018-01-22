$("#back_pass_send").bootstrapValidator({
	 message: 'This value is not valid',
	 fields: {
        phone: {
           validators: {
               notEmpty: {
                   message: '手机号不能为空！'
               },
               regexp: {
               		regexp:rex,
               		message: '手机号格式错误！'
               }
           }
        },
        img_code:{
        	validators: {
               notEmpty: {
                   message: '图片验证码不能为空！'
               }
           }
        }
    }
});
		
function backPassSendCode(){
	var bootstrapValidator = $('#back_pass_send').data('bootstrapValidator');
	bootstrapValidator.validate();
	if(!bootstrapValidator.isValid()) return;
	jQuery.ajax({
		url:"smsCode.do",
		data:{"phone":$("#back_phone").val(),"type":3,"img_code":$("#back_img_code").val()},
		dataType:"json",
		success:function(data){
			if(data.result==1011){
				setErrorMsg($("#back_img_code"),data.msg);
			}
			if(data.result==1002||data.result==1008){
				setErrorMsg($("#back_phone"),data.msg);
			}
			if(data.result==1000){
				$("#send_back_invite_code").unbind("click");
				setTime($("#send_back_invite_code"),backPassSendCode);
				alert(data.msg);
			}
		}
	});
}
$("#send_back_invite_code").bind("click",backPassSendCode);
    
$("#back_pass").bootstrapValidator({
	 message: 'This value is not valid',
	 fields: {
        phone: {
           validators: {
               notEmpty: {
                   message: '手机号不能为空！'
               },
               regexp: {
               		regexp:rex,
               		message: '手机号格式错误！'
               }
           }
        },
        img_code:{
        	validators: {
               notEmpty: {
                   message: '图片验证码不能为空！'
               }
           }
        },
        sms_code:{
    		validators: {
    		 	notEmpty: {
                   message: '短信验证码不能为空！'
               	}
    		}
    	}
    }
});

$("#back_pass_step").click(function(){
	var bootstrapValidator = $('#back_pass').data('bootstrapValidator');
	bootstrapValidator.validate();
	if(!bootstrapValidator.isValid()) return;
	jQuery.ajax({
		url:"backPass.do",
		data:{"step":1,"phone":$("#back_phone").val(),"img_code":$("#back_img_code").val(),"sms_code":$("#back_sms_code").val()},
		dataType:"json",
		success:function(data){
			if(data.result==1002||data.result==1008){
				setErrorMsg($("#back_phone"),data.msg);
			}
			if(data.result==1011){
				setErrorMsg($("#back_img_code"),data.msg);
			}
			if(data.result==1005){
				setErrorMsg($("#back_sms_code"),data.msg);
			}
			if(data.result==1000){
				$('#back_pass').modal('hide');
				$("#back_pass_reset").modal();
			}else{
				alert(data.msg);
			}
		}
	});
});
		
$("#back_phone,#back_img_code,#back_sms_code").bind("blur focus",function(){
	$(this).parent().siblings("small[data-error='custom-error']").hide();
});


$("#back_pass_submit").click(function(){
	if($("#reset_pass").val()==null||$("#reset_pass").val()==''||$("#reset_pass").val().length<6||$("#reset_pass").val().length>12){
		alert("密码长度必须是6-12位");
		return;
	}
	if($("#reset_pass_confirm").val()==null||$("#reset_pass_confirm").val()==''){
		alert("重复密码不能空");
		return;
	}
	if($("#reset_pass_confirm").val()!=$("#reset_pass").val()){
		alert("两次密码不一致");
		return;
	}
	jQuery.ajax({
		url:"backPass.do",
		data:{"step":2,"new_pass":$("#reset_pass").val()},
		dataType:"json",
		success:function(data){
			alert(data.msg);
			if(data.result==1000){
				location.reload();
			}
		}
	});
});
    
    
    
$("#reg_invite_code_form").bootstrapValidator({
	 message: 'This value is not valid',
	 fields: {
        phone: {
           validators: {
               notEmpty: {
                   message: '手机号不能为空！'
               },
               regexp: {
               		regexp:rex,
               		message: '手机号格式错误！'
               }
           }
        }
    }
});

function sendCode(){
	var bootstrapValidator = $('#reg_invite_code_form').data('bootstrapValidator');
	bootstrapValidator.validate();
	if(!bootstrapValidator.isValid()) return;
	jQuery.ajax({
		url:"smsCode.do",
		data:{"phone":$("#reg_phone").val(),"type":1},
		dataType:"json",
		success:function(data){
			if(data.result!=1000){
				setErrorMsg($("#reg_phone"),data.msg);
			}else{
				$("#reg_invite_code").unbind("click");
				setTime($("#reg_invite_code"),sendCode);
				alert(data.msg);
			}
		}
	});
}
$("#reg_invite_code").bind("click",sendCode);

$("#register").bootstrapValidator({
	message: 'This value is not valid',
	/* feedbackIcons: {
	    valid: 'glyphicon glyphicon-ok',
	    invalid: 'glyphicon glyphicon-remove',
	    validating: 'glyphicon glyphicon-refresh'
	}, */
    fields: {
    	user_name:{
    		validators: {
    		 	notEmpty: {
                   message: '公司名称/姓名不能为空'
               	},
    		}
    	},
        phone: {
           validators: {
               notEmpty: {
                   message: '手机号不能为空！'
               },
               regexp: {
               		regexp:rex,
               		message: '手机号格式错误！'
               }
           }
        },
        code:{
    		validators: {
    		 	notEmpty: {
                   message: '验证码不能为空！'
               	},
               	stringLength: {
                    min: 6,
                    max: 6,
                    message: '验证码长度必须为6位！'
                }
    		}
    	}
    }
});

$("#reg_btn").click(function(){
	var bootstrapValidator = $('#register').data('bootstrapValidator');
	bootstrapValidator.validate();
	if(!bootstrapValidator.isValid()) return;
	jQuery.ajax({
		url:"reg.do",
		data:{"phone":$("#reg_phone").val(),"user_name":$("#user_name").val(),"code":$("#reg_code").val()},
		dataType:"json",
		success:function(data){
			if(data.result==1000){
				location.href="main.do";
			}
			if(data.result==1005){
				setErrorMsg($("#reg_code"),data.msg);
			}
			if(data.result==1007){
				setErrorMsg($("#reg_phone"),data.msg);
			}
		}
	});
});

$("#reg_code,#reg_phone,#login_phone,#login_password").bind("blur focus",function(){
	$(this).parent().siblings("small[data-error='custom-error']").hide();
});


$("#login_form").bootstrapValidator({
	message: 'This value is not valid',
    fields: {
        phone: {
           validators: {
               notEmpty: {
                   message: '手机号不能为空！'
               },
               regexp: {
               		regexp:rex,
               		message: '手机号格式错误！'
               }
           }
        },
        password:{
    		validators: {
    		 	notEmpty: {
                   message: '密码不能为空！'
               	}
    		}
    	}
    }
});

$("#login_btn").click(function(){
	var bootstrapValidator = $('#login_form').data('bootstrapValidator');
	bootstrapValidator.validate();
	if(!bootstrapValidator.isValid()) return;
	jQuery.ajax({
		type:"POST",
		url:"login.do",
		data:{"phone":$("#login_phone").val(),"password":$("#login_password").val()},
		dataType:"json",
		success:function(data){
			if(data.result==1000){
				location.href="main.do";
			}else if(data.result==1001){
				setErrorMsg($("#login_password"),data.msg);
			}else{
				setErrorMsg($("#login_phone"),data.msg);
			}
		}
	});
});