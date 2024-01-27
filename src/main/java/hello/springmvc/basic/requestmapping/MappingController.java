package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    // 일반 맵핑 , 메서드 구분 없음
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    // HTTP 메서드 맵핑
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    // HTTP 메서드 맵핑 축약
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }

    // PathVariable(경로변수) 사용 맵핑
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String id) {
        log.info("userId = {}", id);
        return "ok";
    }

    // 다중 경로변수 사용 맵핑
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId,
                              @PathVariable long orderId) {
        log.info("userId = {}, orderId = {}", userId, orderId);
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "consume";
    }

    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "produce";
    }
}
