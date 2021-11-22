package com.sample.factory.controller;

import com.sample.factory.service.ConnectionService;
import com.sample.factory.service.PredicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SampleController {

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private PredicateService predicateService;

    @RequestMapping(value = "/connection", method = RequestMethod.GET)
    public void testConnection() throws Exception {
        this.connectionService.saveConnection();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleUpload(@RequestPart("file") final MultipartFile file) throws Exception {
        final byte[] bytes = file.getBytes();
        return "Success";
    }

    @RequestMapping(value = "/api/dummy", method = RequestMethod.GET)
    public String dummyAPI() {
        return "SUCCESS - But no intensive job";
    }

    @RequestMapping(value = "/api/predicate", method = RequestMethod.POST)
    public void researchPredicate() {
        this.predicateService.researchPredicate();
    }

}