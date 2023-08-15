package io.manivas.springmongo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootApplication
public class SpringmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmongoApplication.class, args);
//		Runnable runnable = () -> {
//			String threadName = Thread.currentThread().getName();
//			System.out.println(threadName);
//		};
//		System.out.println(Thread.currentThread().getName());
//		Thread thread = new Thread(runnable);
//		thread.start();
//		System.out.println(thread);
	}


	@Bean
	@Order(value = 2)
	CommandLineRunner runner(StudentRepository studentRepository,
			MongoTemplate mongoTemplate){
		return args -> {
			String email = "manivas999@gmail.com";
			Student myStudent = new Student("Manivas", "Gande", Gender.MALE,"manivas999@gmail.com",new Address("india","Gajwel","502278"),
					Arrays.asList("Maths","Physics"),new BigDecimal(37.43), LocalDateTime.now());

//			Query query = new Query();
//			query.addCriteria(Criteria.where("email").is(email));
//
//			List<Student> students = mongoTemplate.find(query, Student.class);
//			if(students.isEmpty()) {
//				studentRepository.insert(myStudent);
//			}

			Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
			if(studentByEmail.isPresent()){
				System.out.println("Email already taken");
			} else{
				studentRepository.insert(myStudent);
				System.out.println("Inserted student : " + myStudent);
			}
		};
	}


	@Bean
	@Order(value = 1)
	Integer printAllStudents(StudentRepository studentRepository){
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail("manivas999@gmail.com");
		if(studentByEmail.isPresent()){
			System.out.println("Specified email exists in the system");
		}
		return 0;
	}

}
