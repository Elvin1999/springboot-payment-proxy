package az.itstep.pp.resource;

import az.itstep.pp.model.Subscription;
import az.itstep.pp.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
@Slf4j
public class SubscriptionResource {
    private final SubscriptionService service;

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> findById(@PathVariable long id){
        log.info("Rest Request for subscription with id : {}",id);
        Subscription response=service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }
    @GetMapping
    public ResponseEntity<List<Subscription>> findAll(){
        log.info("Rest Request for all subscriptions . . .");
        List<Subscription> response=service.findAll();
        return  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }
    @PostMapping
    public ResponseEntity<?> save( @RequestBody Subscription subscription){
        log.info("Rest Request for subscription save");
        service.save(subscription);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        log.info("Rest Request for deleting subscription with id : {} ",id);
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping
    public ResponseEntity<Subscription> update( @RequestBody Subscription subscription){
        log.info("Rest Request for update subscription");
        service.update(subscription);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/agreement")
    public  ResponseEntity<Subscription> getByAgreement(@RequestParam(value = "agreement",required = true)
                                                                    String agreement ){
        log.info("Rest Request for subscription with agreement  : {}",agreement);
         Subscription subscription= service.findByAgreement(agreement);
         return  ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(subscription);
    }
    @GetMapping("/balance")
    public ResponseEntity<List<Subscription>> getByBalance(@RequestParam(value="from")
                                                                 double from,@RequestParam(value="to") double to){
        log.info("Rest request for subscription with balance from :{} to :{}",from,to);
        List<Subscription> response=service.findInBalanceRange(from,to);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }
//    @GetMapping("/date")
//    public ResponseEntity<List<Subscription>> getByDate(@RequestParam(value="year"))


}









