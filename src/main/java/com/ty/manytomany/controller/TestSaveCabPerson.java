package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Cab;
import com.ty.manytomany.dto.Person;

public class TestSaveCabPerson {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Cab cab=new Cab();
		cab.setDriverName("naresh");
		cab.setCost(200);
		
		List<Person> persons=new ArrayList<Person>();
		
		Person person1=new Person();
		person1.setName("Abhi");
		person1.setAge(25);
		
		Person person2=new Person();
		person2.setName("balaji");
		person2.setAge(25);
		persons.add(person1);
		persons.add(person2);
		cab.setPersons(persons);
		
		entityTransaction.begin();
		entityManager.persist(cab);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityTransaction.commit();
	}
}
