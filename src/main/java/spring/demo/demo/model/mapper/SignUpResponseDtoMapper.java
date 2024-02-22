package spring.demo.demo.model.mapper;

import org.modelmapper.ModelMapper;

import spring.demo.demo.model.dto.SignUpDto;
import spring.demo.demo.model.dto.SignUpResponseDto;

public class SignUpResponseDtoMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static SignUpResponseDto toSignUpResponseDto(SignUpDto signUpDto) {
        return MODEL_MAPPER.map(signUpDto, SignUpResponseDto.class);
    }
}
