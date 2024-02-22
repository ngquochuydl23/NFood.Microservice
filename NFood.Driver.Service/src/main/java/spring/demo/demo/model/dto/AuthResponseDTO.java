package spring.demo.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import spring.demo.demo.entity.Driver;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthResponseDto extends BaseResponseDto<DriverDto> {
    private String accessToken;

}
