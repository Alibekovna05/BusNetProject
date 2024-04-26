package kz.iitu.busnet.bookingservice.external.response;


import kz.iitu.busnet.bookingservice.dto.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse {
    private long paymentId;
    private String status;
    private PaymentMode paymentMode;
    private double amount;
    private Instant paymentDate;
    private long bookingId;
}