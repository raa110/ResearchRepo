package com.sample.factory.factory;

import com.sample.factory.service.GpayService;
import com.sample.factory.service.IPaymentService;
import com.sample.factory.service.PhonepeService;

import java.util.LinkedHashMap;
import java.util.Map;

public class PaymentServiceFactory {

    final static Map<String, IPaymentService> paymentServiceCache = new LinkedHashMap<>();

    public PaymentServiceFactory() {
        paymentServiceCache.put("GPAY", new GpayService());
        paymentServiceCache.put("PHONEPE", new PhonepeService());
    }

    public static IPaymentService getInstance(String type) {
        return paymentServiceCache.get(type);
    }

}
