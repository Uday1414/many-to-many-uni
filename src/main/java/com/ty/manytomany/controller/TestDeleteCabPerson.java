package com.ty.manytomany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Cab;

public class TestDeleteCabPerson {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Cab cab = entityManager.find(Cab.class, 2);
		if (cab != null) {
			entityTransaction.begin();
			entityManager.remove(cab);
			entityTransaction.commit();
		} else {
			System.out.println("No cab for given id");
		}
	}
}
