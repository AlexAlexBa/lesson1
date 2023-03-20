package ru.alex.lesson2.snils_validator;

public class SnilsValidatorImpl implements SnilsValidator {
    @Override
    public boolean validate(String snils) {
        if (snils == null) {
            return false;
        }
        char[] charsArraySnils = snils.toCharArray();
        if(!checkLength(charsArraySnils)) {
            return false;
        }

        int calculatedControlNumber = 0;
        String snilsControlNumber = "";

        for (int i = 0, coefficient = 9; i < charsArraySnils.length; i++) {
            if (!Character.isDigit(charsArraySnils[i])) {
                if (!checkSeparators(charsArraySnils[i], i)) {
                    return false;
                }
            } else if (coefficient > 0) {
                calculatedControlNumber += Character.digit(charsArraySnils[i], 10) * coefficient;
                coefficient--;
            } else {
                snilsControlNumber += "" + charsArraySnils[i];
            }
        }

        return comparisonControlNumbers(calculatedControlNumber, Integer.parseInt(snilsControlNumber));
    }

    private boolean checkLength(char[] charsArraySnils) {
        return charsArraySnils.length == 11 || charsArraySnils.length == 14;
    }

    private boolean checkSeparators(char charValue, int index) {
        return (index == 3 && charValue == '-')
                || (index == 7 && charValue == '-')
                || (index == 11 && (charValue == '-' || charValue == ' '));
    }

    private boolean comparisonControlNumbers(int calculatedControlNumber, int snilsControlNumber) {
        boolean result;
        if (calculatedControlNumber < 100) {
            result = calculatedControlNumber == snilsControlNumber;
        } else if (calculatedControlNumber == 100) {
            result = 0 == snilsControlNumber;
        } else {
            result = calculatedControlNumber % 101 == snilsControlNumber;
        }
        return result;
    }
}
