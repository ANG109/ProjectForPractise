/**
 * 
 * 公用js
 * @date 2010-1-7
 */

/**
 * 递归删除子dom对象
 */
function removeChildrenFromNode(e) {
	if (!e) {
		return false;
	}
	while (e.hasChildNodes()) {
		e.removeChild(e.firstChild);
	}
	return true;
}
/**
 * 获取字符串长度，汉字算两位
 */
function getStringLength(Obj){
  var nCNLenth = 0;
  var nLenth = Obj.length;
  for (var i=0; i<nLenth; i++){
    if(Obj.charCodeAt(i)>255){
      nCNLenth += 2; 
    }else{
      nCNLenth++;
    }
  }
  return nCNLenth;
}
/**
 * 全文替换 replaceAll('p_asdasd','p_', 's+');==s+asdasd
 * 
 * @param string
 *            要操作的字符串
 * @param oldStr
 *            替换掉的字符串
 * @param newStr
 *            替换成的字符串
 * @return
 */
function replaceAll(string,oldStr,newStr){
	return string.replace(new RegExp(oldStr,"gm"),newStr);
}
/**
 * 使控件不可用和恢复可用 格式：$("#id").disable()
 */
(function($){
	$.fn.disable=function() {
		return $(this).find("*").each(function() {
			return $(this).attr("disabled", "disabled");
		});
	},
	$.fn.enable=function() {
		return $(this).find("*").each(function() {
			return $(this).removeAttr("disabled");
		});
	}
})(jQuery);

//抖动效果
jQuery.fn.shake = function(intShakes,intDistance, intDuration) {
    this.each(function() {
        var jqNode = $(this);
        jqNode.css({position: 'relative'});
        for (var x=1; x<=intShakes; x++) {
            jqNode.animate({ left: (intDistance * -1) },(((intDuration / intShakes) / 4)))
            .animate({ left: intDistance },((intDuration/intShakes)/2))
            .animate({ left: 0 },(((intDuration/intShakes)/4)));
        }
    });
    return this;
}

/**
 * 去前后空格
 * 
 * 使用： " asd".trim();=="asd"
 * 
 * @return
 */
String.prototype.trim =  function(){
	return this.replace((/(^\s*)|(\s*$)/g),"");
}

/**
 * 字符串替换 使用：“asd”.replaceAll('a','1');=='1sd'
 * 
 * @param string
 *            源字符串
 * @param oldStr
 *            要处理的字符串
 * @param newStr
 *            处理成字符串
 * @return
 */
String.prototype.replaceAll = function(oldStr,newStr){
	return this.replace(new RegExp(oldStr,"gm"),newStr);
}

/**
 * date1大于date2 ，返回true
 */
function compareDate(date1,date2){
	if(!(date1 instanceof Date)){
		date1= new Date(Date.parse(date1.replace(/-/g,   "/")))
	}
	if(!(date2 instanceof Date)){
		date2= new Date(Date.parse(date2.replace(/-/g,   "/")))
	}
	return date1>date2
}


/**
 * 
 * @param parentCheckId		全选复选框的id
 * @param childCheckName	子复选框的name
 * @return
 */
function doAllCheck(parentCheckId,childCheckName){
	$("#"+parentCheckId).click(function(){
		$("input[name='"+childCheckName+"']").each(function(){
			this.checked=$("#"+parentCheckId)[0].checked;
		});
	});
	$("input[name='"+childCheckName+"']").click(function(){
		var flag=true;
		if(this.checked){
			$("input[name='"+childCheckName+"']").each(function(){
				if(!this.checked){
					flag=false;
					return false;
				}
			});
			$("#"+parentCheckId)[0].checked=flag;
		}else{
			$("#"+parentCheckId)[0].checked=false;
		}
	});
}

