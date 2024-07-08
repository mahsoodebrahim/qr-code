package com.mebrahim.qrcode.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.mebrahim.qrcode.constants.ErrorMessages;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidCorrectionValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCorrection {
    String message() default ErrorMessages.INVALID_CORRECTION;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
