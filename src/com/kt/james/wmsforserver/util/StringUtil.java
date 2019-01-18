package com.kt.james.wmsforserver.util;

public class StringUtil {

    public static boolean isEmpty(CharSequence text) {
        return text == null || text.length() == 0;
    }

    public Integer parseInt(String value) {
        Integer integer = null;
        try {
            integer = Integer.parseInt(value);
        } catch (NumberFormatException e) {

        }
        return integer;
    }

}
