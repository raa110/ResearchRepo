package com.sample.factory.service;

public class GpayService implements IPaymentService {
    @Override
    public void initiatePayment() {
        System.out.println("pay using GPAY");
    }
}
