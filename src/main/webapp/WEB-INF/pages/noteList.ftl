<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>便签</title>
    <link rel="stylesheet" type="text/css" href="${base}/style/notes.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/style/nav.css"/>
    <script src="${base}/script/jquery-3.2.1.js" charset="utf-8"></script>
    <script src="${base}/script/notes.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<!--侧导航-->
[#include "nav.ftl"]
<!--上导航-->
<div id="nav-top">
    <!--搜索-->
    <div id="search">
        <input type="text" name="" id="search-text" value="" placeholder="任务名/内容/标签"/>
        <button id="search-button"><img src="${base}/icon/search.png"/></button>
    </div>
    <!--个人中心-->
    <div id="personal">
        <a href="">
            <img src="${base}/icon/personal.png"/>
            <img src="${base}/icon/open.png" id="open"/>
        </a>
    </div>
    <!--提醒-->
    <div id="remind">
        <img src="${base}/icon/remind.png"/>
        <span></span>
    </div>
    <!--测悬浮-->
    <div id="add">
        <img src="${base}/icon/add.png" alt="添加新项目">
    </div>
</div>

<!--主体-->
[#--<form action="" id="contentForm">--]
<input type="hidden" id="userId" value="">
<div class="content">
    <!--时间-->
    <div class="time">
        <!--年-->
        <div class="theTime">
            <div class="year">
                [#list yearList as year]
                <span class="theYear" [#if year==year][/#if]>${year}</span>
                [/#list]
            </div>
        </div>
        <!--月-->
        <div class="theTime">
            <div class="month">
                [#list monthList as month]
                <span class="theMonth">${month}</span>
                [/#list]
            </div>
        </div>
        <!--日-->
        <div class="theTime">
            <div class="day">
                [#list dayList as day]
                <span class="theDay">${day}</span>
                [/#list]
            </div>
        </div>

    </div>
[#--</form>--]
    <!--内容-->
[#include "noteInput.ftl"]
    <img src="${base}/icon/emptyBG.png" alt="点加号" id="emptyBG" hidden>
</div>

</body>
</html>