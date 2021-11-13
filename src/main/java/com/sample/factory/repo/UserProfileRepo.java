package com.sample.factory.repo;

import com.sample.factory.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {

    UserProfile findByUsername(String username);

}
