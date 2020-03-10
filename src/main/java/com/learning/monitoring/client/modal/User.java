package com.learning.monitoring.client.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {

	@Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String contact;
}
