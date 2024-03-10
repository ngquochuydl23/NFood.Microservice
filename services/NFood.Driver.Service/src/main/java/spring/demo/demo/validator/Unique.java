package spring.demo.demo.validator;

import javax.validation.Payload;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
    String message() default "Value must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();
}
