package az.itstep.pp.service.impl;

import az.itstep.pp.dto.PaymentRequestDto;
import az.itstep.pp.mapper.PaymentRequestMapper;
import az.itstep.pp.model.Payment;
import az.itstep.pp.model.Subscription;
import az.itstep.pp.repository.PaymentRepository;
import az.itstep.pp.repository.SubscriptionRepository;
import az.itstep.pp.service.PaymentService;
import az.itstep.pp.service.SubscriptionService;
import az.itstep.pp.util.GenerationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repo;
    private  final GenerationUtil generationUtil;
    private final PaymentRequestMapper mapper;
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionService subscriptionService;
    @Override
    public void save(PaymentRequestDto paymentDto) {
        Payment payment=mapper.convert(paymentDto);
        payment.setRrn(generationUtil.generateRrn());
        payment.setDateTime(LocalDateTime.now());
        Subscription subscription=subscriptionRepository.getByAgreement(paymentDto.getAgreement());
        log.info("Subscription found : {}",subscription);
        subscriptionService.debit(paymentDto.getAmount(),subscription.getAgreement());
        payment.setSubscription(subscription);
        repo.save(payment);
    }

    @Override
    public Payment findById(long id) {
        return null;
    }

    @Override
    public List<Payment> findAll() {
        return null;
    }

    @Override
    public void update(Payment payment) {

    }

    @Override
    public void deleteById(long id) {

    }
}
