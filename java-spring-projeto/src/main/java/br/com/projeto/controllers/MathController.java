package br.com.projeto.controllers;

import br.com.projeto.exception.UnsupportedMathOperationException;
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
        if (!isNumeric(a) || !isNumeric(b)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return ConvertToDouble(a) + ConvertToDouble(b);
    }

    @RequestMapping("/mult/{a}/{b}")
    public double mult(@PathVariable("a") String a, @PathVariable("b") String b) throws Exception {
        if (!isNumeric(a) || !isNumeric(b)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return ConvertToDouble(a) * ConvertToDouble(b);

    }

    @RequestMapping("/sub/{a}/{b}")
    public double sub(@PathVariable("a") String a, @PathVariable("b") String b) {
        if (!isNumeric(a) || !isNumeric(b)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return ConvertToDouble(a) - ConvertToDouble(b);
    }

    @RequestMapping("div/{a}/{b}")
    public float div(@PathVariable("a") String a, @PathVariable("b") String b) {
        if (!isNumeric(a) || !isNumeric(b)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return ConvertToFloat(a) / ConvertToFloat(b);
    }

    @RequestMapping("media/{a}/{b}")
    public float media(@PathVariable("a") String a, @PathVariable("b") String b) {
        if (!isNumeric(a) || !isNumeric(b)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return (ConvertToFloat(a) + ConvertToFloat(b)) / 2;
    }

    private double ConvertToDouble(String valor) {
        if (valor.isEmpty() || valor == null) throw new UnsupportedMathOperationException("Please set a numeric value");
        String valor1 = valor.replace(",", ".");
        return Double.parseDouble(valor1);
    }

    private float ConvertToFloat(String valor) {
        if (valor.isEmpty() || valor == null) throw new UnsupportedMathOperationException("Please set a numeric value");
        String valor1 = valor.replace(",", ".");
        return Float.parseFloat(valor1);
    }

    private boolean isNumeric(String numero) {
        return numero.matches("[0-9]+");
    }
}
