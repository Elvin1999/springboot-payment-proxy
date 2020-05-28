package az.itstep.pp.repository;


import az.itstep.pp.model.Payment;
import az.itstep.pp.model.Subscription;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment,Long> {

    @Query(value="select p from Payment p where p.dateTime > :from and p.dateTime< :to")
    List<Payment> findInDateRange(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);


}
