package com.example.springquartzwebclient.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.springquartzwebclient.exceptions.IdInvalidFormatException;
import com.example.springquartzwebclient.exceptions.IdNotFoundException;

public class HttpUtils {

    /**
     * Pattern for extracting ID from URL.
     */
    private static final Pattern ID_PATTERN = Pattern.compile("/(\\d+)/$");
    
    private HttpUtils() {

    }

    /**
     * Extracts the ID from the given URL string.
     *
     * @param url the URL string from which to extract the ID
     * @return the extracted ID, or null if no ID is found
     */
    public static Integer extractIdFromUrl(final String url) {
        
        final Matcher matcher = ID_PATTERN.matcher(url);
        
        if (matcher.find()) {
            final String id = matcher.group(1);

            try {
                return Integer.parseInt(id);
            } catch (final NumberFormatException e) {

                throw new IdInvalidFormatException(
                    String.format("Invalid format of Id. URL is:", url),
                    e
                );
            }
        }
        
        throw new IdNotFoundException(
            String.format("No ID found in the URL: %s", url)
        );
    }

}
