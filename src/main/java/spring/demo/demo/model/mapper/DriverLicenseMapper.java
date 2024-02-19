package spring.demo.demo.model.mapper;

import org.modelmapper.ModelMapper;

import spring.demo.demo.entity.DriverLicense;
import spring.demo.demo.model.dto.DriverLicenseDto;

public class DriverLicenseMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static DriverLicenseDto toDriverLicenseDto(DriverLicense driverLicense) {
        return MODEL_MAPPER.map(driverLicense, DriverLicenseDto.class);
    }

    public static DriverLicense toDriverLicenseEntity(Object driverLicense) {
        return MODEL_MAPPER.map(driverLicense, DriverLicense.class);
    }
}
