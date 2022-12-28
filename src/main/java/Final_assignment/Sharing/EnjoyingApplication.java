package Final_assignment.Sharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//
//@EnableScheduling
@SpringBootApplication
public class EnjoyingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnjoyingApplication.class, args);
	}

}
