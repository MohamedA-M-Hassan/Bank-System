package instead.of.db;

import java.util.ArrayList;

import zglola.db.Transaction;

public class TransactionDB {

	private static ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

	public TransactionDB() {
		Transaction transaction = new Transaction();
		transaction.setId(1L);
		transaction.setStatus("Accepted");
		transaction.setDescription("First transaction");
		transaction.setBankEmployeeId(1L);
		transaction.setToAccountId(2L);
		transaction.setFromAccountId(3L);

		Transaction transaction2 = new Transaction();
		transaction2.setId(2L);
		transaction2.setStatus("Accepted");
		transaction2.setDescription("First transaction");
		transaction2.setBankEmployeeId(1L);
		transaction2.setToAccountId(2L);
		transaction2.setFromAccountId(3L);
		transactionList.add(transaction2);
	}

	public static ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	public static void setTransactionList(ArrayList<Transaction> transactionList) {
		TransactionDB.transactionList = transactionList;
	}

}
