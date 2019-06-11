package tugas.tugas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TugasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TugasApplication.class, args);
//                System.out.println(new BCryptPasswordEncoder().encode("user"));
	}

}
