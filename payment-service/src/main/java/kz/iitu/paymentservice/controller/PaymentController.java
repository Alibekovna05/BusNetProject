package kz.iitu.paymentservice.controller;


import kz.iitu.paymentservice.dto.PaymentRequest;
import kz.iitu.paymentservice.dto.PaymentResponse;
import kz.iitu.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {


    private PaymentService paymentService;

    @PostMapping
    public Long processPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.processPayment(paymentRequest);
    }

    @GetMapping()
    public ResponseEntity<PaymentResponse> getPaymentDetailsByBookingNumber(
            @RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(
                paymentService.getPaymentDetailsByBookingId(id),
                HttpStatus.OK);
    }
}