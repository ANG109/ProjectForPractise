 //dataTime
$("#datetimeStart").datetimepicker({
    format: 'yyyy-mm-dd',
    minView:'month',
    language: 'zh-CN',
    autoclose:true,
    startDate:4
}).on("click",function(){
    $("#datetimeStart").datetimepicker("setEndDate",$("#datetimeEnd").val())
});
 
$("#datetimeEnd").datetimepicker({
    format: 'yyyy-mm-dd',
    minView:'month',
    language: 'zh-CN',
    autoclose:true,
    startDate:4
}).on("click",function(){
    $("#datetimeEnd").datetimepicker("setStartDate",$("#datetimeStart".val()))
});
