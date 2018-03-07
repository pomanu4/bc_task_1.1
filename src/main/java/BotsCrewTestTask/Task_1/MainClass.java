package BotsCrewTestTask.Task_1;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import BotsCrewTestTask.Task_1.initializator.Init;
import BotsCrewTestTask.Task_1.meny.MenySimulator;

public class MainClass {
	
	public static void main(String[] args) {
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("test-1");
		
		Init init = new Init(managerFactory);
		init.initDataBase();
		
		MenySimulator simulator = new MenySimulator(managerFactory);
		simulator.activateMeny();
		
		managerFactory.close();
	}

}
