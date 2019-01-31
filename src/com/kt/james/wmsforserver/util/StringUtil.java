package com.kt.james.wmsforserver.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

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

    public static String ReadAsChars(HttpServletRequest request)
    {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

}
