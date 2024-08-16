package com.example.demo;
import jakarta.persistence.*;

@Entity
@Table(name="people")
public class People 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy="people",cascade=CascadeType.All)
	
	private Bank bank;
	private String First_name;
	public People(Long id, String first_name, String last_name, String birth_date) {
		super();
		this.id = id;
		First_name = first_name;
		Last_name = last_name;
		Birth_date = birth_date;
	}
	private String Last_name;
	private String Birth_date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public String getBirth_date() {
		return Birth_date;
	}
	public void setBirth_date(String birth_date) {
		Birth_date = birth_date;
	}
	
	


}
