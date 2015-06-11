package com.xyzcorp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class NumberChainTest {
    @Test
    public void testNumberChainWith0() {
        NumberChain chain = new NumberChain(0);
        assertThat(chain.length(), is(2));
    }

    @Test
    public void testNumberChainWith1() {
        NumberChain chain = new NumberChain(1);
        assertThat(chain.length(), is(2));
    }

    @Test
    public void testNumberChainWith1234() {
        NumberChain chain = new NumberChain(1234);
        assertThat(chain.length(), is(4));
    }

    @Test
    public void testNumberChainWith123456789() {
        NumberChain chain = new NumberChain(123456789);
        assertThat(chain.length(), is(2));
    }
}
