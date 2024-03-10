package spring.demo.demo.model.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import spring.demo.demo.validator.Unique;

public class SignUpResponseDto {
    @NotNull
    @NotBlank
    @NotEmpty
    private String firstName;

    @NotNull
    @NotBlank
    @NotEmpty
    private String lastName;

    @NotNull
    private Date birthDate;

    @NotNull
    private String address;

    @Email
    @NotNull
    private String email;

    @NotNull
    @Unique(message = "Phone number already exists", fieldName = "phone")
    @Pattern(regexp = "((09|03|07|08|05)+([0-9]{8})\\b)", message = "Invalid phone number")
    private String phone;

    @NotNull
    private String avatar;

    @NotNull
    private String imgIdentifyCardBefore;
    @NotNull
    private String imgIdentityCardAfter;
    // Vehicle Field
    @NotNull
    @Unique(message = "License plate already exists", fieldName = "licensePlates")
    private String licensePlates;

    @NotNull
    private String vehicleName;
    @NotNull
    private String brand;
    @NotNull
    private String color;
    @NotNull
    private String imgVehicle;
    @NotNull
    private String certification;
    @NotNull
    private String insurance;
    // Drvier License Field
    @NotNull
    @Unique(message = "Number driver lincense already exists", fieldName = "numberDriverLicense")
    private String numberDriverLicense;

    @NotNull
    private String tier;
    @NotNull
    private String imgLicense;

}
