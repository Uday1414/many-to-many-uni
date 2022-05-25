package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class TestSaveStudentCourse2 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student=new Student();
		student.setName("uday");
		student.setAge(23);
		
		List<Course> courses=new ArrayList<Course>();
		Course course1=entityManager.find(Course.class,2);
		
		Course course2=entityManager.find(Course.class,3);
		
		courses.add(course1);
		courses.add(course2);
		
		student.setCourses(courses);
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		
	}
}
