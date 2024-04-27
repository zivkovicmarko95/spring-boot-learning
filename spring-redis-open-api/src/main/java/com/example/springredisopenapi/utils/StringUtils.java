package com.example.springredisopenapi.utils;

public class StringUtils {
    
    private StringUtils() {

    }

    /**
     * Checks if string is blank
     * 
     * @param string String to be processed
     * @return {@link Boolean} value depends on if string is blank
     */
    public static boolean isBlank(final String string) {
        return string == null || string.isBlank();
    }

    /**
     * * Checks if string is not blank
     * 
     * @param string String to be processed
     * @return {@link Boolean} value depends on if string is not blank
     */
    public static boolean isNotBlank(final String string) {
        return !isBlank(string);
    }

}
