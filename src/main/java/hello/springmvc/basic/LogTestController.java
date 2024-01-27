package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {

    private Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "spring";

        // log는 단계에 따라 실행되지 않을 수도 있으므로 문자열 연산자 '+' 사용 금지, 리소스 낭비
        log.trace("trace = {}", name);
        log.debug("debug = {}", name);
        log.info("info = {}", name);
        log.warn("warn = {}", name);
        log.error("error = {}", name);

        return "ok";
    }
}
