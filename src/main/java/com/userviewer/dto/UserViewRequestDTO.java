package com.userviewer.dto;

import javax.validation.constraints.NotNull;

public class UserViewRequestDTO{

	@NotNull(message = "ViewerId must not be null")
	private Long viewerId;
	
	@NotNull(message = "vieweddUserId must not be null")
	private Long viewedUserId;
	
	public Long getViewerId() {
		return viewerId;
	}

	public void setViewerId(Long viewerId) {
		this.viewerId = viewerId;
	}

	public Long getViewedUserId() {
		return viewedUserId;
	}

	public void setViewedUserId(Long trackedUserId) {
		this.viewedUserId = trackedUserId;
	}
	
}
