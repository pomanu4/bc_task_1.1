package BotsCrewTestTask.Task_1.dao;

public interface IdepartmentDAO {
	
	String showDepartmentHead(String depName);
	
	String showDepartmentStatistic(String depName);
	
	String showAverageDepartmentSalary(String depName);
	
	String showCountOfEmployee(String depName);
	
	String searchByPattern(String pattern);
	
	

}
