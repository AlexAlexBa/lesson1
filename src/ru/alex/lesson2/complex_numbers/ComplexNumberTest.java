package ru.alex.lesson2.complex_numbers;

public class ComplexNumberTest {
    public static void main(String[] args) {
        ComplexNumber complexNumber1 = new ComplexNumber(5.6);
        ComplexNumber complexNumber2 = new ComplexNumber(-15.6, 4.9);

        ComplexNumber result = complexNumber1.addition(complexNumber2);
        System.out.println("Результат сложения: " + result);

        result = complexNumber1.subtraction(complexNumber2);
        System.out.println("Результат вычитания: " + result);

        result = complexNumber1.multiplication(complexNumber2);
        System.out.println("Результат умножения: " + result);

        double module = complexNumber1.module();
        System.out.println("Модуль первого числа: " + module);

        module = complexNumber2.module();
        System.out.println("Модуль второго числа: " + module);
    }
}
