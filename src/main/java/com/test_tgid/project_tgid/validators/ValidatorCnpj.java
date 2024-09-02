package com.test_tgid.project_tgid.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorCnpj {
	private static final String CNPJ_REGEX = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$";

    public static boolean isCnpj(String cnpj) {
        Pattern pattern = Pattern.compile(CNPJ_REGEX);
        Matcher matcher = pattern.matcher(cnpj);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
