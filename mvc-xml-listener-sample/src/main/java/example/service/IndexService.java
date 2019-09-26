package example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author xiaoheitalk
 * @type IndexService
 * @date 2019/9/25 20:19
 */
@Service
public class IndexService {
    private Logger log = LoggerFactory.getLogger(IndexService.class);

    public String sayHello(String message) {
        Integer index = new Random().nextInt(1000);
        String result = message + index;
        log.info("sayHello: {}", result);
        return result;
    }

    public int sum(int a, int b) {
        int sum = a + b;
        log.info("sum: {}+{}={}", a, b, sum);
        return sum;
    }

    public String test() {
        Integer index = new Random().nextInt(1000);
        log.info("test: {}", index);
        return index + "";
    }
}
