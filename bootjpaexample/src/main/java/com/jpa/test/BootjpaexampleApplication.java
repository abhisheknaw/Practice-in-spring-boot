package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		
		
		/*
		 * User user = new User(); user.setName("Abhishek"); user.setCity("Rishikesh");
		 * user.setStatus("I am a programmer");
		 */
		  //to save single object 
		  //User user1 = userRepository.save(user);
		  
			/*
			 * User user1 = new User(); user1.setName("Akshat"); user1.setCity("Srinagar");
			 * user1.setStatus("BBA");
			 * 
			 * User user2 = new User(); user2.setName("Akshita"); user2.setCity("Dehradun");
			 * user2.setStatus("BCom");
			 */
		  
		 /* //to save all objects at one time
		 * 
		 * List <User> users = List.of(user,user1,user2); 
		 * Iterable<User>result=userRepository.saveAll(users); 
		 * result.forEach(user3-> {
		 * System.out.println(user); }); System.out.println("done");
		 */
		 
		
		//update a single user
		/*
		 * Optional<User> optional = userRepository.findById(4);
		 * 
		 * User user = optional.get(); user.setName("Abhishek Nawani"); User result =
		 * userRepository.save(user); System.out.println(result);
		 */
		 
		 //to get all the data
		
		/*
		Iterable<User> itr = userRepository.findAll();
		
		itr.forEach(user-> {
			System.out.println(user);
			
		});
		*/
		
		//Deleting the user element
		
		//userRepository.deleteById(1);
		//System.out.println("deleted");
		
		//deleting all elements
		//userRepository.deleteAll();
		  

		/*
		 * List<User> result = userRepository.findByNameAndCity("Akshat", "Srinagar");
		 * 
		 * result.forEach(e->System.out.println(e));
		 */  
		
		
		/*
		 * List<User> result = userRepository.getUserbyname("Abhishek", "Rishikesh");
		 * result.forEach(e-> System.out.println(e));
		 */
		 
		
		/*
		 * List<User> result = userRepository.getall();
		 * 
		 * result.forEach(e->System.out.println(e));
		 */
		
		
		  
	}

}
