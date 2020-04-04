package instead.of.db;

import java.util.ArrayList;

import zglola.db.Transaction;

public class TransactionDB {

	private static ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

	public TransactionDB() {
		
	}

	public static ArrayList<Transaction> getTransactionList() {
		if (transactionList.size() < 3) {

		Transaction transaction = new Transaction();
		transaction.setId(1L);
		transaction.setStatus("Accepted");
		transaction.setDescription("First transaction");
		transaction.setBankEmployeeId(1L);
		transaction.setToAccountId(0L);
		transaction.setFromAccountId(2L);
		transaction.setAmount(150L);
		
		transactionList.add(transaction);
		
		Transaction transaction2 = new Transaction();
		transaction2.setId(0L);
		transaction2.setStatus("Pending");
		transaction2.setDescription("Sec transaction");
		transaction2.setBankEmployeeId(1L);
		transaction2.setToAccountId(2L);
		transaction2.setFromAccountId(0L);
		transaction2.setAmount(300L);
		transactionList.add(transaction2);

		Transaction transaction3 = new Transaction();
		transaction3.setId(2L);
		transaction3.setStatus("Pending");
		transaction3.setDescription("Third transaction");
		transaction3.setBankEmployeeId(1L);
		transaction3.setToAccountId(2L);
		transaction3.setFromAccountId(1L);
		transaction3.setAmount(300L);
		transactionList.add(transaction3);
		}
		return transactionList;
	}

	public static void setTransactionList(ArrayList<Transaction> transactionList) {
		TransactionDB.transactionList = transactionList;
	}

}
