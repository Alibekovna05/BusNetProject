package kz.iitu.paymentservice.service.impl;

import java.time.Instant;

import kz.iitu.paymentservice.dto.PaymentMode;
import kz.iitu.paymentservice.dto.PaymentRequest;
import kz.iitu.paymentservice.dto.PaymentResponse;
import kz.iitu.paymentservice.model.Payment;
import kz.iitu.paymentservice.repository.PaymentRepository;
import kz.iitu.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public long processPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details: {}", paymentRequest);

        Payment payment = Payment.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .bookingId(paymentRequest.getBookingId())
                .amount(paymentRequest.getAmount())
                .build();

        paymentRepository.save(payment);

        log.info("Payment Completed with Id: {}", payment.getPaymentId());

        return payment.getPaymentId();

    }

    @Override
    public PaymentResponse getPaymentDetailsByBookingId(Long bookingId) {
        log.info("Getting payment details for the Booking Id: {}", bookingId);

        Payment payment = paymentRepository.findByBookingId(bookingId);

        return PaymentResponse.builder()
                .paymentId(payment.getPaymentId())
                .paymentMode(PaymentMode.valueOf(payment.getPaymentMode()))
                .paymentDate(payment.getPaymentDate())
                .bookingId(payment.getBookingId())
                .status(payment.getPaymentStatus())
                .amount(payment.getAmount())
                .build();
    }

}