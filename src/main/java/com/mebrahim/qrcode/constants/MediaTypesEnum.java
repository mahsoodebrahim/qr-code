package com.mebrahim.qrcode.constants;

import org.springframework.http.MediaType;

public enum MediaTypesEnum {
  png(Constants.PNG),
  jpeg(Constants.JPEG),
  gif(Constants.GIF);

  private final MediaType mediaType;

  MediaTypesEnum(MediaType mediaType) {
    this.mediaType = mediaType;
  }

  public MediaType getMediaType() {
    return mediaType;
  }

  private static class Constants {
    public static final MediaType PNG = MediaType.IMAGE_PNG;
    public static final MediaType JPEG = MediaType.IMAGE_JPEG;
    public static final MediaType GIF = MediaType.IMAGE_GIF;
  }
}
