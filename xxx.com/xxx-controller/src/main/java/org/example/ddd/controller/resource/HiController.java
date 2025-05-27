package org.example.ddd.controller.resource;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.example.ddd.application.service.event.EventAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.SecureRandom;

@RestController
@RequestMapping("/api/")
public class HiController {
    @Autowired
    private EventAppService eventAppService;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/hi")
    @RateLimiter(name = "backendA", fallbackMethod = "fallbackHello")
    public String helloWorld() {
        return "Hello World";
//        return eventAppService.hiEvent("taivo");
    }

    public String fallbackHello(Throwable throwable) {
        return "Too Many Requests";
    }

    @GetMapping("/h1/v1")
    @RateLimiter(name = "backendB", fallbackMethod = "fallbackHello")
    private String Hi(){
        return eventAppService.hiEvent("taivo");
    }

    private static final SecureRandom secureRandom = new SecureRandom();
    @GetMapping("/circuit/breaker")
    @CircuitBreaker(name="checkRandom", fallbackMethod = "fallbackCircuitBreaker")
    public String circuitBreaker() {
        int random = secureRandom.nextInt(20)+1;
//        https://fakestoreapi.com/products/1
        String url = "https://fakestoreapi.com/products/" + random;
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackCircuitBreaker(Throwable throwable) {
        return throwable.getMessage();
    }
}
