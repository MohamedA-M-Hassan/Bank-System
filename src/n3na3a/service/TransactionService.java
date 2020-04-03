package n3na3a.service;

import java.io.Serializable;

import instead.of.db.TransactionDB;
import zglola.db.Transaction;

@SuppressWarnings("serial")

public class TransactionService implements Serializable {
	public static void addTransaction(Transaction transaction) {

		TransactionDB.getTransactionList().add(transaction);
	}

	public static void updateTransaction(Transaction transaction) {

	}

}
