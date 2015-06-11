package com.xyzcorp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTest {

    @Test
    public void testFizz() {
        assertThat(FizzBuzz.getResult(3), is("Fizz"));
    }

    @Test
    public void testBuzz() {
        assertThat(FizzBuzz.getResult(5), is("Buzz"));
    }

    @Test
    public void testFizzBuzz() {
        assertThat(FizzBuzz.getResult(15), is("FizzBuzz"));
    }

    @Test
    public void testFizzBuzz150() {
        assertThat(FizzBuzz.getResult(150), is("FizzBuzz"));
    }

    @Test
    public void testNeitherFizzNorBuzz() {
        assertThat(FizzBuzz.getResult(2), is("2"));
    }

    @Test
    public void testNeitherFizzNorBuzzWith7() {
        assertThat(FizzBuzz.getResult(7), is("7"));
    }

    @Test
    public void testNeitherFizzNorBuzzWith8() {
        assertThat(FizzBuzz.getResult(8), is("8"));
    }



    //Integer.toString(int)
    //mvn clean cobertura:cobertura
}
