package com.app.coreservice.utils;

public class GeneralUtils {

    public static String sanitize(String value) {
        return value == null ? null : value.trim();
    }

    public static boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static <T extends Enum<T>> boolean isValidEnum(String value, Class<T> enumClass) {

        if (isNullOrBlank(value)) {
            return false;
        }

        for (T enumValue : enumClass.getEnumConstants()) {
            if (enumValue.name().equalsIgnoreCase(value)) {
                return true;
            }
        }

        return false;
    }
}