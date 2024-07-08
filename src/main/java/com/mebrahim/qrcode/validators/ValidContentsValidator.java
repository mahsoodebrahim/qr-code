package com.mebrahim.qrcode.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidContentsValidator implements ConstraintValidator<ValidContents, String> {
    @Override
    public boolean isValid(String contents, ConstraintValidatorContext ctx) {
        return contents != null && !contents.isEmpty() && !contents.isBlank();
    }
}
