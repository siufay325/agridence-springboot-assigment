package com.agridence.microservice.Assignment.Service;

import com.agridence.microservice.Assignment.DTO.*;
import com.agridence.microservice.Assignment.Entity.Note;
import com.agridence.microservice.Assignment.Entity.User;
import com.agridence.microservice.Assignment.Repository.NoteRepository;
import com.agridence.microservice.Assignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public CommonResponse<GetNotesResponse> get(long appUserId) {
        List<Note> noteList = noteRepository.findByUser_Id(appUserId);
        List<NoteDto> noteDtoList = noteList.stream().map(NoteDto::fromDto).toList();
        return CommonResponse.success(new GetNotesResponse(noteDtoList));
    }

    @Transactional
    public CommonResponse<EmptyResponse> add(long appUserId, AddNoteRequest request) {
        User user = userRepository.findById(appUserId).orElseThrow();
        Note note = request.toEntity(user);
        noteRepository.save(note);
        return CommonResponse.success();
    }

    @Transactional
    public CommonResponse<EmptyResponse> delete(long appUserId, long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow();
        if (note.getUser().getId() != appUserId) {
            return CommonResponse.fail("Invalid");
        }

        noteRepository.delete(note);
        return CommonResponse.success();
    }

}
