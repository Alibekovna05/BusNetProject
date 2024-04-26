package kz.iitu.busnet.busflightservice.exception;


import lombok.Data;

@Data
public class BusFlightServiceCustomException extends RuntimeException {

    private String errorCode;

    public BusFlightServiceCustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}