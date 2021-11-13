package com.sample.factory.service;

import com.sample.factory.factory.SampleFactory;

public class SampleService2 {

    public synchronized void print() throws InterruptedException {
        Thread.sleep(10000);
        SampleFactory.getInstance().print();
    }

}
