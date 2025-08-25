package br.com.projeto.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    //http:localhost:8080/math
    @RequestMapping("/sum/{a}/{b}")
    public double sum(
            @PathVariable("a") String a,
            @PathVariable("b") String b) throws Exception {
        if (!isNumeric(a) || !isNumeric(b)) throw new IllegalAccessException();
        return convertToDouble(a) + convertToDouble(b);
    }

    private double convertToDouble(String valor) {
        return Double.parseDouble(valor);
    }

    private boolean isNumeric(String numero) {
        return numero.matches("[0-9]+");
    }
}
