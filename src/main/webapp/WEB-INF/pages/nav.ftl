
<!--侧导航-->

<div id="nav-left">
    <a href="${base}/task/list.action" title="任务"  class="navLeftA [#if nav="task"]navChoose[/#if]">
        <img src="${base}/icon/renwu.png"/>
    </a>
    <a href="${base}/note/noteList.action" title="便笺/备忘" class="navLeftA [#if nav="note"]navChoose[/#if]">
        <img src="${base}/icon/bianqian.png"/>
    </a>
    <a href="" title="打卡/习惯养成" class="navLeftA">
        <img src="${base}/icon/daka.png"/>
    </a>
    <a href="" title="成就/种树"  class="navLeftA">
        <img src="${base}/icon/chengjiu.png"/>
    </a>
    <a href="" title="统计" class="navLeftA">
        <img src="${base}/icon/tongji.png"  />
    </a>
    <a href="${base}/task/getDelTask.action" title="回收站"  class="navLeftA [#if nav="delTask"]navChoose[/#if]">
        <img src="${base}/icon/delete.png"/>
    </a>
</div>

