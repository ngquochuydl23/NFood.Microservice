package spring.demo.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException {

    public AppException(String message) {
        super(message);
    }
}
