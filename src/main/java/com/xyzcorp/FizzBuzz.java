package com.xyzcorp;

/**
 * @author Daniel Hinojosa
 * @since 6/9/15 3:24 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class FizzBuzz {
    public static String getResult(int i) {
        if (i % 3 == 0 && i % 5 == 0) return "FizzBuzz";
        else if (i % 3 == 0) return "Fizz";
        else if (i % 5 == 0) return "Buzz";
        return Integer.toString(i);
    }
}
