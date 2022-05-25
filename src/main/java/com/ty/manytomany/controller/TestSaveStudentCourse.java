package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class TestSaveStudentCourse {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student1=new Student();
		student1.setName("abhi");
		student1.setAge(25);
		
		List<Course> courses=new ArrayList<Course>();
		Course course1=new Course();
		course1.setName("java");
		course1.setDuration("6 months");
		
		Course course2=new Course();
		course2.setName("HTML");
		course2.setDuration("15 days");
		
		Course course3=new Course();
		course3.setName("CSS");
		course3.setDuration("10 days");
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		student1.setCourses(courses);
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityTransaction.commit();
		
	}
}
