package com.sample.factory.factory;

import com.sample.factory.service.SampleService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleFactory {

    private static SampleService1 sampleService1;

    @Autowired
    public SampleFactory(SampleService1 sampleService1) {
        SampleFactory.sampleService1 = sampleService1;
    }

    public static SampleService1 getInstance() {
        return SampleFactory.sampleService1;
    }

}
