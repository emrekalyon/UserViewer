package com.userviewer.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.userviewer.dto.UserViewerDTO;
import com.userviewer.entity.User;
import com.userviewer.entity.UserView;
import com.userviewer.repository.UserViewRepository;

@Service
public class UserViewService {

	@Autowired
	private UserViewRepository userTrackerRepository;
	
	@Async
	@Transactional
	public void addTrackInformation(Long viewerUserId, Long trackedUserId) {
		
		LocalDateTime now = LocalDateTime.now();
		//small execution time difference is not important
		long milliSeconds = System.currentTimeMillis();
		
		User viewerUser = new User();
		viewerUser.setId(viewerUserId);

		User trackedUser = new User();
		trackedUser.setId(trackedUserId);
		
		userTrackerRepository.save(new UserView(viewerUser,trackedUser,now,milliSeconds));
		
	}

	@Transactional
	public List<UserViewerDTO> getUserViewResponse(Long userId) {
		
		LocalDateTime maxDate = LocalDateTime.now().minusDays(30).withHour(0).withMinute(0).withSecond(0);
		User viewedUser = new User();
		viewedUser.setId(userId);
		List<UserView> userViewList = userTrackerRepository.findTop20ByViewedUserIdAndDateGreaterThanOrderByLongDateDesc(viewedUser,maxDate);
		
		List<UserViewerDTO> userViews = new ArrayList<>();
		
		for (UserView userView : userViewList) {

			UserViewerDTO userViewDTO = new UserViewerDTO();
			userViewDTO.setViewId(userView.getId());
			userViewDTO.setViewDate(userView.getDate());

			User viewerUser = userView.getViewerId();
			userViewDTO.setUserId(viewerUser.getId());
			userViewDTO.setUserName(userView.getViewerId().getName());
			userViewDTO.setUserSurname(userView.getViewedUserId().getSurname());
			
			userViews.add(userViewDTO);
		}
		
		return userViews;
	}

}
