package instead.of.db;

import java.io.Serializable;
import java.util.ArrayList;

import zglola.db.BankEmployee;

@SuppressWarnings("serial")
public class BankEmployeeDB implements Serializable{
	
	
	private static ArrayList<BankEmployee> employeeList = new ArrayList<BankEmployee>();
	public BankEmployeeDB() {
		}
	
	@SuppressWarnings("deprecation")
	public static ArrayList<BankEmployee> getEmployeeList() {
		if(employeeList.size() < 3) {
			employeeList.add(new BankEmployee(0L,"Tison","tito","123@S","01144181789"
					//,new Date ("1-4-1950")
					,"accountant",1L ));
			employeeList.add(new BankEmployee(new Long (1),"Boso","Iron","123456A#","0123456798"
					//,new Date ("2-4-1964")
					,"manager",new Long (1) ));
			employeeList.add(new BankEmployee(new Long (2),"soka","kyfykda","987@H","0129746543"
					//,new Date ("1-4-1980")
					,"sika",new Long (2) ));
		}
		return employeeList;
	}
	
}
