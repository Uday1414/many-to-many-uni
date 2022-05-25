package com.ty.manytomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class TestGetStudentCourse {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student student = entityManager.find(Student.class, 3);
		if (student != null) {
			System.out.println("Student name : " + student.getName());
			System.out.println("Student Age : " + student.getAge());
			System.out.println("---------------Courses----------------");

			List<Course> courses = student.getCourses();

			for (Course course : courses) {
				System.out.println("Course name : " + course.getName());
				System.out.println("Course duration : " + course.getDuration());
				System.out.println("********************************");
			}
		}else {
			System.out.println("No student found with given Id");
		}
	}
}
