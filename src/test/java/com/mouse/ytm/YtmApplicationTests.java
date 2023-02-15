package com.mouse.ytm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class YtmApplicationTests {

    @Test
    void contextLoads() {
        double ytm = YTMUtil.calculateYield(95, 100, 0.03, 3);
        log.info("ytm={}",ytm);

        double ytm1 = YTMUtil.calculateYield(100, 100, 0.03, 3);
        log.info("ytm={}",ytm1);
    }

}
