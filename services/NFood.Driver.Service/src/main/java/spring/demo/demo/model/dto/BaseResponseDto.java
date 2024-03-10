package spring.demo.demo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponseDto<T> {
    protected int statusCode;
    protected String message;
    protected T result;

}
