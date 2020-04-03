package instead.of.db;

import java.io.Serializable;
import java.util.ArrayList;

import zglola.db.Client;

@SuppressWarnings("serial")
public class ClientDB implements Serializable {

	private static ArrayList<Client> clientList = new ArrayList<Client>();

	public ClientDB() {
	}

	public static ArrayList<Client> getClientList() {

		if (clientList.size() < 3) {
			Client client = new Client();
			Client client2 = new Client();
			Client client3 = new Client();
			/////////////////////////////
			client.setId(1L);
			client.setName("Mohamed");
			client.setUserName("mo");
			client.setPassword("123@S");
			client.setMobile("01144181789");
			client.setMail("mohamed@mail.com");
			client.setAddress("nasr city");
			client.setBankId(1L);
			client.setNetSalary(100L);
			///////////////////////////////
			client2.setId(2L);
			client2.setName("Sral");
			client2.setUserName("sral");
			client2.setPassword("123456A#");
			client2.setMobile("0123456798");
			client2.setMail("siko@mail.com");
			client2.setAddress("bait elwatan");
			client2.setBankId(1L);
			client2.setNetSalary(999L);

			////////////////////////////////////
			client3.setId(3L);
			client3.setName("Shaf");
			client3.setUserName("anosh");
			client3.setPassword("987@H");
			client3.setMobile("0129746543");
			client3.setMail("sombol@mail.com");
			client3.setAddress("Giza");
			client3.setBankId(1L);
			client3.setNetSalary(900L);
			//////////////////////////////////////
			clientList.add(client);
			clientList.add(client2);
			clientList.add(client3);

		}
		return clientList;
	}
}
