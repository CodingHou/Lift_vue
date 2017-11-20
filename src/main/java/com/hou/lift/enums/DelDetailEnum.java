package com.hou.lift.enums;

public enum DelDetailEnum {
    ONE(1,"这里是您的垃圾桶页面。"),
    TWO(2, "在主页面被删除的任务会显示在这里。"),
    THREE(3, "这里的任务详情是不可编辑的。"),
    FOUR(4, "点击任务右下方的恢复按钮，可以恢复到主页面。"),
//    FIVE(5, "点击下面的按钮可以新增。"),
//    SIX(6,"三个小圈圈分别代紧急，一般，不紧急。")
    ;


    private String msg;

    private Integer id;


    DelDetailEnum(Integer id, String msg)  {
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
        for (DelDetailEnum c : DelDetailEnum.values()) {
            if (c.getId() == index) {
                return c.msg;
            }
        }
        return null;
    }

}
