package dev.lohan.userms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String name;
    private String taxId;
    private String address;
    private String email;
    private String phoneNumber;
    private Date registrationDate;
}
