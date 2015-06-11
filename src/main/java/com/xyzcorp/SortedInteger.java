package com.xyzcorp;

import java.util.Arrays;

public class SortedInteger {

    protected static String negativeMessage =
            "No negatives allowed";

    public static int sortAscending(int value) {
        validateInput(value);
        return Integer.parseInt(
                String.valueOf(getSortedCharArray(value)));
    }

    private static void validateInput(int value) {
        if (value < 0) {
            throw new
                    RuntimeException(negativeMessage);
        }
    }

    public static int sortDescending(int value) {
        validateInput(value);
        StringBuilder sb =
                new StringBuilder(
                        String.valueOf(getSortedCharArray(value)));
        return Integer.parseInt(sb.reverse().toString());
    }

    private static char[] getSortedCharArray(int value) {
        char[] array = String.valueOf(value).toCharArray();
        Arrays.sort(array);
        return array;
    }
}
