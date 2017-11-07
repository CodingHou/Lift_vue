package com.hou.lift.service;

import com.hou.lift.model.Label;

import java.util.List;

public interface LabelService {


    public List<Label> getLabelList(Integer labelId);

    public Label getLabelById(Integer labelId);

    public int addLabel(Label label);

    public int updateLabel(Label label);

    public int deleteLabel(Integer labelId);

    boolean checkInUse(Integer userId, Integer labelId);
}
