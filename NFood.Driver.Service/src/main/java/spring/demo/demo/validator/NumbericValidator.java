package spring.demo.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumbericValidator implements ConstraintValidator<Numberic, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext arg1) {
        return value != null && value instanceof Number;
    }

}
