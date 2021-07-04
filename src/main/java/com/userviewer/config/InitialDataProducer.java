package com.userviewer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.userviewer.entity.User;
import com.userviewer.repository.UserRepository;

@Component
public class InitialDataProducer {
	
	@Autowired
	private UserRepository userRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
	
		long userCount = userRepository.count();
		
		if(userCount != 0) {
			return;
		}
		
		User user1 = new User();
		user1.setName("Emre");
		user1.setSurname("Kalyoncu");
		user1.setProfilePicUrl("http://test.com");
		userRepository.save(user1);

		User user2 = new User();
		user2.setName("Hasan");
		user2.setSurname("Basri");
		user2.setProfilePicUrl("http://test1.com");
		userRepository.save(user2);
		
		
		User user3 = new User();
		user3.setName("Mithat");
		user3.setSurname("Marakov");
		user3.setProfilePicUrl("http://test2.com");
		userRepository.save(user3);
	}

}