package org.platzi.javatest.numerosRomanos;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralsTest {

    @Test
    public void roman_number_when_1() {
        assertEquals("I",RomanNumerals.arabicToRoman(1));
    }

    @Test
    public void roman_number_when_2() {
        assertEquals("II",RomanNumerals.arabicToRoman(2));
    }

    @Test
    public void roman_number_when_3() {
        assertEquals("III",RomanNumerals.arabicToRoman(3));
    }

    @Test
    public void roman_number_when_5() {
        assertEquals("V",RomanNumerals.arabicToRoman(5));
    }

    @Test
    public void roman_number_when_6() {
        assertEquals("VI",RomanNumerals.arabicToRoman(6));
    }

    @Test
    public void roman_number_when_7() {
        assertEquals("VII",RomanNumerals.arabicToRoman(7));
    }

    @Test
    public void roman_number_when_10() {
        assertEquals("X",RomanNumerals.arabicToRoman(10));
    }

    @Test
    public void roman_number_when_11() {
        assertEquals("XI",RomanNumerals.arabicToRoman(11));
    }

    @Test
    public void roman_number_when_15() {
        assertEquals("XV",RomanNumerals.arabicToRoman(15));
    }

    @Test
    public void roman_number_when_16() {
        assertEquals("XVI",RomanNumerals.arabicToRoman(16));
    }

    @Test
    public void roman_number_when_50() {
        assertEquals("L",RomanNumerals.arabicToRoman(50));
    }

    @Test
    public void roman_number_when_51() {
        assertEquals("LI",RomanNumerals.arabicToRoman(51));
    }

    @Test
    public void roman_number_when_55() {
        assertEquals("LV",RomanNumerals.arabicToRoman(55));
    }

    @Test
    public void roman_number_when_56() {
        assertEquals("LVI",RomanNumerals.arabicToRoman(56));
    }

    @Test
    public void roman_number_when_60() {
        assertEquals("LX",RomanNumerals.arabicToRoman(60));
    }

    @Test
    public void roman_number_when_70() {
        assertEquals("LXX",RomanNumerals.arabicToRoman(70));
    }

    @Test
    public void roman_number_when_80() {
        assertEquals("LXXX",RomanNumerals.arabicToRoman(80));
    }

    @Test
    public void roman_number_when_81() {
        assertEquals("LXXXI",RomanNumerals.arabicToRoman(81));
    }

    @Test
    public void roman_number_when_85() {
        assertEquals("LXXXV",RomanNumerals.arabicToRoman(85));
    }

    @Test
    public void roman_number_when_86() {
        assertEquals("LXXXVI",RomanNumerals.arabicToRoman(86));
    }

    @Test
    public void roman_number_when_126() {
        assertEquals("CXXVI",RomanNumerals.arabicToRoman(126));
    }

    @Test
    public void roman_number_when_2507() {
        assertEquals("MMDVII",RomanNumerals.arabicToRoman(2507));
    }

    @Test
    public void roman_number_when_4() {
        assertEquals("IV",RomanNumerals.arabicToRoman(4));
    }

    @Test
    public void roman_number_when_9() {
        assertEquals("IX",RomanNumerals.arabicToRoman(9));
    }

    @Test
    public void roman_number_when_14() {
        assertEquals("XIV",RomanNumerals.arabicToRoman(14));
    }

    @Test
    public void roman_number_when_19() {
        assertEquals("XIX",RomanNumerals.arabicToRoman(19));
    }

    @Test
    public void roman_number_when_24() {
        assertEquals("XXIV",RomanNumerals.arabicToRoman(24));
    }

    @Test
    public void roman_number_when_40() {
        assertEquals("XL",RomanNumerals.arabicToRoman(40));
    }

    @Test
    public void roman_number_when_49() {
        assertEquals("XLIX",RomanNumerals.arabicToRoman(49));
    }

    @Test
    public void roman_number_when_90() {
        assertEquals("XC",RomanNumerals.arabicToRoman(90));
    }

    @Test
    public void roman_number_when_99() {
        assertEquals("XCIX",RomanNumerals.arabicToRoman(99));
    }

    @Test
    public void roman_number_when_400() {
        assertEquals("CD",RomanNumerals.arabicToRoman(400));
    }

    @Test
    public void roman_number_when_900() {
        assertEquals("CM",RomanNumerals.arabicToRoman(900));
    }

}