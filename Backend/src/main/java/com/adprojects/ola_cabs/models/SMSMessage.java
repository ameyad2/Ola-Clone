package com.adprojects.ola_cabs.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SMSMessage {
    private String message;
    private String mobile;
}
