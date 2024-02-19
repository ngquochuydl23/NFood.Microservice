package spring.demo.demo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.demo.demo.repository.DriverLicenseRepository;
import spring.demo.demo.repository.DriverRepository;
import spring.demo.demo.repository.VehicleRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueValidator implements ConstraintValidator<Unique, String> {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private DriverLicenseRepository driverLicenseRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    private String fieldName;

    @Override
    public void initialize(Unique constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext arg1) {
        if (this.fieldName.equals("phone"))
            return value != null && (!driverRepository.existsByPhone(value));

        if (this.fieldName.equals("licensePlates"))
            return value != null && (!vehicleRepository.existsByLicensePlates(value));

        if (this.fieldName.equals("numberDriverLicense"))
            return value != null && (!driverLicenseRepository.existsByNumberDriverLicense(value));
        return true;
    }

}
