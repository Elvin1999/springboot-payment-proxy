package az.itstep.pp.service;

import az.itstep.pp.dto.PaymentRequestDto;
import az.itstep.pp.model.Payment;

import java.util.List;

public interface PaymentService {
    void save(PaymentRequestDto paymentDto);
    Payment findById(long id);
    List<Payment> findAll();
    void update(Payment payment);
    void deleteById(long id);
}
