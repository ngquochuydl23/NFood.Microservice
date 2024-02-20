package spring.demo.demo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    @NonNull
    private String accessToken;
    private String tokenType = "Bearer";
}
