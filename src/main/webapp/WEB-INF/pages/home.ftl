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
        <span id="">

				</span>
    </div>
    <!--测悬浮-->
    <div id="add">
        <img src="/icon/add.png" alt="添加新项目">
    </div>
</div>
<!--主体部分-->
<div id="content">
    <!--标签-->
    <div id="contentTag">
        <div id="tag-box">
					<span class="tag">
						家
					</span>
            <span class="tag">
						公司
					</span>
        </div>
    </div>
    <form action="taskForm" id="taskForm">
        <!--列表-->
        <div id="list-box">
[#list taskList as item]
    <div class="list addList" id="">

            <!--附加信息-->
            <div class="stateBar">
                <!--紧急程度-->
                <div class="grade grade1">
                </div>
                <div class="grade grade2">
                </div>
                <div class="grade grade3">
                </div>
                <!--标签-->
                <span class="tag theTag">${item.label}</span>
            </div>
            <!--标签悬浮-->
            <div class="allTag">
                <span class="tag">1</span>
                <span class="tag">2</span>
                <span class="tag">3</span>
            </div>
            <!--标题-->
            <div class="title">
                <input type="text" class="listInput" placeholder="标题">
                <span class="listSpan">${item.name}</span>
            </div>
            <!--日期-->
            <div class="day">
                <input type="date" class="listInput">
                <span class="listSpan">2017</span>
            </div>
            <!--进度条-->
            <div class="rate">
                <div class="ratio">
                </div>
            </div>
            <span class="rateVal">${item.completedDetail}/${item.totalDetail}</span>
            <!--删除-->
            <div class="del">
            </div>
        </div>
[/#list]
    </form>

</div>
<form action="" id="detailForm">
<!--内容-->
<div id="item-box">
    <div class="item" id="item">

        <div class="header">
            <div class="stateBar">
                <!--紧急程度-->
                <div class="grade">
                </div>
                <!--修改-->
                <div id="change">
                    <img src="icon/change.png" alt="">
                </div>
                <!--标签-->
                <span class="tag theTag">0</span>
            </div>
        </div>
        <h2>${task.name}</h2>
        [#list detaiList as item]
        <div id="toDoList">
            <div class="items">
                <input type="checkbox"/>
                <div class="checkBox"></div>
                <span>${item.name}</span>
            </div>
        [/#list]
        </div>
        <!--添加新项目-->
        <div class="add" id="newItem">
            <img src="icon/add.png" alt="">
        </div>


    </div>
</div>
</form>
</div>
</body>
</html>
