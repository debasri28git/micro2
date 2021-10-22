package com.upgrad.payment.service;

import com.upgrad.payment.model.TransactionDetailsEntity;
import com.upgrad.payment.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {
    @Autowired
    PaymentRepo paymentRepo;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${booking.url}")
    private String bookingUrl;

    public int saveDetails(TransactionDetailsEntity obj)
    {
        System.out.println(obj);
        obj=paymentRepo.save(obj);
        //paymentRepo.flush();
        return obj.getId();
    }

    public int saveDetails()
    {
        TransactionDetailsEntity obj=(restTemplate.getForObject(bookingUrl, TransactionDetailsEntity.class));

        obj=paymentRepo.save(obj);
        paymentRepo.flush();
        return obj.getId();
    }
    public TransactionDetailsEntity getDetails(int transactionId)
    {
        TransactionDetailsEntity entity=paymentRepo.findById(transactionId).get();
        return entity;
    }

}
