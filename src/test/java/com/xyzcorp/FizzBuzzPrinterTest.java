package com.xyzcorp;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Daniel Hinojosa
 * @since 6/9/15 3:53 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class FizzBuzzPrinterTest {

    @Test
    public void testPrinter() {
        String result =
                FizzBuzzPrinter.print(4);
        String expected = "1\n" +
                          "2\n" +
                          "Fizz\n" +
                          "4\n";
        assertThat(result, is(expected));

    }
}
