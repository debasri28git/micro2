package com.upgrad.payment.model;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transactionid")
    int id ;
    @Column(name = "payment_mode")
    String paymentMode;
    @Column(name="booking_id",nullable = false )
    int bookingId;
    @Column(name="upi_id")
    String upiId;
    @Column(name="cardnumber")
    String cardNumber;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentMode() {
        return paymentMode;
    }
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
    public String getUpiId() {
        return upiId;
    }
    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }
    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public TransactionDetailsEntity() {
        super();
    }



}
