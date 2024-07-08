package com.mebrahim.qrcode.validators;

import jakarta.validation.GroupSequence;
import com.mebrahim.qrcode.validators.ValidationGroups.StageOneValidation;
import com.mebrahim.qrcode.validators.ValidationGroups.StageTwoValidation;
import com.mebrahim.qrcode.validators.ValidationGroups.StageThreeValidation;
import com.mebrahim.qrcode.validators.ValidationGroups.StageFourValidation;

@GroupSequence({ StageOneValidation.class, StageTwoValidation.class, StageThreeValidation.class,
    StageFourValidation.class })
public interface QRCodeInputs {
}
