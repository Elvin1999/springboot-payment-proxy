package az.itstep.pp.repository;


import az.itstep.pp.model.Payment;
import az.itstep.pp.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment,Long> {

}
