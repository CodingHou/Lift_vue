<!DOCTYPE html>
<!--标签悬浮-->

[#list labelList as label]
    <input type="hidden" value="${label.labelId}">
    <span class="tag  [#if label.labelId!= labelId]NoChoose[/#if]">${label.labelName}</span>
[/#list]
