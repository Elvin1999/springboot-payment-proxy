package az.itstep.pp.resource;


import az.itstep.pp.dto.PaymentRequestDto;
import az.itstep.pp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentResource {
    private final PaymentService service;
    @PostMapping
    public ResponseEntity<?> pay(@RequestBody PaymentRequestDto dto){
        service.save(dto);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }
}
