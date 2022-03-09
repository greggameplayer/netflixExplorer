package com.greg.enums;

public enum MediaTypeEnum {
    Movie("Movie"),
    TVShow("TV Show");

    private final String value;

    MediaTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MediaTypeEnum fromString(String text) {
        for (MediaTypeEnum b : MediaTypeEnum.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
