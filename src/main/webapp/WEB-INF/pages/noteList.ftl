<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/style/notes.css"/>
    <link rel="stylesheet" type="text/css" href="/style/nav.css"/>
    <script src="/script/jquery-3.2.1.js" charset="utf-8"></script>
    <script src="/script/notes.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<!--侧导航-->
<div id="nav-left">
    <a href="/task/list.action" title="任务">
        <img src="/icon/renwu.png"/>
    </a>
    <a href="/note/noteList.action" title="便笺/备忘">
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

<!--主体-->
<form action="">
    <input type="hidden" id="userId" value="">
    <div class="content">
        <!--时间-->
        <div class="time">
            <!--年-->
            <div class="theTime">
                <div class="year">
                    <span class="noThing"></span>
                    <span class="noThing"></span>
                    <span class="theYear">2017</span>
                    <span class="theYear">2018</span>
                    <span class="theYear">2019</span>
                    <span class="noThing"></span>
                    <span class="noThing"></span>
                </div>
            </div>
            <!--月-->
            <div class="theTime">
                <div class="month">
                    <span class="noThing"></span>
                    <span class="noThing"></span>
                    <span class="theMonth">1</span>
                    <span class="theMonth">2</span>
                    <span class="theMonth">3</span>
                    <span class="theMonth">4</span>
                    <span class="theMonth">5</span>
                    <span class="theMonth">6</span>
                    <span class="theMonth">7</span>
                    <span class="theMonth">8</span>
                    <span class="theMonth">9</span>
                    <span class="theMonth">10</span>
                    <span class="theMonth">11</span>
                    <span class="theMonth">12</span>
                    <span class="noThing"></span>
                    <span class="noThing"></span>
                </div>
            </div>
            <!--日-->
            <div class="theTime">
                <div class="day">
                    <span class="noThing"></span>
                    <span class="noThing"></span>
                    <span class="theDay">1</span>
                    <span class="theDay">2</span>
                    <span class="theDay">3</span>
                    <span class="theDay">4</span>
                    <span class="theDay">5</span>
                    <span class="theDay">6</span>
                    <span class="theDay">7</span>
                    <span class="theDay">8</span>
                    <span class="theDay">9</span>
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
                    <span class="noThing"></span>
                    <span class="noThing"></span>
                </div>
            </div>

        </div>
        <!--内容-->
        <div class="contents">
        [#list noteList as note]
            <!--便签-->
            <div class="note">
                <!--时间-->
                <div class="hour">
                    <span class="theHour">${note.createTime}</span>
                </div>
                <input type="hidden" class="noteId" value="${note.noteId}">
                <!--便签内容-->
                <div class="notes">
                    <!--输入-->
                    <div class="noteInput" contenteditable="true">${note.content}<br/></div>
                </div>
                <!--删除-->
                <img class="delNote" src="/icon/del.png" alt="">
            </div>
        [/#list]


        </div>
    </div>
</form>
</body>
</html>