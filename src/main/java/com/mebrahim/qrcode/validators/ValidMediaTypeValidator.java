package com.mebrahim.qrcode.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.mebrahim.qrcode.constants.MediaTypesEnum;

public class ValidMediaTypeValidator implements ConstraintValidator<ValidMediaType, String> {
    @Override
    public boolean isValid(String type, ConstraintValidatorContext ctx) {
        try {
            MediaTypesEnum.valueOf(type);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
