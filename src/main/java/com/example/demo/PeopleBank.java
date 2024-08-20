package com.example.demo;

import jakarta.persistence.*;

import org.springframework.expression.spel.ast.OpLE;


@Entity
public class PeopleBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private OpLE people;

    @OneToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    private String accountType;
    
    

	public PeopleBank(Long id, OpLE people, Bank bank, String accountType) {
		super();
		this.id = id;
		this.people = people;
		this.bank = bank;
		this.accountType = accountType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OpLE getPeople() {
		return people;
	}

	public void setPeople(OpLE people) {
		this.people = people;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

    
}
