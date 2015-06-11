package com.xyzcorp;

import com.google.common.collect.Lists;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Daniel Hinojosa
 * @since 6/10/15 3:40 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class MemberDeserializer {

    private final DelinquencyCalculator delinquencyCalculator;

    public MemberDeserializer(DelinquencyCalculator delinquencyCalculator) {
        this.delinquencyCalculator = delinquencyCalculator;
    }

    public List<String> deserialize(Member member) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        List<String> result = Lists.newArrayList();
        String header =
                member.getFirstName() + " " + member.getLastName() + " owes ";

        for (Checkout checkout: member.getCheckouts()) {
            result.add(header + format.format(delinquencyCalculator.calculateRate(
                    checkout.getCheckoutDate()))
                    + " for " + checkout.getBook().getTitle());
        }
        return result;
    }
}
