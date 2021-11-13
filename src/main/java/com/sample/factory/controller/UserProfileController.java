package com.sample.factory.controller;

import com.sample.factory.VO.UserVO;
import com.sample.factory.aspect.NoLogging;
import com.sample.factory.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @NoLogging
    @RequestMapping(value = "/user/id/{id}", method = RequestMethod.GET)
    public UserVO getUser(@PathVariable final Long id) {
        return this.userProfileService.getUser(id);
    }

    @RequestMapping(value = "/user/username/{username}", method = RequestMethod.GET)
    public UserVO getUser(@PathVariable final String username) {
        return this.userProfileService.getUser(username);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createUser(@RequestBody final UserVO userVO) {
        this.userProfileService.createUser(userVO);
        return "Success";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String createUsers() {
        this.userProfileService.createUsers();
        return "Success";
    }

}
