package az.itstep.pp.service.impl;

import az.itstep.pp.exception.DomainUpdateException;
import az.itstep.pp.exception.NotFoundException;
import az.itstep.pp.model.Subscription;
import az.itstep.pp.repository.SubscriptionRepository;
import az.itstep.pp.service.SubscriptionService;
import az.itstep.pp.util.GenerationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository repo;
    private  final GenerationUtil generationUtil;

    @Override
    public void save(Subscription subscription) {
        subscription.setCreatedDate(LocalDateTime.now());
        subscription.setAgreement(generationUtil.generateSubscriptionNumber());
        repo.save(subscription);
    }

    @Override
    public Subscription findById(long id) {
        return repo.findById(id).orElseThrow(()->new NotFoundException("No subscription found for id : "+id));
    }

    @Override
    public List<Subscription> findAll() {
        return (List<Subscription>) repo.findAll();
    }

    @Override
    public void update(Subscription subscription) {
        if(subscription.getId()!=null){
            repo.save(subscription);
        }
        else{
            throw new DomainUpdateException("please choose subscription to update");
        }
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public Subscription findByAgreement(String agreement) {
       return repo.getByAgreement(agreement);
    }
}
