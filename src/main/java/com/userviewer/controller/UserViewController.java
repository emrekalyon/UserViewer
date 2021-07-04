package com.userviewer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userviewer.dto.UserViewRequestDTO;
import com.userviewer.dto.UserViewResponse;
import com.userviewer.dto.UserViewerDTO;
import com.userviewer.service.UserViewService;

@RestController
@RequestMapping("user-views")
public class UserViewController {

	@Autowired
	private UserViewService userTrackerService;
	
	@PostMapping(consumes  = {MediaType.APPLICATION_JSON_VALUE})
	public void addNewView(@Valid @RequestBody  UserViewRequestDTO req  ) {
		
		userTrackerService.addTrackInformation(req.getViewerId(), req.getViewedUserId());
	}
	
	
	@GetMapping(path = "/{userId}/viewers",produces = {MediaType.APPLICATION_JSON_VALUE})
	public UserViewResponse getViewListOfUser(@PathVariable("userId") Long userId){
		
		List<UserViewerDTO> userViews = userTrackerService.getUserViewResponse(userId);
		
		return new UserViewResponse(userViews);
	}
}
