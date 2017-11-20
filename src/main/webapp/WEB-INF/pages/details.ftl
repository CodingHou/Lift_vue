<!DOCTYPE html>
<!--内容-->
<form action="/${base}/taskDetail/insertTaskDetail.action" id="detailForm">
    <div id="item-box">
        <div class="item" id="item">

            <input type="hidden" id="taskId" value="${task.taskId}">

            <div class="header">
                <div class="stateBar">
                    <!--紧急程度-->
                    <div class="grade grade${task.gradeId}">
                    </div>
                [#if !isDel]
                    <!--修改-->
                    <img class="change" src="${base}/icon/change.png" alt="">
                [/#if]
                    <!--标签-->
                    <span class="tag theTag labelChoose">${task.labelName}</span>
                </div>
            </div>
            <h2>${task.taskName}</h2>
            <div id="toDoList">
            [#list detailList as item]
                <input type="hidden" class="detailId" value="${item.taskDetailId}">
                <div class="items">
                [#--<input type="hidden"  class="detailId" value="${item.id}">--]
                [#--${item.taskDetailId}--]
                    <input type="checkbox" [#if item.dataState==2]checked="checked"[/#if]/>
                    <div class="checkBox [#if item.dataState==2] c [/#if]"></div>
                    <span class="[#if item.dataState==2]spanChecked[/#if]">${item.taskDetailName}</span>
                </div>
                <div class="itemInput">
                ${item.taskDetailId}
                    <div class="checkBox [#if item.dataState==2] c [/#if]"></div>
                    <input class="changeInput" type="text" value="${item.taskDetailName}">
                    <img class="changeDel" src="${base}/icon/del.png" alt="">
                    <!--<img class="changeAdd" src="${base}/icon/changeAdd.png" alt="">-->
                </div>
            [/#list]

            </div>
        [#if !isDel]
            <!--添加新项目-->
            <div class="add" id="newItem">
                <img src="${base}/icon/add.png" alt="">
            </div>
            <div class="changeOk" id="changeOk">
                <img src="${base}/icon/changeOk.png" alt="">
            </div>
        [/#if]
        </div>
    </div>
</form>