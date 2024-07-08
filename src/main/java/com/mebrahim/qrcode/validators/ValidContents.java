package com.mebrahim.qrcode.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.mebrahim.qrcode.constants.ErrorMessages;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidContentsValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidContents {
    String message() default ErrorMessages.INVALID_CONTENTS;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
