package n3na3a.service;

import java.io.Serializable;
import java.util.ArrayList;

import instead.of.db.AccountDB;
import instead.of.db.ClientDB;
import instead.of.db.TransactionDB;
import zglola.db.Account;
import zglola.db.Transaction;

@SuppressWarnings("serial")

public class TransactionService implements Serializable {

	public static void addTransaction(Transaction transaction) {

		TransactionDB.getTransactionList().add(transaction);
	}

	public static void updateTransaction(Transaction transaction) {
			TransactionDB.getTransactionList().set(TransactionDB.getTransactionList().indexOf(transaction), transaction);
	}

	public static ArrayList<Transaction> getAllTransactions(){
		return TransactionDB.getTransactionList();
	}
	
	
	public static ArrayList<Transaction> getTransactionsByAccountId(Long accountId) {

		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		for (Transaction t : TransactionDB.getTransactionList()) {
			if (t.getToAccountId() == accountId || t.getFromAccountId() == accountId)
				transactionList.add(t);
		}
		return transactionList;
	}

	// TODO improve the below code
	public static ArrayList<Transaction> transactionListToDislpyWithAccountNo(ArrayList<Transaction> transactionList) {
		ArrayList<Transaction> transactionswithAccountNumbersforDisply = transactionList;
		Long temp;
		/*
		 * for (int i = 0; i < array.length; i++) {
		 * 
		 * }
		 */
		for (Transaction t : transactionswithAccountNumbersforDisply) {
			temp = t.getToAccountId();
			t.setToAccountId(AccountService.getAccountNumberFromTransactionAccountId(temp));
			temp = t.getFromAccountId();
			t.setFromAccountId(AccountService.getAccountNumberFromTransactionAccountId(temp));
			// update :D
			transactionswithAccountNumbersforDisply.set(transactionswithAccountNumbersforDisply.indexOf(t), t);
		}
		return transactionswithAccountNumbersforDisply;
	}
	public static Long getNoOfTransactions() {
		return (long) TransactionDB.getTransactionList().size();
	}
	
	public static Long getNoOfPendingTransactions() {
		Long noOfPendingTransactions =0L;
		for(Transaction t : TransactionDB.getTransactionList())
		{
			if(t.getStatus().equals("Pending")) noOfPendingTransactions += 1;
		}
		return noOfPendingTransactions;
	}
	public static Long getTotalNumberOfTransactionsSubmitedByCurrentEmployee(Long employeeId) {
		Long totalNumber= 0L;
		
		for(Transaction t : TransactionDB.getTransactionList())
		{
			if(t.getBankEmployeeId() == employeeId) 
				totalNumber += 1;
		}
		return totalNumber;
	}
}
