<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="/style/home.css"/>
    <link rel="stylesheet" type="text/css" href="/style/nav.css"/>
    <script src="/script/jquery-3.2.1.js" charset="utf-8"></script>
    <script src="/script/home.js" charset="utf-8"></script>
</head>
<body>
<!--侧导航-->
<div id="nav-left">
    <a href="" title="任务">
        <img src="/icon/renwu.png"/>
    </a>
    <a href="" title="便笺/备忘">
        <img src="/icon/bianqian.png"/>
    </a>
    <a href="" title="打卡/习惯养成">
        <img src="/icon/daka.png"/>
    </a>
    <a href="" title="成就/种树">
        <img src="/icon/chengjiu.png"/>
    </a>
    <a href="" title="统计">
        <img src="/icon/tongji.png"/>
    </a>
    <a href="" title="回收站">
        <img src="/icon/delete.png"/>
    </a>
</div>
<!--上导航-->
<div id="nav-top">
    <!--搜索-->
    <div id="search">
        <input type="text" name="" id="search-text" value="" placeholder="任务名/内容/标签"/>
        <button id="search-button"><img src="/icon/search.png"/></button>
    </div>
    <!--个人中心-->
    <div id="personal">
        <a href="">
            <img src="/icon/personal.png"/>
            <img src="/icon/open.png" id="open"/>
        </a>
    </div>
    <!--提醒-->
    <div id="remind">
        <img src="/icon/remind.png"/>
        <span></span>
    </div>
    <!--测悬浮-->
    <div id="add">
        <img src="/icon/add.png" alt="添加新项目">
    </div>
</div>

<input type="hidden" id="userId" value="${userId}">
<!--主体部分-->
<div id="content">
    <!--标签-->
    <form action="" id="labelForm">
        <div id="contentTag">
            <div id="tag-box">

                <img class="tagOk" src="/icon/changeOk.png" alt="">
                <img class="tagChange" src="/icon/change.png" alt="">

                <span class="tag select">家</span>
                <span class="tagDel">-</span>
                <input type="hidden" value="">

                <span class="tag select">公司</span>
                <span class="tagDel">-</span>
                <input type="hidden" value="">

                <span class="addTag">添加新标签</span>
            </div>
        </div>
    </form>

    <!--列表-->
    <form action="/task/insertTask.action" id="taskForm">
        <div id="list-box">

        [#list taskList as item]
            <div class="task addTask" id="">
                <input type="hidden" id="" class="taskId" value="${item.id}">
                <!--附加信息-->
                <div class="stateBar">

                        <div class="grade grade${item.grade}" >
                            <input type="hidden" value="${item.grade}">
                        </div>

                        <div class="gradeBox" hidden>
                            <div class="grade grade1" >
                                <input type="hidden" name="grade1" value="1">
                            </div>
                            <div class="grade grade2">
                                <input type="hidden" name="grade2" value="2">
                            </div>
                            <div class="grade grade3">
                                <input type="hidden" name="grade3" value="3">
                            </div>
                        </div>

                    <!--标签-->
                    <span class="tag theTag1">${item.label}</span>
                    <!--<span class="tag theTag2">+</span>-->
                </div>
                <!--标签悬浮-->
                <div class="allTag">
                    [#list tagList as tag]
                        <span class="tag NoChoose">${tag.name}</span>
                    [/#list]
                </div>

                <!--标题-->
                <div class="title">
                    <input type="text" class="listInput" placeholder="标题">
                    <span class="listSpan">${item.name}</span>
                </div>
                <!--日期-->
                <div class="day">
                    <input type="date" class="listInput">
                    <span class="listSpan">${item.date}</span>
                </div>
                <!--进度条-->
                <div class="rate">
                    <div class="ratio">
                    </div>
                </div>
                <span class="rateVal">${item.completedDetail}/${item.totalDetail}</span>
                <!--删除-->
                <img src="/icon/del.png" alt="" class="del">
            </div>
        [/#list]


        </div>
    </form>

    <!--内容-->
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
                    <input type="hidden"  class="detailId" value="${item.id}">
                    <div class="items">
                        [#--<input type="hidden"  class="detailId" value="${item.id}">--]
                        ${item.id}
                        <input type="checkbox" [#if item.dataState==2]checked="checked"[/#if]/>
                        <div class="checkBox [#if item.dataState==2] c [/#if]" ></div>
                        <span class="[#if item.dataState==2]spanChecked[/#if]">${item.name}</span>
                    </div>
                    <div class="itemInput">
                        ${item.id}
                        <div class="checkBox [#if item.dataState==2] c [/#if]"></div>
                        <input class="changeInput" type="text" value="${item.name}">
                        <img class="changeDel" src="/icon/del.png" alt="">
                        <!--<img class="changeAdd" src="/icon/changeAdd.png" alt="">-->
                    </div>
                [/#list]

                </div>
                <!--添加新项目-->
                <div class="add" id="newItem">
                    <img src="/icon/add.png" alt="">
                </div>
                <div class="changeOk" id="changeOk">
                    <img src="/icon/changeOk.png" alt="">
                </div>
            </div>
        </div>
    </form>

</div>
</body>
</html>
