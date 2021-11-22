package com.sample.factory.service;

import com.sample.factory.factory.PaymentServiceFactory;
import com.sample.factory.factory.SampleFactory;

public class SampleService2 {

    public void print() throws InterruptedException {
        final IPaymentService paymentService = PaymentServiceFactory.getInstance("GPAY");
        paymentService.initiatePayment();
    }

}
