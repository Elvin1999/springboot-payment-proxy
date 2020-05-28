package az.itstep.pp.resource;


import az.itstep.pp.dto.PaymentRequestDto;
import az.itstep.pp.model.Payment;
import az.itstep.pp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentResource {
    private final DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private final PaymentService service;
    @PostMapping
    public ResponseEntity<?> pay(@RequestBody PaymentRequestDto dto){
        service.save(dto);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping
    public  ResponseEntity<List<Payment>> findAll(){
        log.info("Rest request for payments");
        List<Payment> payments=service.findAll();
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(payments);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Payment> findById(@PathVariable long id){
        log.info("Rest Request for payment with id: {}",id);
        Payment payment=service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(payment);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        log.info("Rest request delete payment id: {}",id);
        service.deleteById(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
   @PutMapping
    public ResponseEntity<?> update(@RequestBody Payment payment){
        log.info("Rest request for payment update id:{}",payment.getId());
        service.update(payment);
        return  ResponseEntity.status(HttpStatus.OK).build();
   }
    @GetMapping("/date")
    public ResponseEntity<List<Payment>> findInRange(@RequestParam("from") @DateTimeFormat(pattern = "yyyy/MM/dd") String from,
          @RequestParam("to") @DateTimeFormat(pattern = "yyyy/MM/dd") String to){
        log.info("From {}  to {}",from,to);
        LocalDate from1=LocalDate.parse(from,formatter);
        LocalDate to1=LocalDate.parse(to,formatter);
        List<Payment> payments= service.findInRange(from1,to1);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(payments);
    }

}
