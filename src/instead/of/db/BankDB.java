package instead.of.db;

import java.io.Serializable;
import java.util.ArrayList;

import zglola.db.Bank;

public class BankDB implements Serializable {

	private static ArrayList<Bank> bankList = new ArrayList<Bank>();

	public BankDB() {
	}

	public static ArrayList<Bank> getBankList() {

		if (bankList.size() < 3) {
			Bank bank1 = new Bank();
			Bank bank2 = new Bank();
			Bank bank3 = new Bank();
			//////////////////////////////////////////
			bank1.setId(0L);
			bank1.setBranchAddress("A5r Elshar3");	
			////////////////////////
			bank1.setId(0L);
			bank1.setBranchAddress("Cairo");
			////////////////////////
			bank1.setId(0L);
			bank1.setBranchAddress("Mozambiq");
			////////////////////////
			bankList.add(bank1);
			bankList.add(bank2);
			bankList.add(bank3);
		}
		return bankList;
	}
}
