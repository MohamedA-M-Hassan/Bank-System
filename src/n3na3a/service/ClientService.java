package n3na3a.service;

import java.io.Serializable;

import instead.of.db.ClientDB;
import zglola.db.Client;

@SuppressWarnings("serial")
public class ClientService implements Serializable {

	public static void insertClient(Client client) {

		ClientDB.getClientList().add(client);
	}

	public static Client getClientByEmailAndPassword(String mail, String pass) {
		for (Client c : ClientDB.getClientList()) {
			if (c.getMail().toLowerCase().equals(mail.toLowerCase()) && c.getPassword().equals(pass))
				return c;
		}
		return null;
	}

	public static Long getNoOfClientsInDbToHandleID() {
		return (long) ClientDB.getClientList().size();
	}

	public static void updateClient() {

	}

}
