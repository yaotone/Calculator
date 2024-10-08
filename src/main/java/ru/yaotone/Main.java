package ru.yaotone;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите выражение");

        String number1 = input.next();
        String operation = input.next();
        String number2 = input.next();

        String answer = Calculator.calculate(number1, operation, number2);
        System.out.println(answer);

        input.close();
    }
}

