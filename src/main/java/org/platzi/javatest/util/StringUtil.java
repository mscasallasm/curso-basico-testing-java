package org.platzi.javatest.util;

public class StringUtil {

    public static String repeat(String str, int times) {

        if (times < 0) {
            throw new IllegalArgumentException("negative times not allowed");
        }

        String result = "";

        for (int i = 0; i < times; i++) {
            result += str;
        }

        return result;
    }

    /**
    Implementa esta función, y crea una clase StringUtilTest añadiendo tests que prueben varios escenarios:
    Probar que un string cualquiera no es vacío
    Probar que “” es un string vacío
    Probar que null también es un string vacío
    Extra: un string con espacios " " también lo queremos considerar como vacío (pista: puedes usar la función trim)
    */

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
