package com.userviewer.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class UserViewerDTO {

	private Long viewId;
	private Long userId;
	private String userName;
	private String userSurname;
	@DateTimeFormat(pattern = "dd.MM.yyyy HH:mm", iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime viewDate;
	public Long getViewId() {
		return viewId;
	}
	public void setViewId(Long viewId) {
		this.viewId = viewId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	public LocalDateTime getViewDate() {
		return viewDate;
	}
	public void setViewDate(LocalDateTime viewDate) {
		this.viewDate = viewDate;
	}
	
	

}
