package az.itstep.pp.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class GenerationUtil {
    public String generateSubscriptionNumber(){
        return RandomStringUtils.random(12,true,true);
    }
}
