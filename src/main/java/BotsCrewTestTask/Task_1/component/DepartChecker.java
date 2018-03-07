package BotsCrewTestTask.Task_1.component;

public class DepartChecker {
	
	public static boolean existDepartment(String department) {
		if(department.toLowerCase().equals("chemestry")
			|| department.toLowerCase().equals("physics")
			||department.toLowerCase().equals("maths")) {
			return true;
		}else {
			return false;
		}
	}
}
