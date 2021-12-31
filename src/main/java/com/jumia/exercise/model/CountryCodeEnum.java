package com.jumia.exercise.model;

/**
 * CountryCodeEnum has the available country codes and its regex
 */
public enum CountryCodeEnum {
    CAMEROON("237","\\(237\\)\\ ?[2368]\\d{7,8}$"),
    ETHIOPIA("251","\\(251\\)\\ ?[1-59]\\d{8}$"),
    MOROCCO("212","\\(212\\)\\ ?[5-9]\\d{8}$"),
    MOZAMBIQUE("258","\\(258\\)\\ ?[28]\\d{7,8}$"),
    UGANDA("256","\\(256\\)\\ ?\\d{9}$");

    private final String code;
    private final String regex;

    CountryCodeEnum(String code, String regex) {
        this.code = code;
        this.regex = regex;
    }

    public static CountryCodeEnum findByCode(String code){
        for(CountryCodeEnum country : values()){
            if(country.code.equals(code)){
                return country;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getRegex(){
        return regex;
    }
}
