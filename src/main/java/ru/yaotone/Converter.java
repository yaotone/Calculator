package ru.yaotone;

import java.util.HashMap;
import java.util.MissingFormatArgumentException;

public class Converter {

    public static int StringToInt(String number){
        if(Integer.parseInt(number) < 0){
            throw new InvalidNumberValue("Введеннная цифра слишком маленькая");
        } else if (Integer.parseInt(number) > 10) {
            throw new InvalidNumberValue("Введеннная цифра слишком большая");
        }
        else {
            return Integer.parseInt(number);
        }
    }

    public static int RomanToInt(String number){
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);

        int result = 0;
        int prevValue = 0;

        try {
            for (int i = number.length() - 1; i >= 0; i--) {
                int currentValue = romanMap.get(number.charAt(i));

                if (currentValue < prevValue) {
                    result -= currentValue;
                } else {
                    result += currentValue;
                }
                prevValue = currentValue;
            }
            if (result > 10){
                throw new InvalidNumberValue("Введенное число слишком большое");
            }
            return result;
        }
        catch (NullPointerException e){
            throw new MissingFormatArgumentException("Введенные числа не соответствуют формату");
        }

    }

    public static String intToRoman(Integer number){
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman.append(symbols[i]);
                number -= values[i];
            }
        }

        return roman.toString();
    }
}

class InvalidNumberValue extends RuntimeException{
    public InvalidNumberValue(String message){
        super(message);
    }
}