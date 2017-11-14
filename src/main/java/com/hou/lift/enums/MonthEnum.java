package com.hou.lift.enums;

import java.util.ArrayList;
import java.util.List;

public enum MonthEnum {

    JAN(1,"01"),
    FEB(2,"02"),
    MAR(3,"03"),
    APR(4,"04"),
    MAY(5,"05"),
    JUN(6,"06"),
    JUL(7,"07"),
    AUG(8,"08"),
    SEP(9,"09"),
    OCT(10,"10"),
    NOV(11,"11"),
    DEC(12,"12")
    ;


    private String msg;

    private Integer id;


    MonthEnum(Integer id, String msg)  {
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
        for (MonthEnum c : MonthEnum.values()) {
            if (c.getId() == index) {
                return c.msg;
            }
        }
        return null;
    }

    public static List<String> getMonthList() {
        List<String> monthList = new ArrayList<>();
        for (MonthEnum c : MonthEnum.values()) {
            monthList.add(c.msg);
        }
        return monthList;
    }

}
