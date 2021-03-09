package org.geektimes.projects.user.validator.bean.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValid.class)
public @interface Password {
    String message() default "密码校验失败";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
