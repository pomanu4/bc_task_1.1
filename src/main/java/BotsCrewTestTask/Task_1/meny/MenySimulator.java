package BotsCrewTestTask.Task_1.meny;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import BotsCrewTestTask.Task_1.Implementation.DepartmentDAO;
import BotsCrewTestTask.Task_1.component.DepartChecker;
import BotsCrewTestTask.Task_1.component.PatternResutChecker;
import BotsCrewTestTask.Task_1.dao.IdepartmentDAO;

public class MenySimulator {
	
	EntityManagerFactory managerFactory = null;
	
	
	
	public MenySimulator(EntityManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

	private IdepartmentDAO dao;
	
	public void activateMeny() {
		Scanner scan = new Scanner(System.in);
		dao = new DepartmentDAO(managerFactory);
		while(true) {
			String num = "";
			String text="";
			System.out.println("ДОСТУПНІ ТАКІ ОПЕРАЦІЇ :");
			System.out.println("----------------------------------------------");
			System.out.println("There are three departments in university : chemestry, physics, maths");
			System.out.println();
			System.out.println("1. Who is head of department");
			System.out.println("2. Show department statistic.");
			System.out.println("3. Show the average salary for department");
			System.out.println("4. Show count of employee for department");
			System.out.println("5. Global search by template");
			System.out.println("0. Exit");
			System.out.println("----------------------------------------------");
			System.out.println("ВИБЕРІТЬ ПУНКТ МЕНЮ");
			num = scan.nextLine();
			
			switch (num) {
			case "1":
				System.out.println("chose department name ");
				String dep = scan.nextLine();
				if(DepartChecker.existDepartment(dep)) {
					text = dao.showDepartmentHead(dep);
					System.out.println();
					System.out.println("*****************************");
					System.out.println(text);
					System.out.println("*****************************");
					System.out.println();
				}else {
					System.out.println();
					System.out.println("*****************************");
					System.out.println("no such department");
					System.out.println("*****************************");
					System.out.println();
				}
				break;
			case "2":
				System.out.println("chose department name ");
				String dep1 = scan.nextLine();
				if(DepartChecker.existDepartment(dep1)) {
					text = dao.showDepartmentStatistic(dep1);
					System.out.println();
					System.out.println("*****************************");
					System.out.println(text);
					System.out.println("*****************************");
					System.out.println();
				}else {
					System.out.println();
					System.out.println("*****************************");
					System.out.println("no such department");
					System.out.println("*****************************");
					System.out.println();
				}
				break;
			case "3":
				System.out.println("chose department name ");
				String dep2 = scan.nextLine();
				if(DepartChecker.existDepartment(dep2)) {
					text = dao.showAverageDepartmentSalary(dep2);
					System.out.println();
					System.out.println("*****************************");
					System.out.println(text);
					System.out.println("*****************************");
					System.out.println();
				}else {
					System.out.println();
					System.out.println("*****************************");
					System.out.println("no such department");
					System.out.println("*****************************");
					System.out.println();
				}
				break;
			case "4":
				System.out.println("chose department name ");
				String dep3 = scan.nextLine();
				if(DepartChecker.existDepartment(dep3)) {
					text = dao.showCountOfEmployee(dep3);
					System.out.println();
					System.out.println("*****************************");
					System.out.println(text);
					System.out.println("*****************************");
					System.out.println();
				}else {
					System.out.println();
					System.out.println("*****************************");
					System.out.println("no such department");
					System.out.println("*****************************");
					System.out.println();
				}
				break;
			case "5":
				System.out.println("chose pattern for search ");
				String dep4 = scan.nextLine();
				String answer = dao.searchByPattern(dep4);
				if(PatternResutChecker.anyMaches(answer)) {
					text = answer;
					System.out.println();
					System.out.println("*****************************");
					System.out.println(text);
					System.out.println("*****************************");
					System.out.println();
				}else {
					System.out.println();
					System.out.println("*****************************");
					System.out.println("no analogy found");
					System.out.println("*****************************");
					System.out.println();
				}				
				break;
			case "0":
				scan.close();
				return;
			default:
				break;
			}
			
		}	
	}
}
