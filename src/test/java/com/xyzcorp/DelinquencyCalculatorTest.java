package com.xyzcorp;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;

public class DelinquencyCalculatorTest {

    @Test
    public void testDelinquencyRate() {
        DelinquencyCalculator calc =
                new DelinquencyCalculator
                        (LocalDate.of(2015, 6, 12), .30);
        double result = calc.calculateRate
                (LocalDate.of(2014, 6, 12));
        Assert.assertThat(result, is(closeTo(.30 * 12, .02)));
    }
}
