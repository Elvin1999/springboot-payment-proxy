package az.itstep.pp.repository;

import az.itstep.pp.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Long> {
    Subscription getByAgreement(String agreement);
}
