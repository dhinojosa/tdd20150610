package com.xyzcorp;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Daniel Hinojosa
 * @since 6/10/15 3:48 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class DelinquencyCalculator {
    private final LocalDate currentDate;
    private final double penalty;

    public DelinquencyCalculator(LocalDate currentDate,
                                 double penalty) {
        this.currentDate = currentDate;
        this.penalty = penalty;
    }

    public double calculateRate(LocalDate checkoutDate) {
        return Period.between(checkoutDate, currentDate)
                .toTotalMonths() * penalty;
    }
}
