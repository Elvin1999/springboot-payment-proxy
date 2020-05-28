package az.itstep.pp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String agreement;//subscriptionNumber
    private String address;
    private double balance;
    private LocalDateTime createdDate;
    @OneToMany(mappedBy = "subscription",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Payment> payments;
}
