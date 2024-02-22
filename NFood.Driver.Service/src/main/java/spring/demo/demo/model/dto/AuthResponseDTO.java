package spring.demo.demo.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthResponseDto extends BaseResponseDto<DriverDto> {
    private String accessToken;

}
