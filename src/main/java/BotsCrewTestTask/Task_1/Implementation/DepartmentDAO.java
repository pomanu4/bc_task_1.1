package BotsCrewTestTask.Task_1.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import BotsCrewTestTask.Task_1.Entity.Department;
import BotsCrewTestTask.Task_1.Entity.Lector;
import BotsCrewTestTask.Task_1.dao.IdepartmentDAO;

public class DepartmentDAO implements IdepartmentDAO {

	private EntityManagerFactory managerFactory = null;

	public DepartmentDAO(EntityManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

	@Override
	public String showDepartmentHead(String depName) {
		EntityManager manager = managerFactory.createEntityManager();
		manager.getTransaction().begin();

		String q = "SELECT d FROM Department d JOIN FETCH d.departmentHead WHERE d.departmentName = :name";
		Query query = manager.createQuery(q);
		query.setParameter("name", depName);
		Department dep = (Department) query.getSingleResult();
		String str = "Head of " + depName + " department is " + dep.getDepartmentHead().getFirstName() + " "
				+ dep.getDepartmentHead().getLastName();

		manager.close();
		return str;
	}

	@Override
	public String showDepartmentStatistic(String depName) {
		EntityManager manager = managerFactory.createEntityManager();
		manager.getTransaction().begin();

		String q = "SELECT l.degree, COUNT(l.degree) FROM Lector l JOIN l.departments d  WHERE d.departmentName = :name GROUP BY l.degree";
		Query query = manager.createQuery(q);
		query.setParameter("name", depName);
		List<?> lectors = query.getResultList();
		String str = "";
		for (Object l : lectors) {
			if (l instanceof Object[]) {
				Object[] arr = (Object[]) l;
				for (int i = 0; i < arr.length; i++) {
					str += arr[i].toString() + " ";
				}
			} else {
				System.out.println("else");
			}
			str += "\n";
		}

		manager.close();
		return str;
	}

	@Override
	public String showAverageDepartmentSalary(String depName) {
		EntityManager manager = managerFactory.createEntityManager();
		manager.getTransaction().begin();

		String q = "SELECT AVG(l.salary) FROM Lector l JOIN l.departments d  WHERE d.departmentName = :name";
		Query query = manager.createQuery(q);
		query.setParameter("name", depName);

		List<?> lectors = query.getResultList();
		String str = "";
		for (Object l : lectors) {
			str = "the average salary of " + depName + " is " + l.toString();
		}
		manager.close();
		return str;
	}

	@Override
	public String showCountOfEmployee(String depName) {
		EntityManager manager = managerFactory.createEntityManager();
		manager.getTransaction().begin();

		String q = "SELECT d FROM Department d JOIN FETCH d.personal WHERE d.departmentName = :name";
		Query query = manager.createQuery(q);
		query.setParameter("name", depName);
		Department dep = (Department) query.getSingleResult();
		int number = dep.getPersonal().size();
		String str = "" + number;
		
		manager.close();
		return str;
	}

	@Override
	public String searchByPattern(String pattern) {
		EntityManager manager = managerFactory.createEntityManager();
		manager.getTransaction().begin();

		String q = "SELECT l FROM Lector l  WHERE (l.firstName LIKE :pattern) OR (l.lastName LIKE :pattern) GROUP BY l.id";
		Query query = manager.createQuery(q);
		String pat = "%" + pattern.toLowerCase() + "%";
		query.setParameter("pattern", pat);

		List<?> lectors = query.getResultList();
		String str = "";
		for (Object l : lectors) {
			Lector lec = (Lector) l;
			str += lec.toString() + "\n";
		}
		manager.close();
		return str;
	}

}
