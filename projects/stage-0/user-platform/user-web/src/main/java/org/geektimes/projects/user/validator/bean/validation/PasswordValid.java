package org.geektimes.projects.user.validator.bean.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.logging.Logger;

public class PasswordValid implements ConstraintValidator<Password, Object> {

    private static Logger logger = Logger.getLogger(PasswordValid.class.getName());
    @Override
    public void initialize(Password constraintAnnotation) {

    }
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof String) {
            String password = (String)value;
            int length = password.length();
            if (length < 6 || length > 32) {
               logger.info("密码不属于6~32位");
               return false;
            }

        }
        return true;
    }
}
