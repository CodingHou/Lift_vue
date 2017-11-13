<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>便签</title>
    <link rel="stylesheet" type="text/css" href="/style/notes.css"/>
    <link rel="stylesheet" type="text/css" href="/style/nav.css"/>
    <script src="/script/jquery-3.2.1.js" charset="utf-8"></script>
    <script src="/script/notes.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<!--侧导航-->
[#include "nav.ftl"]
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

<!--主体-->
[#--<form action="" id="contentForm">--]
<input type="hidden" id="userId" value="">
<div class="content">
    <!--时间-->
    <div class="time">
        <!--年-->
        <div class="theTime">
            <div class="year">
                <span class="theYear">2017</span>
                <span class="theYear">2018</span>
                <span class="theYear">2019</span>
            </div>
        </div>
        <!--月-->
        <div class="theTime">
            <div class="month">
                <span class="theMonth">01</span>
                <span class="theMonth">02</span>
                <span class="theMonth">03</span>
                <span class="theMonth">04</span>
                <span class="theMonth">05</span>
                <span class="theMonth">06</span>
                <span class="theMonth">07</span>
                <span class="theMonth">08</span>
                <span class="theMonth">09</span>
                <span class="theMonth">10</span>
                <span class="theMonth">11</span>
                <span class="theMonth">12</span>
            </div>
        </div>
        <!--日-->
        <div class="theTime">
            <div class="day">
                <span class="theDay">01</span>
                <span class="theDay">02</span>
                <span class="theDay">03</span>
                <span class="theDay">04</span>
                <span class="theDay">05</span>
                <span class="theDay">06</span>
                <span class="theDay">07</span>
                <span class="theDay">08</span>
                <span class="theDay">09</span>
                <span class="theDay">10</span>
                <span class="theDay">11</span>
                <span class="theDay">12</span>
                <span class="theDay">13</span>
                <span class="theDay">14</span>
                <span class="theDay">15</span>
                <span class="theDay">16</span>
                <span class="theDay">17</span>
                <span class="theDay">18</span>
                <span class="theDay">19</span>
                <span class="theDay">20</span>
                <span class="theDay">21</span>
                <span class="theDay">22</span>
                <span class="theDay">23</span>
                <span class="theDay">24</span>
                <span class="theDay">25</span>
                <span class="theDay">26</span>
                <span class="theDay">27</span>
                <span class="theDay">28</span>
                <span class="theDay">29</span>
                <span class="theDay">30</span>
                <span class="theDay">31</span>
            </div>
        </div>

    </div>
[#--</form>--]
    <!--内容-->
[#include "noteInput.ftl"]

</div>

</body>
</html>