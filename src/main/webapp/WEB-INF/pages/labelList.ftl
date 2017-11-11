<!DOCTYPE html>
<!--标签悬浮-->
<script>
//$(function(){
//    var labelList = $(".singleLabelId");
//    for(var i=0;i<labelList.length;i++) {
//        var labelId = labelList[i].val();
//        labelList[i].parent().find("span:contains(" + labelId + ")").addClass("labelChoose");
//    }
//})
document.onreadystatechange = loadingChange;//当页面加载状态改变的时候执行这个方法.
function loadingChange()
{
    if(document.readyState == "complete"){ //当页面加载状态为完全结束时进入
        var labelList = $(".singleLabelId");
        for(var i=0;i<labelList.length;i++) {
            var labelId = labelList[i].val();
            labelList[i].parent().find("span:contains(" + labelId + ")").addClass("labelChoose");
        }
    }
}

</script>
[#--<div class="innerTag">--]
<input type="hidden" class="singleLabelId" value="${labelId}">
[#list labelList as label]
    <input type="hidden" value="${label.labelId}">
    <span class="tag  ">${label.labelName}</span>
[/#list]
[#--</div>--]
