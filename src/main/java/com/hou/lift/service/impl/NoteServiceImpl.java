package com.hou.lift.service.impl;

import com.hou.lift.dao.NoteMapper;
import com.hou.lift.dao.TaskSqlMapper;
import com.hou.lift.model.Note;
import com.hou.lift.model.NoteExample;
import com.hou.lift.model.Note;
import com.hou.lift.model.TaskExample;
import com.hou.lift.param.NoteQueryParam;
import com.hou.lift.service.NoteService;
import com.hou.lift.service.NoteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;
    @Override
    public List<Note> getNoteList(Integer userId, NoteQueryParam noteQueryParam) throws ParseException {
        NoteExample example = new NoteExample();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        NoteExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if (StringUtils.isNotEmpty(noteQueryParam.getQueryContent())) {
        }
        if (StringUtils.isNotEmpty(noteQueryParam.getStartTime())) {
            criteria.andCreateTimeGreaterThanOrEqualTo(sdf.parse(noteQueryParam.getStartTime()+" 00:00:00"));
        }
        if (StringUtils.isNotEmpty(noteQueryParam.getEndTime())) {
            criteria.andCreateTimeLessThanOrEqualTo(sdf.parse(noteQueryParam.getEndTime()+" 23:59:59"));
        }
        criteria.andDataStateNotEqualTo(2);
        example.setOrderByClause("note_id desc");
        List<Note> noteList = noteMapper.selectByExampleWithBLOBs(example);
        return noteList;
    }

    @Override
    public Note getNoteById(Integer noteId) {
        Note note = noteMapper.selectByPrimaryKey(noteId);
        return note;
    }

    @Override
    public int addNote(Note note) {
        note.setDataState(1);
        note.setCreateTime(Calendar.getInstance().getTime());
        note.setUpdateTime(Calendar.getInstance().getTime());
        int res = noteMapper.insert(note);
        return res;
    }

    @Override
    public int updateNote(Note note) {
        note.setUpdateTime(Calendar.getInstance().getTime());
        int res = noteMapper.updateByPrimaryKeySelective(note);
        return res;
    }

    @Override
    public int deleteNote(Integer noteId) {
        int res = noteMapper.deleteByPrimaryKey(noteId);
        return res;
    }

  

   
}
