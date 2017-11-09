<!DOCTYPE html>
<!--标签悬浮-->

[#list labelList as label]
    <input type="hidden" value="${label.labelId}">
    <span class="tag NoChoose">${label.labelName}</span>
[/#list]
