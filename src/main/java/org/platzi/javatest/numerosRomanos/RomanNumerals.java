package org.platzi.javatest.numerosRomanos;

public class RomanNumerals {
    public enum NumerosRomanos {
        M(1000),
        CM(900),
        D(500),
        CD(400),
        C(100),
        XC(90),
        L(50),
        XL(40),
        X(10),
        IX(9),
        V(5),
        IV(4),
        I(1);

        private int numero;

        NumerosRomanos(int numero) {
            this.numero = numero;
        }

        public int getNumero() {
            return numero;
        }
    }

    public static String arabicToRoman(int n) {
        StringBuilder resultado = new StringBuilder();

        for (NumerosRomanos numeroRomano : NumerosRomanos.values()) {
            while (n >= numeroRomano.getNumero()) {
                resultado.append(numeroRomano.name());
                n -= numeroRomano.getNumero();
            }
        }

        return resultado.toString();
    }

}
