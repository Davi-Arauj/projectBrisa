package projeto.brisa.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"projeto.brisa.teste.services"})
@SpringBootApplication
public class TesteApplication {
	
	    public static void main(String[] args) {
	        SpringApplication.run(TesteApplication.class, args);
	    }
	
}
