package spring.demo.demo.model.mapper;

import org.modelmapper.ModelMapper;

import spring.demo.demo.entity.Driver;
import spring.demo.demo.model.dto.DriverDto;
import spring.demo.demo.model.dto.SignUpDto;

public class DriverMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static DriverDto toDriverDto(Driver driver) {
        return MODEL_MAPPER.map(driver, DriverDto.class);
    }

    public static Driver toDriverEntity(SignUpDto signUpDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return MODEL_MAPPER.map(signUpDto, Driver.class);
    }
}
