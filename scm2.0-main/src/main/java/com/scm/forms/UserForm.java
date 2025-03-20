package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserForm {

    @Email(message = "invalid email address")
    private String  email;

    @NotBlank(message = "username Is reqired")
    @Size( min=3 ,message = "Min 3 char is required")
    private String  name;

    @NotBlank(message = "about is required")
    private String  about;

    @Size(min=8 , max=12 , message = "Invalid phone number" )
    private String phoneNumber;

    @NotBlank(message = "password is required")
    @Size(min=6 , message = "Minimum 6 char is required")
    private String password;



}
