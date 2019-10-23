package co.ias.bootcamp.springworkshop.controllers;

import co.ias.bootcamp.springworkshop.configuration.DatabaseConfigurationProps;
import co.ias.bootcamp.springworkshop.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class HelloController {

    private final DatabaseConfigurationProps databaseConfigurationProps;

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public HelloController(DatabaseConfigurationProps databaseConfigurationProps) {
        this.databaseConfigurationProps = databaseConfigurationProps;
    }

    @RequestMapping("/hello")
    public Greeting helloWorld(@RequestParam(value = "name", defaultValue = "world") String toWhom) {
        String content = String.format("Hello %s!", toWhom);
        Long id = counter.incrementAndGet();
        return new Greeting(id, content);
    }

    @RequestMapping("/config")
    public String configuration() {
        return databaseConfigurationProps.toString();
    }
}
