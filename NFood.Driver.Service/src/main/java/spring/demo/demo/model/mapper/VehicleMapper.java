package spring.demo.demo.model.mapper;

import org.modelmapper.ModelMapper;

import spring.demo.demo.entity.Vehicle;
import spring.demo.demo.model.dto.SignUpDto;
import spring.demo.demo.model.dto.VehicleDto;

public class VehicleMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static VehicleDto toVehicleDto(Vehicle vehicle){
        return MODEL_MAPPER.map(vehicle, VehicleDto.class);
    }

    public static Vehicle toVehicleEntity(SignUpDto signUpDto){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return MODEL_MAPPER.map(signUpDto, Vehicle.class);
    }
}
