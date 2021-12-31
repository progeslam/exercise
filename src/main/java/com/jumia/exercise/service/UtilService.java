package com.jumia.exercise.service;

import com.jumia.exercise.model.CountryCodeEnum;

import java.util.regex.Pattern;

public class UtilService {

    /**
     * validateNumbers against country code regex
     * @param phoneNumber user phone number as a String
     * @param code Country code to validate with
     * @return True if and only if the Country regex matches the phone number, other than that returns False
     */
    public static Boolean validateNumbers(String phoneNumber, CountryCodeEnum code) {
        Pattern p = Pattern.compile(code.getRegex());
        return p.matcher(phoneNumber).matches();
    }
}
