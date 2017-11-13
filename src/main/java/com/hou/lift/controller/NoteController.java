package com.hou.lift.controller;

import com.hou.lift.model.Note;
import com.hou.lift.param.NoteQueryParam;
import com.hou.lift.service.NoteService;
import com.hou.lift.util.BaseResult;
import com.hou.lift.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    //展示列表的方法
    @RequestMapping("/noteList")
    public String noteList(Integer userId, NoteQueryParam noteQueryParam, ModelMap modelMap, HttpServletRequest request) throws ParseException {
        HttpSession session = request.getSession();
        userId = (Integer) session.getAttribute("userId");
        List<Note> noteList = noteService.getNoteList(userId,noteQueryParam);
        modelMap.addAttribute("userId", userId);
        modelMap.addAttribute("noteList", noteList);
        return "/noteList";
    }


    @ResponseBody
    @RequestMapping("/insertNote")
    public String insertTask(Integer userId,Note note,HttpServletRequest request) {
        if (null == userId) {
            userId = (Integer) request.getSession().getAttribute("userId");
        }
        BaseResult baseResult = new BaseResult();
        note.setUserId(userId);
        int c =noteService.addNote(note);
        if (c == 1) {
            baseResult.setStatus(true);
            baseResult.setData(note.getNoteId());
            baseResult.setMsg("保存成功!");
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("保存失败");
        }
        return JsonUtils.toJson(baseResult);
    }

    @ResponseBody
    @RequestMapping("/updateNote")
    public HashMap<String, Object> updateNote(Note note,String del) throws ParseException {
        BaseResult baseResult = new BaseResult();
        if ("yes".equals(del)) {
            note.setDataState(2);
        }
        int c =noteService.updateNote(note);
        if (c == 1) {
            baseResult.setStatus(true);
            baseResult.setMsg("保存成功!");
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("保存失败");
        }
        return JsonUtils.toHashMap(baseResult);
    }



}
