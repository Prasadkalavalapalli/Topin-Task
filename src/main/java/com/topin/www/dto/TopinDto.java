package com.topin.www.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TopinDto {

	@NotBlank(message = "Full name cannot be empty")
    private String full_name;

    @NotBlank(message = "Mobile number cannot be empty")
    @Pattern(regexp = "^(\\+91|0)?[6-9]\\d{9}$", message = "Invalid mobile number format")
    private String mob_num;

    @NotBlank(message = "PAN number cannot be empty")
    @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]$", message = "Invalid PAN number format")
    private String pan_num;	
    private UUID manager_id;
}
