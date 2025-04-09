package com.bysluer.reservationservice.exception.handler;

import com.bysluer.reservationservice.exception.HotelNotFoundException;
import com.bysluer.reservationservice.exception.RoomHotelMismatchException;
import com.bysluer.reservationservice.exception.RoomNotAvailableException;
import com.bysluer.reservationservice.exception.RoomNotFoundException;
import exception.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ReservationExceptionHandler{

    @ExceptionHandler({
            HotelNotFoundException.class,
            RoomNotFoundException.class,
            RoomNotAvailableException.class,
            RoomHotelMismatchException.class,
            InvalidReservationDateException.class
    })
    public ResponseEntity<ApiErrorResponse> handleDomainExceptions(RuntimeException ex, HttpServletRequest request) {
        ApiErrorResponse response = ApiErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Domain Validation Failed")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(Exception ex, HttpServletRequest request) {
        ApiErrorResponse response = ApiErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Internal Server Error")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
