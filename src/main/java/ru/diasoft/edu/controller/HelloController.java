package ru.diasoft.edu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.edu.domain.Hello;
import ru.diasoft.edu.service.HelloService;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final HelloService helloService;

    @GetMapping("/hello")
    public Hello getHello(@RequestParam(defaultValue = "") String name) {
        return helloService.getHello(name);
    }
}
