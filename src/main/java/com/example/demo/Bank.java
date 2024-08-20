package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;

    private String bankName;
    private String phoneNumber;

    @OneToOne(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PeopleBank peopleBank;

	public Bank(Long bankId, String bankName, String phoneNumber, PeopleBank peopleBank) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.phoneNumber = phoneNumber;
		this.peopleBank = peopleBank;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getPhoneNumber1() {
		return phoneNumber;
	}

	public void setPhoneNumber(Object object) {
		this.phoneNumber = (String) object;
	}

	public PeopleBank getPeopleBank() {
		return peopleBank;
	}

	public void setPeopleBank(PeopleBank peopleBank) {
		this.peopleBank = peopleBank;
	}

	public Object getPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}

   
}