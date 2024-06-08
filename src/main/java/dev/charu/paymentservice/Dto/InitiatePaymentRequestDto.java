package dev.charu.paymentservice.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class InitiatePaymentRequestDto {

    private long OrderId;
}
