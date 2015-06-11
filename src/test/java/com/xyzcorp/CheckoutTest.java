package com.xyzcorp;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Daniel Hinojosa
 * @since 6/10/15 2:36 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class CheckoutTest {

    @Test
    public void testCheckoutCreation() {
        Member member = new Member(2L, "Ed", "Simpson");
        Book book = new Book(4L, "Star Wars the Musical");
        LocalDate checkoutDate = LocalDate.of(2012, 1, 13);
        Checkout checkout =
                new Checkout(member, book, checkoutDate);
        assertThat(checkout.getMember(), is(member));
        assertThat(checkout.getBook(), is(book));
        assertThat(checkout.getCheckoutDate(), is(checkoutDate));
    }
}
