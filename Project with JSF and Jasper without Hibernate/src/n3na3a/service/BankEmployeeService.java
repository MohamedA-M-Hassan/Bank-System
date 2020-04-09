package n3na3a.service;

import java.io.Serializable;

import instead.of.db.BankEmployeeDB;
import instead.of.db.ClientDB;
import zglola.db.BankEmployee;
import zglola.db.Client;

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
	
	public static Long getNoOfEmployeesInDbToHandleID(){
		return (long) BankEmployeeDB.getEmployeeList().size();
	}
	
	public static void updateBankEmployee() {
		
	}
	public static boolean usernameIsAlreadyTaken(String username)
	{
		for( BankEmployee e : BankEmployeeDB.getEmployeeList())
		{
			if(e.getUserName().equals(username))
				return true;
		}
		return false;
	}

}
