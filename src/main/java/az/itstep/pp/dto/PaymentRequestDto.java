package az.itstep.pp.dto;

import lombok.Data;

@Data
public class PaymentRequestDto {
    private double amount;
    private String agreement;
}
