package az.itstep.pp.service;

import az.itstep.pp.model.Subscription;

import java.util.List;

public interface SubscriptionService {
    void save(Subscription subscription);
    Subscription findById(long id);
    List<Subscription> findAll();
    void update(Subscription subscription);
    void deleteById(long id);
    Subscription findByAgreement(String agreement);
}
