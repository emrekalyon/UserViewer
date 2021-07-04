package com.userviewer.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USER_TRACKING", indexes = { @Index(columnList = "VIEWED_USER_ID,VIEW_DATE_LNG", name = "VIEWER_INDEX") })
public class UserView {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "VIEWER_ID", nullable = false, updatable = false)
	private User viewerId;

	@ManyToOne
	@JoinColumn(name = "VIEWED_USER_ID", nullable = false, updatable = false)
	private User viewedUserId;

	@NotNull
	@Column(name = "VIEW_DATE", nullable = false, updatable = false)
	private LocalDateTime date;

	@NotNull
	@Column(name = "VIEW_DATE_LNG", nullable = false, updatable = false)
	private Long longDate;

	public UserView() {
	}

	public UserView(@NotNull User viewerId, @NotNull User viewedUserId, @NotNull LocalDateTime date,
			@NotNull Long longDate) {
		super();
		this.viewerId = viewerId;
		this.viewedUserId = viewedUserId;
		this.date = date;
		this.longDate = longDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getViewerId() {
		return viewerId;
	}

	public void setViewerId(User viewerId) {
		this.viewerId = viewerId;
	}

	public User getViewedUserId() {
		return viewedUserId;
	}

	public void setViewedUserId(User viewedUserId) {
		this.viewedUserId = viewedUserId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Long getLongDate() {
		return longDate;
	}

	public void setLongDate(Long longDate) {
		this.longDate = longDate;
	}

}
