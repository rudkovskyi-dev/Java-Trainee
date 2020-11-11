package dev.rudkovskyi.mvc.controller;

public interface RegexPattern {
    // Default name, password, phone
    String REGEX_NAME = "^[A-Z][a-z]{1,20}$";
    String REGEX_NICKNAME = "^[A-Za-z0-9_-]{8,20}$";
    String REGEX_PHONE = "^(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]{8,14}$";
    // UA name
    String UA_REGEX_NAME = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";

}
