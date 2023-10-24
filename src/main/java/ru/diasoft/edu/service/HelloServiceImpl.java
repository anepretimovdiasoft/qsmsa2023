package ru.diasoft.edu.service;

import org.springframework.stereotype.Service;
import ru.diasoft.edu.aspect.annotation.LogExample;
import ru.diasoft.edu.domain.Hello;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class HelloServiceImpl implements HelloService {

    private static final String HELLO_TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    @LogExample
    public Hello getHello(String name) {

        Hello hello;
        long id = counter.incrementAndGet();

        if (!name.isEmpty())
            hello = new Hello(id, String.format(HELLO_TEMPLATE, name));
        else
            hello = new Hello(id, String.format(HELLO_TEMPLATE, "World"));

        return hello;
    }
}
