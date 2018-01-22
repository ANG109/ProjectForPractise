var rex = /^13\d{9}$|^15\d{9}$|^18\d{9}$|^17\d{9}$|^14\d{9}$/;
function setErrorMsg(obj,msg){
	obj.parents(".form-group").removeClass("has-success");
	obj.parents(".form-group").addClass("has-error");
	obj.parent().siblings("small[data-error='custom-error']").html(msg).show().css({"color":"#a94442"});
}