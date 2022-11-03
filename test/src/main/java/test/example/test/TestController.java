package test.example.test;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    @CrossOrigin("*")
    public ResponseEntity<String> test() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<String>("spring boot på arch linux poggers", responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/test2")
    @CrossOrigin("*")
    public @ResponseBody String test2() {
        return "spring boot på arch linux poggers";
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/a")
    public void endpointA(@RequestParam String x, int y) {
        System.out.println(x + " " + y);
    }

    @GetMapping("/b/{speech}")
    public void endpointB(@PathVariable String speech) {
        System.out.println("A famous cat once said " + speech);
    }

    @PostMapping("/c")
    @CrossOrigin("*")
    public void endpointC(@RequestBody Map<String, String> body) {
        System.out.println(body.keySet().contains("message"));
    }

    @GetMapping("/d")
    @CrossOrigin("*")
    public void endpointD() {
        System.out.println(
                ResponseEntity
                        .ok()
                        .header("MinHeader", "Spring")
                        .build());
    }

    @GetMapping("/d2")
    @CrossOrigin("*")
    public void endpointD2(@RequestHeader HttpHeaders headers) {
        System.out.println(headers.toString());
    }

    @PostMapping("/e")
    @CrossOrigin("*")
    public void endpointE(@RequestBody Map<String, String> body) {
        // int x = 0;
        // body.keySet().forEach(x -> System.out.println(x));
        body.keySet().forEach(i -> System.out.println(i.length()));
    }
}
