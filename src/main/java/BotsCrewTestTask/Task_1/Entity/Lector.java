package BotsCrewTestTask.Task_1.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import BotsCrewTestTask.Task_1.Degree;

@Entity
public class Lector {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private Degree degree;
	
	private int salary;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="personal_department",
				joinColumns=@JoinColumn(name="lec_id"),
				inverseJoinColumns=@JoinColumn(name="dep_id")
	)
	private Set<Department> departments = new HashSet<>();
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Department headOf;

	public Lector() {
		
	}

	public Lector(String firstName, String lastName, Degree degree, int salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.degree = degree;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public Department getHeadOf() {
		return headOf;
	}

	public void setHeadOf(Department headOf) {
		this.headOf = headOf;
	}
	
	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Lector  " + firstName + "  " + lastName ;
	}
}
