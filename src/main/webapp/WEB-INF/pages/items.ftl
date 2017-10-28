<form action="/taskDetail/insertTaskDetail.action" id="detailForm">
    <div id="item-box">
        <div class="item" id="item">

            <input type="hidden" id="taskId" value="${task.id}">

            <div class="header">
                <div class="stateBar">
                    <!--紧急程度-->
                    <div class="grade">
                    </div>
                    <!--修改-->
                    <img class="change" src="/icon/change.png" alt="">
                    <!--标签-->
                    <span class="tag theTag">0</span>
                </div>
            </div>
            <h2>${task.name}</h2>
            <div id="toDoList">
            [#list detailList as item]
                <div class="items">
                    <input type="hidden"  class="detailId" value="${item.id}">
                ${item.id}
                    <input type="checkbox" [#if item.dataState==2]checked="checked"[/#if]/>
                    <div class="checkBox [#if item.dataState==2] c [/#if]" ></div>
                    <span class="[#if item.dataState==2]spanChecked[/#if]">${item.name}</span>
                </div>
                <div class="itemInput">
                ${item.id}
                    <input type="hidden"  class="detailId" value="${item.id}">
                    <div class="checkBox" ></div>
                    <input class="changeInput" type="text" value="">
                    <img class="changeDel" src="/icon/del.png" alt="">
                    <!--<img class="changeAdd" src="/icon/changeAdd.png" alt="">-->
                </div>
            [/#list]

            </div>
            <!--添加新项目-->
            <div class="add" id="newItem">
                <img src="/icon/add.png" alt="">
            </div>
            <div class="changeOk">
                <img src="/icon/changeOk.png" alt="">
            </div>
        </div>
    </div>
</form>