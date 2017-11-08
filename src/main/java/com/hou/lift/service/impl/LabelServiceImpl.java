package com.hou.lift.service.impl;

import com.hou.lift.dao.LabelMapper;
import com.hou.lift.dao.TaskSqlMapper;
import com.hou.lift.model.Label;
import com.hou.lift.model.LabelExample;
import com.hou.lift.model.TaskExample;
import com.hou.lift.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private TaskSqlMapper taskSqlMapper;
    @Override
    public List<Label> getLabelList(Integer userId) {
        LabelExample example = new LabelExample();
        LabelExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andDataStateNotEqualTo(2);
        example.setOrderByClause("label_id asc");
        List<Label> labelList = labelMapper.selectByExample(example);
        return labelList;
    }

    @Override
    public Label getLabelById(Integer labelId) {
        Label label = labelMapper.selectByPrimaryKey(labelId);
        return label;
    }

    @Override
    public int addLabel(Label label) {
        label.setDataState(1);
        label.setCreateDate(Calendar.getInstance().getTime());
        int res = labelMapper.insert(label);
        return res;
    }

    @Override
    public int updateLabel(Label label) {
        label.setUpdateDate(Calendar.getInstance().getTime());
        int res = labelMapper.updateByPrimaryKeySelective(label);
        return res;
    }

    @Override
    public int deleteLabel(Integer labelId) {
        int res = labelMapper.deleteByPrimaryKey(labelId);
        return res;
    }

    @Override
    public boolean checkInUse(Integer userId, Integer labelId) {
        TaskExample example = new TaskExample();
        TaskExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andDataStateNotEqualTo(2);
        criteria.andLabelIdIsNotNull();
        example.setOrderByClause("label_id asc");
        List<Integer> labelList = taskSqlMapper.getLabelInUse(example);
        if (labelList.contains(labelId)) {
            return true;
        }
        return false;
    }
}
