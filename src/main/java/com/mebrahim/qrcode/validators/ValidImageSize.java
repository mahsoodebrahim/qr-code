package com.mebrahim.qrcode.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.mebrahim.qrcode.constants.ErrorMessages;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidImageSizeValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidImageSize {
    String message() default ErrorMessages.INVALID_IMAGE_SIZE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
