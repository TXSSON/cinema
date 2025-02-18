package com.sontxdev.cinema.exception;

import com.sontxdev.cinema.dto.response.ApiResponse;
import com.sontxdev.cinema.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException runtimeException) {
        log.error("Lỗi Runtime: ", runtimeException);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ErrorCodeEnum.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCodeEnum.UNCATEGORIZED_EXCEPTION.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

}
