package com.sample.factory.service;

import com.sample.factory.VO.UserVO;
import com.sample.factory.aspect.NoLogging;
import com.sample.factory.entity.UserProfile;
import com.sample.factory.repo.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepo userProfileRepo;

    public void createUser(final UserVO userVO) {
        final UserProfile userProfile = new UserProfile();
        userProfile.setName(userVO.getName());
        userProfile.setUsername(userVO.getUsername());
        this.userProfileRepo.save(userProfile);
    }

    public void createUsers() {
        final String s = UUID.randomUUID().toString();
        final UserProfile userProfile = new UserProfile();
        userProfile.setUsername(s);
        userProfile.setName(s);
        this.userProfileRepo.save(userProfile);
    }

    public UserVO getUser(final Long id) {
        final UserProfile userProfile = this.userProfileRepo.getById(id);
        return this.getUserVO(userProfile);
    }

    public UserVO getUser(final String username) {
        final UserProfile userProfile = this.userProfileRepo.findByUsername(username);
        return this.getUserVO(userProfile);
    }

    private UserVO getUserVO(final UserProfile userProfile) {
        final UserVO userVO = new UserVO();
        userVO.setId(userProfile.getId());
        userVO.setName(userProfile.getName());
        userVO.setUsername(userProfile.getUsername());
        userVO.setCreatedAt(userProfile.getCreatedAt());
        return userVO;
    }

}
