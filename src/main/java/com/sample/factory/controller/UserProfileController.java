package com.sample.factory.controller;

import com.sample.factory.VO.ResponseVO;
import com.sample.factory.VO.UserVO;
import com.sample.factory.abstractTest.User;
import com.sample.factory.aspect.annotation.NoLogging;
import com.sample.factory.constant.MessageStore;
import com.sample.factory.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @NoLogging
    @RequestMapping(value = "/user/id/{id}", method = RequestMethod.GET)
    public ResponseVO getUser(@PathVariable final Long id) throws Exception {
        final ResponseVO responseVO = new ResponseVO();
        final UserVO userVO = this.userProfileService.getUser(id);
        responseVO.setCode(HttpStatus.OK.value());
        responseVO.setStatus(MessageStore.SUCCESS);
        responseVO.setMessage(MessageStore.USER_FETCH_SUCCESS);
        responseVO.setExecutionTime();
        responseVO.setData(userVO);
        return responseVO;
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
