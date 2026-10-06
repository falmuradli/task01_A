package mygov.task01;

import mygov.task01.data.Customer;
import mygov.task01.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Task01Application {

	public static void main(String[] args) {
		SpringApplication.run(Task01Application.class, args);
	}

	@Bean
	CommandLineRunner  seedCustomers(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(
					new Customer(1L, "Faig", "faiq@idda.az", "(010)389-80-81")
			);

			customerRepository.save(
					new Customer(2L, "Rauf", "rauf@idda.az", "(010) 123-45-67")
			);

			customerRepository.save(
					new Customer(3L, "Ali", "ali@idda.az", "(010) 234-56-78")
			);
		};
	}

}
