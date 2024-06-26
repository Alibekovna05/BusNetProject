package kz.iitu.busnet.bookingservice.external.request;


import kz.iitu.busnet.bookingservice.dto.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {

    private Long bookingId;
    private double amount;
    private String referenceNumber;
    private PaymentMode paymentMode;
}