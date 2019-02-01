package br.com.dodivargas.dataAnalytics.util;


public class StringUtils {

    public static boolean isNotBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return false;
        }
        for (int i = 0; i < strLen; i++) {
            if ((!Character.isWhitespace(str.charAt(i)))) {
                return true;
            }
        }
        return false;
    }
}