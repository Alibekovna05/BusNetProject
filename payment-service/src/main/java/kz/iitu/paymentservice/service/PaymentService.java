package kz.iitu.paymentservice.service;


import kz.iitu.paymentservice.dto.PaymentRequest;
import kz.iitu.paymentservice.dto.PaymentResponse;

public interface PaymentService {

    long processPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByBookingId(Long bookingId);

}