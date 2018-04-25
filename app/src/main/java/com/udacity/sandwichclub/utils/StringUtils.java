package com.udacity.sandwichclub.utils;

import android.content.Context;
import android.text.TextUtils;

import com.udacity.sandwichclub.R;

import java.util.List;

/**
 * Utilities for displaying Strings and Lists of Strings
 */
public class StringUtils {

    /**
     * Ensures that missing data will be displayed nicely. Replaces empty string and null string
     * with a string indicating that the data is not available.
     *
     * @param value The string value being displayed.
     * @param context A context from which string resources can be read.
     * @return a string suitable for display.
     */
    public static String getNonEmptyString(String value, Context context) {
        return TextUtils.isEmpty(value) ? context.getResources().getString(R.string.no_data) : value;
    }

    /**
     * Converts a list of strings into a single, comma-separated string. Needed due to lack of
     * support for StringJoiner in older API versions.
     *
     * @param list A List of Strings to be joined.
     * @return a single, comma-separated string, or the empty string if the list was empty.
     */
    public static String listToString(List<String> list) {
        StringBuilder buffer = new StringBuilder();
        boolean first = true;
        for (String item : list) {
            if (first) {
                first = false;
            } else {
                buffer.append(", ");
            }
            buffer.append(item);
        }
        return buffer.toString();
    }
}
