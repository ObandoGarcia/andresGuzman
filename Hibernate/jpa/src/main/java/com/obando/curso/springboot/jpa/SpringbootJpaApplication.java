package com.obando.curso.springboot.jpa;

import com.obando.curso.springboot.jpa.entities.Person;
import com.obando.curso.springboot.jpa.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	private final PersonRepository personRepository;

    public SpringbootJpaApplication(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		List<Person> persons = personRepository.findByProgrammingLanguageAndFirstname("Java", "Anna");
		persons.forEach(System.out::println);
		*/

		personalizeQueriesDistinct();
	}

	//Delete
	@Transactional
	public void delete(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el ID de la persona a eliminar: ");
		Long id = scanner.nextLong();

		//personRepository.deleteById(id);

		Optional<Person> optionalPerson = personRepository.findById(id);

		optionalPerson.ifPresent(personRepository::delete);
	}

	//Guardar un nuevo registro de la base de datos
	@Transactional
	public void create(){
		Person person = new Person(null, "Lalo", "Thor", "Python");
		personRepository.save(person);
	}

	@Transactional(readOnly = true)
	public void personalizeQueriesDistinct(){
		System.out.println("Consultas personalizadas:");
		List<String> nombres = personRepository.findAllNames();
		nombres.forEach(System.out::println);
	}

	@Transactional
	public void update(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el ID de la persona: ");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = personRepository.findById(id);

		optionalPerson.ifPresent(person -> {
			System.out.println("Ingrese el lenguage de Programacion: ");
			String programmingLanguage = scanner.next();
			person.setProgrammingLanguage(programmingLanguage);

			Person personDb = personRepository.save(person);

			System.out.println(personDb);
		});

		scanner.close();

	}

	@Transactional(readOnly = true)
	public void findOne(){
		/*Person person = null;
		Optional<Person> personOptional = personRepository.findById(9L);

		if(personOptional.isPresent()){
			person = personOptional.get();
		}

		System.out.println(person);*/

		//Segundo forma
		personRepository.findById(7L).ifPresent(System.out::println);
	}
}
