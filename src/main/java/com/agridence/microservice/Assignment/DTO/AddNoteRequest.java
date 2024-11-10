package com.agridence.microservice.Assignment.DTO;

import com.agridence.microservice.Assignment.Entity.Note;
import com.agridence.microservice.Assignment.Entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddNoteRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    public Note toEntity(User user) {
        Note note = new Note();
        note.setUser(user);
        note.setTitle(title);
        note.setDescription(description);
        return note;
    }

}
