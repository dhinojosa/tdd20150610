package com.xyzcorp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Daniel Hinojosa
 * @since 6/10/15 3:34 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class DeserializeMemberTest {

    @Test
    public void testDeserializer() {
        Member member = new Member(20L, "Janice", "Goodley");
        Book book1 = new Book(40L, "A Song of Fire and Ice");
        Book book2 = new Book(44L, "Rejects");
        member.addCheckout(
                new Checkout(member, book1,
                        LocalDate.of(2015, 3, 10)));
        member.addCheckout(
                new Checkout(member, book2,
                        LocalDate.of(2015, 4, 10)));

        DelinquencyCalculator delinquencyCalculator =
                mock(DelinquencyCalculator.class);

        when(delinquencyCalculator.calculateRate(LocalDate.of(2015, 3, 10))).thenReturn(.90);
        when(delinquencyCalculator.calculateRate(LocalDate.of(2015, 4, 10))).thenReturn(.60);

        MemberDeserializer memberDeserializer =
                new MemberDeserializer(delinquencyCalculator);

        List<String> output = memberDeserializer.deserialize(member);
        assertThat(output.get(0), is("Janice Goodley owes $0.90 for A Song of Fire and Ice"));
        assertThat(output.get(1), is("Janice Goodley owes $0.60 for Rejects"));
    }
}
