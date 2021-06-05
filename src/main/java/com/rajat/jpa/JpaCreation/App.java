package com.rajat.jpa.JpaCreation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    { 
    	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("pu");
    	EntityManager entityManager = managerFactory.createEntityManager();
    	
    	Student student = entityManager.find(Student.class, 1);
    	
    	System.out.println(student.getAddress());
    	
    	Student studentToBesaved = new Student();
    	
    	//To Update we need to have a transaction
    	
    	// Start a transaction
    	entityManager.getTransaction().begin();
    	
    	studentToBesaved.setAddress("Shimla");
    	studentToBesaved.setId(148);
    	studentToBesaved.setName("Rakesh");
    	studentToBesaved.setRoll("102");
    	
    	entityManager.persist(studentToBesaved);
    	
    	entityManager.getTransaction().commit();
    	
    }
}
