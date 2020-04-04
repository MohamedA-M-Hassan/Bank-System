package n3na3a.service;

import java.io.Serializable;
import java.util.ArrayList;

import instead.of.db.AccountDB;
import instead.of.db.TransactionDB;
import zglola.db.Account;
import zglola.db.Transaction;

@SuppressWarnings("serial")

public class TransactionService implements Serializable {
	
	public static void addTransaction(Transaction transaction) {

		TransactionDB.getTransactionList().add(transaction);
	}

	public static void updateTransaction(Transaction transaction) {

	}
	
	public static ArrayList<Transaction> getTransactionsByAccountId(Long accountId) {		
		
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		for (Transaction t:TransactionDB.getTransactionList()) {
			if(t.getToAccountId() == accountId || t.getFromAccountId() == accountId)
				transactionList.add(t);
		}
		return transactionList;
	}
	
	
	// TODO improve the below code
	public static ArrayList<Transaction> transactionListToDislpyWithAccountNo (ArrayList<Transaction> transactionList)
	{
		ArrayList<Transaction> transactionswithAccountNumbersforDisply = transactionList;
		Long temp;
		/*for (int i = 0; i < array.length; i++) {
			
		}*/
		for (Transaction t: transactionswithAccountNumbersforDisply) {
			temp = t.getToAccountId();
			t.setToAccountId(AccountService.getAccountNumberFromTransactionAccountId(temp));
			temp = t.getFromAccountId();
			t.setFromAccountId(AccountService.getAccountNumberFromTransactionAccountId(temp));
			// update :D
			transactionswithAccountNumbersforDisply.set(transactionswithAccountNumbersforDisply.indexOf(t), t);
		}
		return transactionswithAccountNumbersforDisply;
	}
}
