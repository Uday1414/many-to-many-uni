package com.ty.manytomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Cab;
import com.ty.manytomany.dto.Person;

public class TestGetCabPerson {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Cab cab = entityManager.find(Cab.class, 3);
		if (cab != null) {
			System.out.println("Cab Driver name : " + cab.getDriverName());
			System.out.println("Cab cost : " + cab.getCost());

			List<Person> persons = cab.getPersons();
			if (persons != null) {
				for (Person person : persons) {
					System.out.println("-----------persons--------");
					System.out.println("Person name : " + person.getName());
					System.out.println("Person age : " + person.getAge());
					System.out.println("***************************8");
				}
			} else {
				System.out.println("No person in cab");
			}
		} else {
			System.out.println("No cab with given Id");
		}
	}
}
