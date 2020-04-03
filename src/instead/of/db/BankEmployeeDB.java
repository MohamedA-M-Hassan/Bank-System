package instead.of.db;

import java.io.Serializable;
import java.util.ArrayList;

import zglola.db.BankEmployee;

@SuppressWarnings("serial")
public class BankEmployeeDB implements Serializable {

	private static ArrayList<BankEmployee> employeeList = new ArrayList<BankEmployee>();

	public BankEmployeeDB() {
	}

	public static ArrayList<BankEmployee> getEmployeeList() {

		if (employeeList.size() < 3) {
			BankEmployee bankEmployee1 = new BankEmployee();
			BankEmployee bankEmployee2 = new BankEmployee();
			BankEmployee bankEmployee3 = new BankEmployee();
			//////////////////////////////////////////
			bankEmployee1.setId(0L);
			bankEmployee1.setName("Tison");
			bankEmployee1.setUserName("tito");
			bankEmployee1.setMobile("01144181789");
			bankEmployee1.setPosition("accountant");
			bankEmployee1.setBankId(1L);
			bankEmployee1.setPassword("123@S");
			/////////////////////////////////////////

			employeeList.add(bankEmployee1);
			employeeList.add(bankEmployee2);
			employeeList.add(bankEmployee3);

		}
		return employeeList;
	}

}
