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
			bankEmployee2.setId(1L);
			bankEmployee2.setName("tofa7a");
			bankEmployee2.setUserName("tofa7a");
			bankEmployee2.setMobile("01144181789");
			bankEmployee2.setPosition("manager");
			bankEmployee2.setBankId(1L);
			bankEmployee2.setPassword("123@S");
			////////////////////////
			bankEmployee3.setId(2L);
			bankEmployee3.setName("sokynana");
			bankEmployee3.setUserName("sokynana");
			bankEmployee3.setMobile("01144181789");
			bankEmployee3.setPosition("accountant");
			bankEmployee3.setBankId(1L);
			bankEmployee3.setPassword("123@S");

			employeeList.add(bankEmployee1);
			employeeList.add(bankEmployee2);
			employeeList.add(bankEmployee3);

		}
		return employeeList;
	}

}
