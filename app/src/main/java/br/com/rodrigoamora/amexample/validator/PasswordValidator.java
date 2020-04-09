package br.com.rodrigoamora.amexample.validator;

public class PasswordValidator {
    public static boolean validate(String password) {
        Boolean result = true;

        if (!password.contains("@")) {
            result = false;
        } else {
            String dominio = password.split("@")[1];
            dominio = dominio.split(".")[0];
            if (dominio.isEmpty()) {
                result = false;
            }
        }

        if (!password.contains(".com")) {
            result = false;
        }

        return result;
    }
}
