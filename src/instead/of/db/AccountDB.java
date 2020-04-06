package instead.of.db;

import java.io.Serializable;
import java.util.ArrayList;

import zglola.db.Account;

public class AccountDB implements Serializable{
	
	private static ArrayList<Account> accountList = new ArrayList<Account>();

	@SuppressWarnings("deprecation")
	public static ArrayList<Account> getAccountList() {

		if (accountList.size() < 3) {
			accountList.add(new Account(0L, 200L, 200L, 0L,123456L));
			accountList.add(new Account(1L, 200L, 200L ,1L,897654L));
			accountList.add(new Account(2L, 200L, 200L ,2L,159482L));
		}
		return accountList;
	}
}