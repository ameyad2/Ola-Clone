package com.adprojects.ola_cabs.models;

import com.adprojects.ola_cabs.models.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String fullName;
    private String email;
    @Column(unique = true)
    private String mobile;
    private String password;

    private String profilePicture;
    private UserRole role;

}
