package com.cursospringboot.spring_boot;

import com.cursospringboot.spring_boot.domain.Categoria;
import com.cursospringboot.spring_boot.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.ColumnMapRowMapper;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 =new Categoria(null,"Informatica");
		Categoria cat2 =new Categoria(null, "Escritorio");

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}
}
