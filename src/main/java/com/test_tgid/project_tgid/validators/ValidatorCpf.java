package com.test_tgid.project_tgid.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorCpf {
    private static final String CPF_REGEX = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";

    public static boolean isCpf(String cpf) {
        Pattern pattern = Pattern.compile(CPF_REGEX);
        Matcher matcher = pattern.matcher(cpf);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
    
}