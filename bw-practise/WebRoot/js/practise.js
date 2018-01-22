/**
 * Created by wangfang on 2017/8/2.
 */
/*理解JSON数据格式*/
var dog={"adv":[{"firstOne":"littleK","secondOne":"littelJ"},
                {"third":"littleO"}],
         "adx":[{"fouthOne":"littleA"},
                {"fifth":"littleF"}]}
dogfunction();
function dogfunction(){
      var firstDog = dog[0];
      alert(firstDog);
//将数据转成对象数组
      var dogs = eval("dog");
      var val = dogs.adv[0].firstOne;
      alert(val);
}
var jsonTwo = {"name":"ang",
               "age":"22",
               "subject":[{"math":"advanceMath","physical":"formal"},
                          {"pe":"wer"},
                          {"English":"advance"}]}
alert(jsonTwo);
//如果没有特殊情况，可以用JSON数据，性能和文件大小方面有优势，当远程应用未知时，用XML文档为首选
//天气预报案例,DNS域名服务器（）
// qq用户查询方式：管理地区用户服务器，查询本地的账号，将本人的状态上传到本地的服务区，本地的服务器再过一段时间像中心服务器发送状态。
function provinceChange(){
    $.ajax({
        url:"findCities.do?province="+$("#provinceID").val,
        method:post,
        async:true,
        success:function(data){
            $("cityID").append(data);
        }
    })
}
//黄金市场报价
