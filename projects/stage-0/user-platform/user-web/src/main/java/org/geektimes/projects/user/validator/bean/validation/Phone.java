package org.geektimes.projects.user.validator.bean.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValid.class)
public @interface Phone {
    String message() default "手机号校验失败";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
