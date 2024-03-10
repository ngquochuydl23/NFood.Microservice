package spring.demo.demo.model.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import spring.demo.demo.validator.Unique;

@Data
public class SignUpDto {
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

    private String avatar;

    @NotNull
    @Size(min = 8, message = "Password at least 8 characters")
    @Pattern(regexp = "((?=.*\\d)|(?=.*\\W+))(?![.\\n"
            + "])(?=.*[A-Z])(?=.*[a-z]).*$", message = "Password must contain a-z A-Z 0-9 and special characters")
    private String password;
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
