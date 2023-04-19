package ru.alex.lesson3.password_validator;

public class PasswordValidatorTest {
    public static void main(String[] args) {

        System.out.println("Корректный ввод: "
                + validation("login123", "pass_123456", "pass_123456"));
        System.out.println();

        System.out.println(validation("login!", "pass_123456", "pass_123456"));
        System.out.println();

        System.out.println(validation("login789101214161820", "pass_123456", "pass_123456"));
        System.out.println();

        System.out.println(validation("login", "!pass_123456", "pass_123456"));
        System.out.println();

        System.out.println(validation("login", "pass_6789101214161820", "pass_123456"));
        System.out.println();

        System.out.println(validation("login", "pass_123456", "password"));
    }

    private static boolean validation(String login, String password, String confirmPassword) {
        boolean result = true;
        try {
            if (!login.matches("[a-zA-Z0-9_]*")) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            }
            if (login.length() >= 20) {
                throw new WrongLoginException("Логин слишком длинный");
            }
            if (!password.matches("[a-zA-Z0-9_]*")) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            }
            if (password.length() >= 20) {
                throw new WrongLoginException("Пароль слишком длинный");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль и подтверждение не совпадают");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            result = false;
        }
        return result;
    }
}
