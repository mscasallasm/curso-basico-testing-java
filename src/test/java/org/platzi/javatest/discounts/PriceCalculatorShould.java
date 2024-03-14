package org.platzi.javatest.discounts;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriceCalculatorShould {

    @Test
    public void total_zero_when_there_are_price() {
        PriceCalculator calculator = new PriceCalculator();
        // Ejemplo usado en la clase, pero assertThat esta deprecate
        // assertThat(calculator.getTotal(), is(0.0));
        assertEquals(0, calculator.getTotal(), 0.10);
    }

    @Test
    public void total_is_the_sum_of_prices() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);

        assertEquals(25.7, calculator.getTotal(), 0.10);
    }


    @Test
    public void apply_discount_to_prices() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50);

        calculator.setDiscount(25);

        assertEquals(150.0, calculator.getTotal(), 0.10);
    }
}