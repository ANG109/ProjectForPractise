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
