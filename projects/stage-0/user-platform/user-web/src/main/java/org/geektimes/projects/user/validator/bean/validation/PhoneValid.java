package org.geektimes.projects.user.validator.bean.validation;

import org.geektimes.projects.user.repository.DatabaseUserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.logging.Logger;

public class PhoneValid implements ConstraintValidator<Phone, Object> {

    private static Logger logger = Logger.getLogger(PhoneValid.class.getName());
    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof String) {
            String phone = (String)value;
            int length = phone.length();
            if (length != 11) {
               logger.info("该手机号不是11位");
               return false;
            }
            if (!phone.startsWith("86")){
                logger.info("该手机号不是大陆号");
                return false;
            }

        }
        return true;
    }
}
