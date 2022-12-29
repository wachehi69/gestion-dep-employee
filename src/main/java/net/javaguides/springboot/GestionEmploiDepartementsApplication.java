package net.javaguides.springboot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import net.javaguides.springboot.entities.Department;
import net.javaguides.springboot.services.EmployeeService;

@SpringBootApplication
public class GestionEmploiDepartementsApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(GestionEmploiDepartementsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Department dep = new Department();
		dep.setId(2);
		/*
		 * employeeService.createEmploye(new Employee(0, "Ali", "Abdoul Madjid",
		 * "0776584512", dep)); employeeService.createEmploye(new Employee(0, "Bacar",
		 * "zahanadzi", "077658448", dep));
		 */
	}

	@Bean
	public CorsFilter corsFilter() {

		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Origin", "Content-Type", "Accept",
				"Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlbasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlbasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

		return new CorsFilter(urlbasedCorsConfigurationSource);
	}

}
