package n3na3a.service;

import java.io.Serializable;

import instead.of.db.BankEmployeeDB;
import zglola.db.BankEmployee;

@SuppressWarnings("serial")

public class BankEmployeeService implements Serializable {
	public static void insertEmployee(BankEmployee employee) {
	
		BankEmployeeDB.getEmployeeList().add(employee);
	}
	
	public static BankEmployee getEmployeeByUsernameAndPassword(String username,String pass)
	{
		for(BankEmployee e: BankEmployeeDB.getEmployeeList())
		{
			if(e.getUserName().toLowerCase().equals(username.toLowerCase()) && e.getPassword().equals(pass) ) 	return e;
		}
		return null;
	}
	
	public static Long getNoOfClientsInDbToHandleID(){
		return (long) BankEmployeeDB.getEmployeeList().size();
	}
	
	public static void updateBankEmployee() {
		
	}
}
