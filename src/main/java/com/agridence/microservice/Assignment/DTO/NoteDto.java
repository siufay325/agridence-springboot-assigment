package com.agridence.microservice.Assignment.DTO;

import com.agridence.microservice.Assignment.Entity.Note;
import com.agridence.microservice.Assignment.Entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoteDto {

    private Long id;

    private String title;

    private String description;

    public static NoteDto fromDto(Note note) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(note.getId());
        noteDto.setTitle(note.getTitle());
        noteDto.setDescription(note.getDescription());
        return noteDto;
    }

}
