package com.hou.lift.enums;

public enum InitDetailEnum {
    ONE(1,"这是你的第一个任务。"),
    TWO(2, "点击任务可以标记为已做完。"),
    THREE(3, "再次点击会恢复状态。"),
    FOUR(4, "同时进度条会有变化。"),
    FIVE(5, "点击下面的按钮可以新增。"),
    ;


    private String msg;

    private Integer id;


    InitDetailEnum(Integer id,String msg)  {
        this.msg = msg;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // 普通方法
    public static String getName(int index) {
        for (InitDetailEnum c : InitDetailEnum.values()) {
            if (c.getId() == index) {
                return c.msg;
            }
        }
        return null;
    }

}
