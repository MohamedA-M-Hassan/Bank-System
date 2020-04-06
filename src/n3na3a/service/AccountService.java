
package n3na3a.service;

import java.io.Serializable;

import instead.of.db.AccountDB;
import instead.of.db.ClientDB;
import zglola.db.Account;
import zglola.db.Client;
import zglola.db.Transaction;

@SuppressWarnings("serial")
public class AccountService implements Serializable {

	public static void insertAccount(Account account) {

		AccountDB.getAccountList().add(account);
	}

	public static Long getNoOfAccountInDbToHandleID() {
		Account a = new Account();
		a = AccountDB.getAccountList().get(AccountDB.getAccountList().size() - 1);
		return (long) (a.getId() + 1);
	}

	public static Account getAccountByClientByClient(Long clientId) {

		for (Account a : AccountDB.getAccountList()) {
			if (a.getClientId().equals(clientId))
				return a;
		}
		return null;
	}

	public static Account getAccountByAccountId(Long accountId) {

		for (Account a : AccountDB.getAccountList()) {
			if (a.getId() == accountId)
				return a;
		}
		return null;
	}

	public static void updateAccount(Account newAccount) {
		AccountDB.getAccountList().set(AccountDB.getAccountList().indexOf(newAccount), newAccount);
	}

	public static void deleteAccountByClient(Account a) {
		AccountDB.getAccountList().remove(a);
	}

	public static Long getAccountNumberFromTransactionAccountId(Long tranactionAccountId) {
		for (Account a : AccountDB.getAccountList()) {
			if (a.getId() == tranactionAccountId) {
				return a.getAccountNumber();
			}
		}
		return null;
	}

	// call it from Client Service to get best client
	public static Long getBestClientIdWithHigherBlance() {
		Long higherBalance = 0L;
		Long clientId = 0L; // first client
		for (Account a : AccountDB.getAccountList()) {
			if (a.getBalance() > higherBalance) {
				higherBalance = a.getBalance();
				clientId = a.getClientId();
			}
		}
		return clientId;
	}
	///////////////////////

	public static void updateBalanceAndAvailableBalance(Transaction transactionToBeEdited) {

		Account tempAccount = new Account();

		if (transactionToBeEdited.getStatus().equals("Accepted")) {
			// Sender
			// get sender account

			tempAccount = AccountService.getAccountByAccountId(transactionToBeEdited.getFromAccountId());

			if (transactionToBeEdited.getToAccountId() != transactionToBeEdited.getFromAccountId())
				AccountService.handleAccountBalanceNegative(transactionToBeEdited, tempAccount);
			else
				AccountService.handleAccountAvailableBalancePositive(transactionToBeEdited, tempAccount);

			// get receiver
			tempAccount = AccountService.getAccountByAccountId(transactionToBeEdited.getToAccountId());

			if (transactionToBeEdited.getToAccountId() != transactionToBeEdited.getFromAccountId()) {
				AccountService.handleAccountBalancePositive(transactionToBeEdited, tempAccount);
				AccountService.handleAccountAvailableBalancePositive(transactionToBeEdited, tempAccount);
			}

		}

		else {
			// Sender
			// get sender account
			tempAccount = AccountService.getAccountByAccountId(transactionToBeEdited.getFromAccountId());

			if (transactionToBeEdited.getToAccountId() != transactionToBeEdited.getFromAccountId())
				AccountService.handleAccountAvailableBalancePositive(transactionToBeEdited, tempAccount);
			else
				AccountService.handleAccountBalanceNegative(transactionToBeEdited, tempAccount);

		}
	}

	public static void handleAccountAvailableBalanceNegative(Transaction t, Account oldAccount) {
		// Account updatedAccount = oldAccount;
		oldAccount.setAvailableBalance(oldAccount.getAvailableBalance() - t.getAmount());
		updateAccount(oldAccount);
	}

	public static void handleAccountBalanceNegative(Transaction t, Account oldAccount) {
		oldAccount.setBalance(oldAccount.getBalance() - t.getAmount());
		updateAccount(oldAccount);
	}

	public static void handleAccountAvailableBalancePositive(Transaction t, Account oldAccount) {
		// Account updatedAccount = oldAccount;
		oldAccount.setAvailableBalance(oldAccount.getAvailableBalance() + t.getAmount());
		updateAccount(oldAccount);
	}

	public static void handleAccountBalancePositive(Transaction t, Account oldAccount) {
		oldAccount.setBalance(oldAccount.getBalance() + t.getAmount());
		updateAccount(oldAccount);
	}

}
