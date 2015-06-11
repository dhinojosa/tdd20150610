package com.xyzcorp;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Random;
import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LambdaDieTest {
    @Test
    @Category(value = UnitTest.class)
    public void testARollWillBe4() {
        LambdaDie die = new LambdaDie(() -> 4);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPip(), is(4));
    }

    @Test
    @Category(value = IntegrationTest.class)
    public void testIntegrationWithJavaUtilRandom() {
        Random random = new Random();
        LambdaDie die = new LambdaDie(() -> random.nextInt(6) + 1 );
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPip(), is(4));
    }
}
