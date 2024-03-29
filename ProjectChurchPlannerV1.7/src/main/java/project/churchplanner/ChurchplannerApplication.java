package project.churchplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@ComponentScan(basePackages = { "project.churchplanner" })
@EnableAutoConfiguration
@SpringBootApplication
//@ComponentScan("project.churchplanner")
public class ChurchplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChurchplannerApplication.class, args);
	}

}
