package br.com.rodrigoamora.amexample.validator;

public class EmailValidator {

    public static boolean validate(String email) {
        Boolean result = true;

        if (!email.contains("@")) {
            result = false;
        } else {
            String dominio = email.split("@")[1];
            dominio = dominio.split(".")[0];
            if (dominio.isEmpty()) {
                result = false;
            }
        }

        if (!email.contains(".com")) {
            result = false;
        }

        return result;
    }
}
