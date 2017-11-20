<!DOCTYPE html>
<form action="/${base}/note/noteInputList.action" id="noteInputForm">
<div class="contents" id="noteList">
[#list noteList as note]
    <!--便签-->
    <div class="note">
        <!--时间-->
        <div class="hour">
            <span class="theHour">${note.createTime?string('MM-dd HH:mm')}</span>
        </div>
        <input type="hidden" class="noteId" value="${note.noteId}">
        <!--便签内容-->
        <div class="notes">
            <!--输入-->
            <div class="noteInput" contenteditable="true">${note.content}<br/></div>
        </div>
        <!--删除-->
        <img class="delNote" src="${base}/icon/del.png" alt="">
    </div>
[/#list]
</div>
</form>