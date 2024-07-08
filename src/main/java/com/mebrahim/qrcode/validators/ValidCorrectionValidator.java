package com.mebrahim.qrcode.validators;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCorrectionValidator implements ConstraintValidator<ValidCorrection, String> {
    @Override
    public boolean isValid(String correction, ConstraintValidatorContext ctx) {
        try {
            ErrorCorrectionLevel.valueOf(correction);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
