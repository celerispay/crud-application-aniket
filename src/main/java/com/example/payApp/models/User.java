package com.example.payApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String uname;

    @Column(name = "password")
    private String password;

    @Column(name = "roles")
    private String urole;

	public User(String uname, String password, String urole) {
		super();
		this.uname = uname;
		this.password = password;
		this.urole = urole;
	}
    
}
