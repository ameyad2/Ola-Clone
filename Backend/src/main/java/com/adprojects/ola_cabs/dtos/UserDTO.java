package com.adprojects.ola_cabs.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {

    private Integer Id;
    private String email;
    private String name;
    private String mobile;

}
