package com.xyzcorp;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Random;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DieTest {

    @Test
    @Category(value = UnitTest.class)
    public void testDieDefaultIsDieDefaultPip() {
        Random dieStub = new Random() {
            @Override
            public int nextInt(int bound) {
                fail("This should not be called");
                return 4;
            }
        };
        Die die = new Die(dieStub);
        assertThat(die.getPip(), is(Die.defaultPip));
    }

    @Test
    @Category(value = UnitTest.class)
    public void testARollWillBe4() {
        Random dieStub = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };

        Die die = new Die(dieStub);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPip(), is(4));
    }

    @Test
    @Category(value = UnitTest.class)
    public void testARollWillBe6andWillAlwaysBeA6() {
        Random dieStub = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };

        Die die = new Die(dieStub);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPip(), is(6));
        assertThat(rolledDie.getPip(), is(6));
        assertThat(rolledDie.getPip(), is(6));
        assertThat(rolledDie.getPip(), is(6));
    }

    @Test
    public void testBUG30201() {
        //import static org.mockito.Mockito.*;

        //1. Setup mock
        Random random = mock(Random.class);

        //2. Setup expectations
        when(random.nextInt(6)).thenReturn(4);

        //3. Run Test against: Subject Under Test
        Die die = new Die(random);
        assertThat(die.roll().getPip(), is(5));
    }

    @Test
    public void testBUG30204() {
        //import static org.mockito.Mockito.*;

        //1. Setup mock
        Random random = mock(Random.class);

        //2. Setup expectations
        when(random.nextInt(6)).thenReturn(0);

        //3. Run Test against: Subject Under Test
        Die die = new Die(random);
        assertThat(die.roll().getPip(), is(1));
    }

    @Test
    @Category(value = IntegrationTest.class)
    public void testIntegrationTestWithRealRandom(){
        Die die = new Die(new Random());
        for (int i = 0; i < 10000; i++) {
            int actualPip = die.roll().getPip();
            assertTrue("Pip was " + actualPip, actualPip > 0);
            assertTrue("Pip was " + actualPip, actualPip < 7);
        }
    }

    @Test
    @Category(value= UnitTest.class)
    public void testThatItCantAcceptNullRandom() {
        try {
            new Die(null);
            fail("Expected Null Pointer Exception");
        } catch (NullPointerException e) {
            assertThat(e.getMessage(), is("A Random is required"));
        }
    }
}
