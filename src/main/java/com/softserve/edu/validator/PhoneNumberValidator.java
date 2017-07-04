package com.softserve.edu.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhone, Object> {
    public void initialize(ValidPhone validPhone) {
    }

    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o == null || o.equals(""))
            return true;
        Pattern pattern = Pattern.compile("(\\+38)?\\d{3}-?\\d{3}-?\\d{2}-?\\d{2}-?");
        Matcher matcher = pattern.matcher((String) o);
        return matcher.matches();
    }
}
