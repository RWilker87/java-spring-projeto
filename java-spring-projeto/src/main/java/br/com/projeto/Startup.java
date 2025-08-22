// CÓDIGO CORRETO
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Startup {

    public static void main(String[] args) {
        // Correção: Chame o método estático run da classe SpringApplication
        SpringApplication.run(Startup.class, args);
    }

}