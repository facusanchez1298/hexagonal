package com.example.hexagonal.infrastructure.handler;

import com.example.hexagonal.domain.exception.ProductWithoutBuyPriceException;
import com.example.hexagonal.domain.exception.ProductWithoutSellPriceException;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
@Log
public class ErrorHandler {

    @ExceptionHandler(value = {ProductWithoutBuyPriceException.class, ProductWithoutSellPriceException.class})
    public ResponseEntity<Object> productWithOutPriceHandler(RuntimeException exception) {
        Logger.getLogger(String.valueOf(ErrorHandler.class)).log(Level.INFO, exception.getMessage());
        return ResponseEntity
                .badRequest()
                .body(
                        ErrorResponse.builder()
                                .error(exception.getMessage())
                                .exception(exception.getClass().toString())
                                .cause(exception.getLocalizedMessage())
                                .build()
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerGenericException(Exception exception) {
        Logger.getLogger(String.valueOf(ErrorHandler.class)).log(Level.INFO, exception.toString());
        return ResponseEntity
                .badRequest()
                .body(
                        ErrorResponse.builder()
                                .error(exception.getMessage())
                                .exception(exception.getClass().toString())
                                .cause(exception.getLocalizedMessage())
                                .build()
                );
    }

}
