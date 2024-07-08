package com.mebrahim.qrcode.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidImageSizeValidator implements ConstraintValidator<ValidImageSize, Integer> {
    @Override
    public void initialize(ValidImageSize imageSize) {

    }

    @Override
    public boolean isValid(Integer size, ConstraintValidatorContext ctx) {
        return size != null && size >= 150 && size <= 350;
    }
}
