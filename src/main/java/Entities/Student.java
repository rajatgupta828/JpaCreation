package Entities;

import javax.persistence.Entity;

@Entity
public class Student {
	
	@javax.persistence.Id
	private int Id;
	private String Name;
	private String Roll;
	private String Address;
	
	public int getId() {
		return Id;
	}
	
	
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRoll() {
		return Roll;
	}
	public void setRoll(String roll) {
		Roll = roll;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	

}
