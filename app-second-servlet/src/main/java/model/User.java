package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class User {
    private String firstName;
    private String lastName;
    private String middleName;
    private String username;
    private String birthDate;
    private String password;
    private String prePassword;
}
