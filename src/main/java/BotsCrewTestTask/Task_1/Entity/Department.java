package BotsCrewTestTask.Task_1.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String departmentName;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="headOf")
	private Lector departmentHead;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="personal_department",
				joinColumns=@JoinColumn(name="dep_id"),
				inverseJoinColumns=@JoinColumn(name="lec_id")
	)
	private Set<Lector> personal = new HashSet<>();

	public Department() {
		
	}

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Lector getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(Lector departmentHead) {
		departmentHead.setHeadOf(this);
		this.departmentHead = departmentHead;
	}
	
	public Set<Lector> getPersonal() {
		return personal;
	}

	public void setPersonal(Set<Lector> personal) {
		this.personal = personal;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", departmentHead=" + departmentHead
				+ "]";
	}
	
	

}
