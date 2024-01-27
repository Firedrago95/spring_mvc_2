package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String users() {
        return "getUsers";
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable String userId) {
        return "getUser = " + userId;
    }

    @PostMapping("/{userId}")
    public String addUser(@PathVariable String userId) {
        return "addUser = " + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "updateUser = " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "deleteUser = " + userId;
    }
}
