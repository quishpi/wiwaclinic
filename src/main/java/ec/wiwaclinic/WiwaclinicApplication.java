package ec.wiwaclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ComponentScan("com.github.adminfaces") //This will scan for the Beans in the Admin Faces lib.
//@ServletComponentScan("com.github.adminfaces") // This will start the filter and servlets.
public class WiwaclinicApplication {
	public static void main(String[] args) {
		SpringApplication.run(WiwaclinicApplication.class, args);
	}
/*	
	@Bean
	public AdminSession adminSession() {
		return new AdminSession();
	}
	
	@Bean
	public AdminConfig adminConfig() {
		return new AdminConfig();
	}*/
}
