package ru.yaotone;

interface Calculator extends Converter{
    default String calculate(String num1, String operation, String num2) throws IllegalArgumentException{
        int arabNum1 = convert(num1);
        int arabNum2 = convert(num2);

        int answer = 0;
        switch (operation){
            case "+" -> answer = arabNum1 + arabNum2;
            case "-" -> answer = arabNum1 - arabNum2;
            case "*" -> answer = arabNum1 * arabNum2;
            case "/" -> answer = arabNum1 / arabNum2;
            default -> throw new IllegalArgumentException("Не является арифмитическим символом");
        };
        return convert(answer);
    }
}
