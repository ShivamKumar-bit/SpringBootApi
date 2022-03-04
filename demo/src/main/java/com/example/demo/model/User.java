package com.example.demo.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userR")
public class User {
	private UUID uid;
	private int id;
    private String firstName;
    private String lastName;
    private String userName;// has to be unique
    
    public UUID getUid() {
		return uid=UUID.randomUUID();
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setId(int id) {
		this.id = id;
	}
	

    public User() {
    }

    public User(int id, String firstName, String lastName,String userName,UUID uid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName=userName;
        this.uid=uid;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
//other setters and getters
}