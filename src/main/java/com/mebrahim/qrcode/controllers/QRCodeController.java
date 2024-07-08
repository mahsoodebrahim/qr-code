package com.mebrahim.qrcode.controllers;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mebrahim.qrcode.constants.MediaTypesEnum;
import com.mebrahim.qrcode.services.QRCodeService;
import com.mebrahim.qrcode.validators.QRCodeInputs;
import com.mebrahim.qrcode.validators.ValidContents;
import com.mebrahim.qrcode.validators.ValidCorrection;
import com.mebrahim.qrcode.validators.ValidImageSize;
import com.mebrahim.qrcode.validators.ValidMediaType;
import com.mebrahim.qrcode.validators.ValidationGroups.StageOneValidation;
import com.mebrahim.qrcode.validators.ValidationGroups.StageTwoValidation;
import com.mebrahim.qrcode.validators.ValidationGroups.StageThreeValidation;
import com.mebrahim.qrcode.validators.ValidationGroups.StageFourValidation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api")
@Validated(QRCodeInputs.class)
public class QRCodeController {
    private final QRCodeService qrCodeService;

    @Autowired
    public QRCodeController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @GetMapping("/health")
    public ResponseEntity<Void> getHealth() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/qrcode")
    public ResponseEntity<byte[]> getQrCode(
            @ValidContents(groups = StageOneValidation.class) @RequestParam() String contents,
            @ValidImageSize(groups = StageTwoValidation.class) @RequestParam(required = false, defaultValue = "250") Integer size,
            @ValidCorrection(groups = StageThreeValidation.class) @RequestParam(required = false, defaultValue = "L") String correction,
            @ValidMediaType(groups = StageFourValidation.class) @RequestParam(required = false, defaultValue = "png") String type)
            throws IOException, WriterException {
        BufferedImage image = qrCodeService.generateQRCode(size, contents.trim(),
                ErrorCorrectionLevel.valueOf(correction));
        var baos = new ByteArrayOutputStream();
        ImageIO.write(image, type, baos);
        byte[] bytes = baos.toByteArray();
        return ResponseEntity.ok().contentType(MediaTypesEnum.valueOf(type).getMediaType()).body(bytes);
    }
}