package com.example.hexagonal.infrastructure.handler;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {
    public final String error;
    public final String exception;
    public final String cause;
}
