package com.sample.factory.service;

public class PhonepeService implements  IPaymentService {
    @Override
    public void initiatePayment() {
        System.out.println("pay using PHONEPE");
    }
}
