package az.itstep.pp.mapper;

import az.itstep.pp.dto.PaymentRequestDto;
import az.itstep.pp.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequestMapper implements BaseMapper <PaymentRequestDto,Payment> {
    @Override
    public Payment convert(PaymentRequestDto data) {
        Payment payment=new Payment();
        payment.setAmount(data.getAmount());
        return payment;
    }
}
