(function (A){
	A.BW = {
		dynamicIframe : function(tagId,URL,params){
			var _iframe = document.getElementById(tagId);
			_iframe.src =URL;
			$("#loading").show();
			if (_iframe.attachEvent){
			    _iframe.attachEvent("onreadystatechange", function(){
			    	var state = _iframe.readyState;
		            if (state == "complete") {
		            	$("#loading").fadeOut();
			         }
			    });
			} else {
				_iframe.onload = function(){
					$("#loading").fadeOut();
				}
			}
		},
		
		/**
		 * IE 6 7浏览器时提示浏览器版本过低
		*/
		versionLow : function(){
			var a = this.browser();
			var d = {};
			if (a.browser) {
				d[a.browser] = true;
				d.version = a.version
			}
			if (d.msie && (d.version == "6.0" || d.version == "7.0")) {
				return true;
			}
			return false;
		},
		
		browser : function(){
			var agent = navigator.userAgent.toLowerCase();
			var e = /(chrome)[ \/]([\w.]+)/.exec(agent)
					|| /(webkit)[ \/]([\w.]+)/.exec(agent)
					|| /(opera)(?:.*version|)[ \/]([\w.]+)/.exec(agent)
					|| /(msie) ([\w.]+)/.exec(agent) || agent.indexOf("compatible") < 0
					&& /(mozilla)(?:.*? rv:([\w.]+)|)/.exec(agent) || [];
			return {
				browser : e[1] || "",
				version : e[2] || "0"
			}
		},
		
		showId : function(idname){
			var isIE = (document.all) ? true : false;
			var isIE6 = isIE && ([/MSIE (\d)\.0/i.exec(navigator.userAgent)][0][1] == 6);
			var newbox = document.getElementById(idname);
			newbox.style.zIndex = "9999";
			newbox.style.display = "block"
			newbox.style.position = !isIE6 ? "fixed" : "absolute";
			newbox.style.top = 0;
			newbox.style.left = "50%";
			newbox.style.marginTop = 0;
			newbox.style.marginLeft = -newbox.offsetWidth / 2 + "px";
			var layer = document.createElement("div");
			layer.id = "layer";
			layer.style.width = layer.style.height = "100%";
			layer.style.position = !isIE6 ? "fixed" : "absolute";
			layer.style.top = layer.style.left = 0;
			layer.style.backgroundColor = "#000";
			layer.style.zIndex = "9998";
			layer.style.opacity = "0.8";
			document.body.appendChild(layer);
		
			function layer_iestyle(){
				layer.style.width = Math.max(document.documentElement.scrollWidth, document.documentElement.clientWidth) +
				"px";
				layer.style.height = Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight) +
				"px";
			}
			function newbox_iestyle(){
				newbox.style.marginTop = 0;
				newbox.style.marginLeft = document.documentElement.scrollLeft - newbox.offsetWidth / 2 + "px";
			}
			if (isIE) {
				layer.style.filter = "alpha(opacity=80)";
			}
			if (isIE6) {
				layer_iestyle()
				newbox_iestyle();
				window.attachEvent("onscroll", function(){
					newbox_iestyle();
				})
				window.attachEvent("onresize", layer_iestyle)
			}
		},
		
		closeId : function(id){
			if(id instanceof Array){
				for(i=0;i<id.length;i++){
					$("#"+id[i]).hide();
				}
			}else{
				$("#"+id).hide();
			}
			$('div#layer').remove();
		}
	};
	
	/**
	 * 在Date原型上增加format方法
	*/
	Date.prototype.format = function(format) {
	    /*
	     * eg:format="yyyy-MM-dd hh:mm:ss";
	     */
	    var o = {
	        "M+" :this.getMonth() + 1, // month
	        "d+" :this.getDate(), // day
	        "h+" :this.getHours(), // hour
	        "m+" :this.getMinutes(), // minute
	        "s+" :this.getSeconds(), // second
	        "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter
	        "S" :this.getMilliseconds() // millisecond
	    }
	    if (/(y+)/.test(format)) {
	        format = format.replace(RegExp.$1, (this.getFullYear() + "")
	                .substr(4 - RegExp.$1.length));
	    }
	    for ( var k in o) {
	        if (new RegExp("(" + k + ")").test(format)) {
	            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
	                    : ("00" + o[k]).substr(("" + o[k]).length));
	        }
	    }
	    return format;
	}
})(window);

