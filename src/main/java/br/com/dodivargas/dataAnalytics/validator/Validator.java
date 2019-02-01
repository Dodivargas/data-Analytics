package br.com.dodivargas.dataAnalytics.validator;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class Validator {

    private static final String EXPRESSION_IS_SALESMAN = "^(001)ç([0-9]{13})ç([\\s\\S]+)ç([0-9]*\\.?[0-9]+)";

    private static final String EXPRESSION_IS_CUSTOMER = "^(002)ç([0-9]{16})ç([\\s\\S]+)ç([\\s\\S]+)";

    private static final String EXPRESSION_IS_SALE = "^(003)ç([0-9]{0,})ç(\\[[0-9\\-\\,\\.]+\\])ç([\\s\\S]+)";

    public static boolean isCustomer(String line) {
        Pattern pattern = Pattern.compile(EXPRESSION_IS_CUSTOMER);
        return pattern.matcher(line).find();
    }

    public static boolean isSale(String line) {
        Pattern pattern = Pattern.compile(EXPRESSION_IS_SALE);
        return pattern.matcher(line).find();
    }

    public static boolean isSalesMan(String line) {
        Pattern pattern = Pattern.compile(EXPRESSION_IS_SALESMAN);
        return pattern.matcher(line).find();
    }
}