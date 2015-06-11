package com.xyzcorp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class SortedIntegerTest {

    @Test
    public void testAscending() {
        int result = SortedInteger.sortAscending(1234);
        assertThat(result, is(1234));
    }

    @Test
    public void testAscending3214() {
        int result = SortedInteger.sortAscending(3214);
        assertThat(result, is(1234));
    }

    @Test
    public void testAscending6789() {
        int result = SortedInteger.sortAscending(6789);
        assertThat(result, is(6789));
    }

    @Test
    public void testAscending0() {
        int result = SortedInteger.sortAscending(0);
        assertThat(result, is(0));
    }

    @Test
    public void testAscendingRepeatingNumberWithMany0s() {
        assertThat(SortedInteger.sortAscending(10101), is(111));
    }

    @Test
    public void testVariants() {
        assertThat(SortedInteger.sortAscending(333), is(333));
        assertThat(SortedInteger.sortAscending(12343), is(12334));
    }

    @Test
    public void testAscendingNeg4912() {
        try {
            SortedInteger.sortAscending(-4912);
            fail("Expected a exception to be thrown");
        } catch (Exception e) {
            assertThat(e.getMessage(), is(SortedInteger.negativeMessage));
        }
    }

    @Test
    public void testDescending() {
        int result = SortedInteger.sortDescending(1234);
        assertThat(result, is(4321));
    }

    @Test
    public void testDescending3214() {
        int result = SortedInteger.sortDescending(3214);
        assertThat(result, is(4321));
    }

    @Test
    public void testDescending6789() {
        int result = SortedInteger.sortDescending(6789);
        assertThat(result, is(9876));
    }

    @Test
    public void testDescending0() {
        int result = SortedInteger.sortDescending(0);
        assertThat(result, is(0));
    }

    @Test
    public void testDescendingRepeatingNumberWithMany0s() {
        assertThat(SortedInteger.sortDescending(10101), is(11100));
    }

    @Test
    public void testVariantsDescending() {
        assertThat(SortedInteger.sortDescending(333), is(333));
        assertThat(SortedInteger.sortDescending(12343), is(43321));
    }

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void testDescendingNeg4912() {
        ex.expect(RuntimeException.class);
        ex.expectMessage(SortedInteger.negativeMessage);
        SortedInteger.sortDescending(-4912);
    }
}
