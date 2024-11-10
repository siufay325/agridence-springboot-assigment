package com.agridence.microservice.Assignment.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class GetNotesResponse {

    private List<NoteDto> notes;

    public GetNotesResponse(List<NoteDto> notes) {
        this.notes = notes;
    }

}
