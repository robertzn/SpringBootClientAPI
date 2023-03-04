package com.robertndlala.submission.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class ClientModel {

    @NotBlank(message = "Name should not be empty")
    private String first_name;
    @NotBlank(message = "Name should not be empty")
    private String last_name;

    @NotNull(message = "Password should not be empty")
    @Size(min = 10, message = "Password should be atleast 5 characters")
    private Long Mobile;

    @NotNull(message = "Password should not be empty")
    @Size(min = 13, message = "Password should be atleast 5 characters")
    private Long idnumber;

    @NotNull(message = "Password should not be empty")
    private String physical_address;


}
