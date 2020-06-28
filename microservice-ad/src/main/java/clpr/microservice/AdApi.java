package clpr.microservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AdApi extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(AdApi.class, args);
	}
	@GetMapping("/")
	public Ad index() {
		return new Ad(12345,"Faburous product");
	}
}
