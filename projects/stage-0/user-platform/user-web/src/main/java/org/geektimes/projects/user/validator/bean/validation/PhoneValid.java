package org.geektimes.projects.user.validator.bean.validation;

import org.geektimes.projects.user.repository.DatabaseUserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValid implements ConstraintValidator<Phone, Object> {

    private static Logger logger = Logger.getLogger(PhoneValid.class.getName());
    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof String) {
            String phone = (String)value;
            String regExp = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])" +
                    "|(18[0-9])|(19[8,9]))\\d{8}$";
            Pattern p = Pattern.compile(regExp);
            boolean isPhone = p.matcher(phone).matches();
            if (!isPhone){
                logger.info("该手机号不是大陆号");
                return false;
            }
        }
        return true;
    }
}
