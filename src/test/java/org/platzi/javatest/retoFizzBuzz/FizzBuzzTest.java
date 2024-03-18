package org.platzi.javatest.retoFizzBuzz;

import org.junit.Test;
import org.platzi.javatest.util.PasswordUtil;

import static org.junit.Assert.*;
import static org.platzi.javatest.util.PasswordUtil.SecurityLevel.MEDIUM;

public class FizzBuzzTest {

    @Test
    public void fizz_when_number_is_divisible_by_3() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
    }

    @Test
    public void buzz_when_number_is_divisible_by_5() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    public void FizzBuzz_when_number_is_divisible_by_3_and_5() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

    @Test
    public void number_when_number_is_not_divisible_by_3_and_5() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
        assertEquals("16", FizzBuzz.fizzBuzz(16));
    }
}