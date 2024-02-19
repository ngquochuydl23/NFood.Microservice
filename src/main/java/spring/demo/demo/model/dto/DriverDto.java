package spring.demo.demo.model.dto;

import lombok.Data;

@Data
public class DriverDto {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String email;
    private String phone;
    private String avatar;
    private String imgIdCardBefore;
    private String imgIdCardAfter;
    private DriverLicenseDto numberDriverLicense;
    private VehicleDto licensePlates;
}
