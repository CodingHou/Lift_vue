package com.hou.lift.service;

import com.hou.lift.model.Note;
import com.hou.lift.model.Note;

import java.util.List;

public interface NoteService {


    public List<Note> getNoteList(Integer UserId);

    public Note getNoteById(Integer noteId);

    public int addNote(Note note);

    public int updateNote(Note note);

    public int deleteNote(Integer noteId);

}
