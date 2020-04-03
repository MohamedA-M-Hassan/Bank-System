
package n3na3a.service;

import java.io.Serializable;

import instead.of.db.AccountDB;
import zglola.db.Account;


@SuppressWarnings("serial")

public class AccountService implements Serializable {
	
	public static void insertAccount(Account account) {
		
		AccountDB.getAccountList().add(account);
	}
	
	public static Long getNoOfAccountInDbToHandleID(){
		Account a = new Account();
		a = AccountDB.getAccountList().get(AccountDB.getAccountList().size()-1);
		return (long) (a.getId()+1);
	}
	
	public static Account getAccountByClientId(Long clientId)
	{
		for (Account a:AccountDB.getAccountList()) {
			if(a.getClientId() == clientId)
				return a;
		}
		return null;
	}
	
	public static void updateAccount(Account a)
	{
		AccountDB.getAccountList().set(AccountDB.getAccountList().indexOf(a), a);
	}
	
	public static void deleteAccountByClient(Account a) {
		AccountDB.getAccountList().remove(a);
	}
}
