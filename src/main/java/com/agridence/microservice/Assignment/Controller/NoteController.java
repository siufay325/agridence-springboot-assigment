package com.agridence.microservice.Assignment.Controller;

import com.agridence.microservice.Assignment.DTO.*;
import com.agridence.microservice.Assignment.Service.NoteService;
import com.agridence.microservice.Assignment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController	
public class NoteController {

	@Autowired
	private UserService userService;

	@Autowired
	private NoteService noteService;

	@GetMapping("/get")
	public CommonResponse<GetNotesResponse> get(@RequestHeader("Access-Token") String accessToken) {
		long userId = userService.getUserId(accessToken);
		return noteService.get(userId);
	}

	@PostMapping("/add")
	public CommonResponse<EmptyResponse> add(@RequestHeader("Access-Token") String accessToken,
											 @RequestBody AddNoteRequest request) {
		long userId = userService.getUserId(accessToken);
		return noteService.add(userId, request);
	}

	@PostMapping("/delete")
	public CommonResponse<EmptyResponse> delete(@RequestHeader("Access-Token") String accessToken,
												@RequestBody DeleteNoteRequest request) {
		long userId = userService.getUserId(accessToken);
		return noteService.delete(userId, request.getId());
	}

}
