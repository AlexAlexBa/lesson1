package ru.alex.lesson2.snils_validator;

public class SnilsValidatorTest {
    public static void main(String[] args) {
        System.out.print("Корректный номер из условия: ");
        System.out.println(new SnilsValidatorImpl().validate("901-144-044 41"));

        System.out.print("Некорректный номер из условия: ");
        System.out.println(new SnilsValidatorImpl().validate("01468870570"));
    }
}
