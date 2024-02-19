package spring.demo.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SigninDto {
    @NotEmpty
    @NotNull
    @NotBlank
    private String phone;
    @NotEmpty
    @NotNull
    @NotBlank
    private String password;
}
