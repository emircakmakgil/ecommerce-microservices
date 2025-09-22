package io.github.emircakmakgil.productservice.core.exception;

import io.github.emircakmakgil.productservice.core.exception.result.BusinessExceptionResult;
import io.github.emircakmakgil.productservice.core.exception.result.ExceptionResult;
import io.github.emircakmakgil.productservice.core.exception.result.ValidationExcepitonResult;
import io.github.emircakmakgil.productservice.core.exception.type.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResult handleException(Exception e) {
        return new ExceptionResult(e.getMessage());
    }
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessExceptionResult handleRuntimeException(BusinessException  e) {
        return new BusinessExceptionResult(e.getMessage());
    }
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationExcepitonResult handleValidationException(MethodArgumentNotValidException e) {
        return new ValidationExcepitonResult(e.getBindingResult().getAllErrors().stream().map((x)->x.getDefaultMessage()).toList());
    }
}
