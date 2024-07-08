package com.mebrahim.qrcode.exceptions;

import com.google.zxing.WriterException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    protected Error handleInvalidParameters(ConstraintViolationException ex) {
        String error = ex.getConstraintViolations().stream().findFirst().orElseThrow().getMessageTemplate();
        return new Error(error);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ IOException.class, WriterException.class })
    protected Error handleImageCreationError(IOException ex) {
        String error = "An error occurred when creating the image " + ex.getMessage();
        return new Error(error);
    }

    public record Error(String error) {
    }
}
