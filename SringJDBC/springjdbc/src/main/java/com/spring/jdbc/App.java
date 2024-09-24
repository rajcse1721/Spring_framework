package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Program started");
		try {
			//ApplicationContext context = new ClassPathXmlApplicationContext("jdbcConfig.xml");
			
			ApplicationContext context = new AnnotationConfigApplicationContext(JdbcJavaConfig.class);

			StudentDao studentdao = context.getBean("studentDao", StudentDao.class);
			
			//insert
			Student student = new Student();
			student.setId(10);
			student.setName("Amareet");
			student.setAddress("Bengalore");

			int result = studentdao.insert(student);
			
			//update
//			Student student = new Student();
//			student.setId(6);
//			student.setName("Raj");
//			student.setAddress("Bhopal");
//			
//			int result = studentdao.change(student);
			
			//DELETE
//			int result = studentdao.delete(15);
//			System.out.println("Deleted: " + result);
			
			//select single entry
//			Student student = studentdao.getStudent(3);
//			System.out.println("selct from student id "+ student);
			
			//select multiple entry
			List<Student> allStudent = studentdao.getAllStudent();
			for(Student s : allStudent) {
				System.out.println("Entry:"+ s);
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}