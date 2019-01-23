package com.kt.james.wmsforserver.util;

public class StringUtil {

    public static boolean isEmpty(CharSequence text) {
        return text == null || text.length() == 0;
    }

    public static Integer parseInt(String value) {
        Integer integer = null;
        try {
            integer = Integer.parseInt(value);
        } catch (NumberFormatException e) {

        }
        return integer;
    }

    public static Float parseFloat(String value) {
        Float result = null;
        try {
            result = Float.parseFloat(value);
        } catch (Exception e) {

        }
        return result;

    }

}
