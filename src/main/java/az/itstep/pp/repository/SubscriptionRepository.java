package az.itstep.pp.repository;

import az.itstep.pp.model.Subscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Long> {
    Subscription getByAgreement(String agreement);
    @Query(value="select s from Subscription s where s.balance< :to and s.balance> :from")
    List<Subscription> findInBalanceRange(@Param("to") double to,@Param("from") double from);
}
