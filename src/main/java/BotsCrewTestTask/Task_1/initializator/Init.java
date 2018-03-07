package BotsCrewTestTask.Task_1.initializator;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import BotsCrewTestTask.Task_1.Degree;
import BotsCrewTestTask.Task_1.Entity.Department;
import BotsCrewTestTask.Task_1.Entity.Lector;

public class Init {

	private EntityManagerFactory managerFactory = null;

	public Init(EntityManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

	public void initDataBase() {

		EntityManager manager = managerFactory.createEntityManager();

		manager.getTransaction().begin();

		Lector faradey = new Lector("Milel", "Faradey", Degree.PROFESSOR, 5050);
		manager.persist(faradey);
		Lector bor = new Lector("Nils", "Bor", Degree.PROFESSOR, 5055);
		manager.persist(bor);
		Lector vernadsky = new Lector("Volodumur", "Vernadskyi", Degree.PROFESSOR, 5055);
		manager.persist(vernadsky);
		Lector nobel = new Lector("Alfred", "Nobel", Degree.PROFESSOR, 5000);
		manager.persist(nobel);
		Lector kepler = new Lector("Uohan", "Keppler", Degree.PROFESSOR, 5000);
		manager.persist(kepler);
		Lector pascal = new Lector("Blez", "Pascal", Degree.PROFESSOR, 5050);
		manager.persist(pascal);
		Lector vorona = new Lector("Ivan", "Vorona", Degree.ASSOCIATE_PROFESSOR, 3000);
		manager.persist(vorona);
		Lector okyn = new Lector("Petro", "Okyn", Degree.ASSOCIATE_PROFESSOR, 3030);
		manager.persist(okyn);
		Lector gaida = new Lector("Semen", "Gaida", Degree.ASSOCIATE_PROFESSOR, 3033);
		manager.persist(gaida);
		Lector bereza = new Lector("Dmutro", "Bereza", Degree.ASSISTANT, 2020);
		manager.persist(bereza);
		Lector gora = new Lector("Yriy", "Gora", Degree.ASSISTANT, 2022);
		manager.persist(gora);
		Lector gonch = new Lector("Oles", "Goncharenko", Degree.ASSISTANT, 2000);
		manager.persist(gonch);
		Lector koval = new Lector("Mykola", "Koval", Degree.ASSISTANT, 2020);
		manager.persist(koval);
		Lector smal = new Lector("Oleg", "Smal", Degree.ASSISTANT, 2002);
		manager.persist(smal);
		Lector semen = new Lector("Viktor", "Semenushun", Degree.ASSISTANT, 2000);
		manager.persist(semen);

		Lector phys1 = new Lector("Ernest", "Reserford", Degree.PROFESSOR, 5000);
		manager.persist(phys1);
		Lector chem1 = new Lector("Robert", "Boyl", Degree.PROFESSOR, 5050);
		manager.persist(chem1);
		Lector math1 = new Lector("Rene", "Decart", Degree.PROFESSOR, 5055);
		manager.persist(math1);

		Set<Lector> physicsLectors = new HashSet<>();
		physicsLectors.add(phys1);
		physicsLectors.add(faradey);
		physicsLectors.add(bor);
		physicsLectors.add(vorona);
		physicsLectors.add(okyn);
		physicsLectors.add(bereza);
		physicsLectors.add(gora);

		Set<Lector> chemestryLectors = new HashSet<>();
		chemestryLectors.add(chem1);
		chemestryLectors.add(vernadsky);
		chemestryLectors.add(nobel);
		chemestryLectors.add(vorona);
		chemestryLectors.add(gaida);
		chemestryLectors.add(gonch);
		chemestryLectors.add(koval);
		chemestryLectors.add(smal);

		Set<Lector> mathsLectors = new HashSet<>();
		mathsLectors.add(math1);
		mathsLectors.add(bor);
		mathsLectors.add(kepler);
		mathsLectors.add(pascal);
		mathsLectors.add(okyn);
		mathsLectors.add(gaida);
		mathsLectors.add(gora);
		mathsLectors.add(gonch);
		mathsLectors.add(smal);
		mathsLectors.add(semen);

		Department chemestry = new Department("chemestry");
		Department physics = new Department("physics");
		Department maths = new Department("maths");

		chemestry.setPersonal(chemestryLectors);
		physics.setPersonal(physicsLectors);
		maths.setPersonal(mathsLectors);

		chemestry.setDepartmentHead(chem1);
		physics.setDepartmentHead(phys1);
		maths.setDepartmentHead(math1);

		manager.persist(chemestry);
		manager.persist(physics);
		manager.persist(maths);

		manager.getTransaction().commit();

		manager.close();
	}

}
