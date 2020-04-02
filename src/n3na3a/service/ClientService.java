package n3na3a.service;
import java.io.Serializable;

import zglola.db.Client;
import instead.of.db.ClientDB;


@SuppressWarnings("serial")
public class ClientService implements Serializable{

	
	
	
	// static [after db]
	
	public static void insertClient(Client client) {
		
		ClientDB.getClientList().add(client);
	}
	
	public static void updateClient() {
		
	}
	
}
