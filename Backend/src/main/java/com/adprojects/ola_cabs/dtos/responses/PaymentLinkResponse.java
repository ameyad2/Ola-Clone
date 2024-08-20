package com.adprojects.ola_cabs.dtos.responses;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentLinkResponse {

    private String paymentLinkUrl;
    private String paymentLinkId;
}
