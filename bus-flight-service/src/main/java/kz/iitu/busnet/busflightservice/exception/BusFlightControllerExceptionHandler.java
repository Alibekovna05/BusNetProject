package kz.iitu.busnet.busflightservice.exception;


import kz.iitu.busnet.busflightservice.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BusFlightControllerExceptionHandler extends ResponseEntityExceptionHandler {

    // handle specific exception
    @ExceptionHandler(BusFlightServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleFlightServiceException(BusFlightServiceCustomException exception) {

        return new ResponseEntity<>(ErrorResponse.builder()
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    // handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericExceptionHandler(Exception exception) {

        return new ResponseEntity<>(ErrorResponse.builder()
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .errorMessage(exception.getMessage())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}