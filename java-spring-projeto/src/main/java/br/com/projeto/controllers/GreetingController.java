package br.com.projeto.controllers;

import br.com.projeto.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello %s!";
    private static final String valor = "Tenho %s!";
    private final AtomicLong counter = new AtomicLong();


    // http://localhost:8080/greeting?name=Rian
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "idade", defaultValue = "0") String idade,
            @RequestParam(value = "name", defaultValue = "World!") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name), String.format(valor, idade));
    }
}
