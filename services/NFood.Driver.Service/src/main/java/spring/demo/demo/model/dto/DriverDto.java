package spring.demo.demo.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DriverDto {
    private long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String address;
    private String email;
    private String phone;
    private String avatar;
}
