package com.sample.factory.controller;

import com.sample.factory.service.ConnectionService;
import com.sample.factory.service.PredicateService;
import com.sample.factory.service.SampleService2;
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

    @RequestMapping(value = "/print", method = RequestMethod.GET)
    public void print() throws Exception {
        final SampleService2 sampleService2 = new SampleService2();
        sampleService2.print();
    }

    @RequestMapping(value = "/connection", method = RequestMethod.GET)
    public void testConnection() throws Exception {
        this.connectionService.saveConnection();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleUpload(@RequestPart("file") final MultipartFile file) throws Exception {
        final byte[] bytes = file.getBytes();
        return "Success";
    }

    @RequestMapping(value = "/print/sync", method = RequestMethod.GET)
    public String synchronizedPrint() throws Exception {
        final SampleService2 sampleService2 = new SampleService2();
        sampleService2.print();
        return "Success after 10000 ms";
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