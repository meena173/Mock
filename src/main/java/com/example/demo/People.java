package com.example.demo;
import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    private String firstName;
    private String lastName;
    private Date birthDate;

    @OneToOne(mappedBy = "people", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PeopleBank peopleBank;

	public People(Long personId, String firstName, String lastName, Date birthDate, PeopleBank peopleBank) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.peopleBank = peopleBank;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public PeopleBank getPeopleBank() {
		return peopleBank;
	}

	public void setPeopleBank(PeopleBank peopleBank) {
		this.peopleBank = peopleBank;
	}

    
}
