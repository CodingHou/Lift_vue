package com.hou.lift.dao;

import com.hou.lift.model.TaskExample;

import java.util.List;

public interface LabelSqlMapper {

    List<Integer> getLabelInUse(TaskExample taskExample);
}