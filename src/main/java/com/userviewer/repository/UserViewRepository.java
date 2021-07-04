package com.userviewer.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userviewer.entity.User;
import com.userviewer.entity.UserView;

public interface UserViewRepository extends JpaRepository<UserView, Long>{


	List<UserView> findTop20ByViewedUserIdAndDateGreaterThanOrderByLongDateDesc(User viewedUser, LocalDateTime maxDate);
}
