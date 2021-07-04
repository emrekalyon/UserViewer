package com.userviewer.dto;

import java.util.List;

public class UserViewResponse {

	private List<UserViewerDTO> userViews;

	public UserViewResponse(List<UserViewerDTO> userViews) {
		this.userViews = userViews;
	}

	public List<UserViewerDTO> getUserViews() {
		return userViews;
	}

	public void setUserViews(List<UserViewerDTO> userViews) {
		this.userViews = userViews;
	}
	
}
