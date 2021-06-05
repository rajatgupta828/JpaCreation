# JPA

- All the tables(which in ORM we manage as class) which we manage in JPA are called as Entities.
- We have Entity Manager that manages Entities.

## Manage JPA in Spring/Maven Project

- We need to activate atleast one framework like Hibernate for activating JPA as below :

```
<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.5.0.Final</version>
</dependency>

```
- We need to add appropriate SQL connector, in this case MySQL connector



## JPA Methods

### Settings

We need to do settings to make sure JPA works with my sql, in Resources folder , we need to provide the 
configuration file.

 We need to place the code in src/main/resources/META-INF folder always

```
	<?xml version="1.0" encoding="UTF-8"?>

	<persistence version="2.2"
		xmlns="http://xmlns.jcp.org/xml/ns/persistence"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
	     http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
		<persistence-unit name="pu">
			<properties>
				<property name="javax.persistence.jdbc.driver"
					value="com.mysql.cj.jdbc.Driver" />
				<property name="javax.persistence.jdbc.url"
					value="jdbc:mysql://localhost:3306/AirDb" />
				<property name="javax.persistence.jdbc.user" value="root" />
				<property name="javax.persistence.jdbc.password"
					value="Garima@16" />
			</properties>
		</persistence-unit>
	</persistence>
```


### Code changes

Annotate our Entity with annotation

```
	@Entity
```

And the field with the Id name as primary key

```
	@Id
```


We have to first create a Manager Factory, these all frameworks follow Factory Design Pattern :

```
	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("pu");
```
We can give pu as our persistence manager name in createEntityManager;

Then we can create a manager

```
	EntityManager entityManager = managerFactory.createEntityManager();
```

We can use this manager to apply different JPA functions , like Find in this case, which would fetch data using Primary key

```
	Student student = entityManager.find(Student.class, 1);
```

To insert a data / Update the data, we need to keep it as a transaction, We need to start a transaction,persist a object, Commit a transaction, like in the code below :

```
	// Start a transaction
    	entityManager.getTransaction().begin();
    	
    	studentToBesaved.setAddress("Shimla");
    	studentToBesaved.setId(148);
    	studentToBesaved.setName("Rakesh");
    	studentToBesaved.setRoll("102");
    	
    	entityManager.persist(studentToBesaved);
    	//Commit the transaction
    	entityManager.getTransaction().commit();
```