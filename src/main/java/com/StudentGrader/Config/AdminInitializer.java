package com.StudentGrader.Config;

import com.StudentGrader.Entity.Admin;
import com.StudentGrader.Repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer implements CommandLineRunner {

	@Autowired
	private AdminRepository repo;

	@Autowired
	private PasswordEncoder encode;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("In the CMDLRNR");
		String email = "sahilshahare380@gmail.com";
		if (repo.findByEmail(email).isEmpty()) {
			Admin admin = new Admin();
			admin.setEmail(email);
			admin.setPassword(encode.encode("sahil@123"));
			repo.save(admin);
			System.out.println("Default admin created: " + email);
		}

	}

	// @Bean
	// CommandLineRunner initAdmin(AdminRepository adminRepo, PasswordEncoder
	// encoder) {
	// return args -> {
	// String email = "sahilshahare380@gmail.com";
	// if (adminRepo.findByEmail(email).isEmpty()) {
	// Admin admin = new Admin();
	// admin.setEmail(email);
	// admin.setPassword(encoder.encode("sahil@123"));
	// adminRepo.save(admin);
	// System.out.println("Default admin created: " + email);
	// }
	// };
	// }
}
