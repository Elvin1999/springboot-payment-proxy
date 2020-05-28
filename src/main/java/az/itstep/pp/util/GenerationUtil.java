package az.itstep.pp.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component//for inject in subscription
public class GenerationUtil {
    public String generateRrn(){
        return RandomStringUtils.random(12,false,true);
    }
    public String generateSubscriptionNumber(){
        return RandomStringUtils.random(12,true,true);
    }
}
