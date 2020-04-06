package batoota.bean;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import n3na3a.service.BankEmployeeService;
import n3na3a.service.ClientService;
import zglola.db.BankEmployee;
import zglola.db.Client;

public class UserValidation implements Serializable {

	public static boolean validateClient(Client client) {
		if (!isValidName(client.getName()))
			return errorNameMsg();

		if (!isValidUsername(client.getUserName()))
			return errorUsernameMsg();

		if (ClientService.usernameIsAlreadyTaken(client.getUserName()))
			return errorUsernameIsTakenMsg();

		
		if (!isValidPassword(client.getPassword()))
			return errorPassMsg();

		if (!isValidEmail(client.getMail()))
			return errorEmailMsg();

		if (!isValidPhoneNumber(client.getMobile()))
			return errorMobileMsg();

		return true;

	}

	public static boolean validateBankEmployee(BankEmployee employee) {
		if (!isValidName(employee.getName()))
			return errorNameMsg();

		if (!isValidUsername(employee.getUserName()))
			return errorUsernameMsg();

		if (BankEmployeeService.usernameIsAlreadyTaken(employee.getUserName()))
			return errorUsernameIsTakenMsg();

		if (!isValidPassword(employee.getPassword()))
			return errorPassMsg();

		if (!isValidPhoneNumber(employee.getMobile()))
			return errorMobileMsg();

		return true;
	}

	public static boolean isValidPhoneNumber(String phoneNo) {
		if (phoneNo == null || phoneNo.trim().equals(""))
			return false;
		for (int i = 0; i < phoneNo.length(); i++) {
			char c = phoneNo.charAt(i);
			if (!((c >= '0' && c <= '9') || c == '+' || c == ' ' || c == '-' || c == '(' || c == ')'))
				return false;
		}
		return true;
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null || email.trim().equals(""))
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isValidName(String name) {
		if (name.equals(null) || name.trim().equals(""))
			return false;
		return true;
	}

	public static boolean isValidUsername(String name) {
		if (name.equals(null) || name.trim().equals("") || name.contains(" "))
			return false;
		return true;
	}

	public static boolean isValidPassword(String password) {
		
		// is 8 or more
		if (!((password.length() >= 8)))
			return false;

		// to check space
		if (password.contains(" ")) {
			return false;
		}

		// contain at least one special character ( @, #, %, &, !, $, etc….).
		if (!(password.contains("@") || password.contains("#") || password.contains("!") || password.contains("~")
				|| password.contains("$") || password.contains("%") || password.contains("^") || password.contains("&")
				|| password.contains("*") || password.contains("(") || password.contains(")") || password.contains("-")
				|| password.contains("+") || password.contains("/") || password.contains(":") || password.contains(".")
				|| password.contains(", ") || password.contains("<") || password.contains(">") || password.contains("?")
				|| password.contains("|"))) {
			return false;
		}
		 // Password should contain at least one uppercase letter(A-Z). Password should
		if (true) {
			int count = 0;

			// checking capital letters
			for (int i = 65; i <= 90; i++) {

				// type casting
				char c = (char) i;

				String str1 = Character.toString(c);
				if (password.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}
//		Password should contain at least one lowercase letter(a-z).
		if (true) {
			int count = 0;

			// checking small letters
			for (int i = 90; i <= 122; i++) {

				// type casting
				char c = (char) i;
				String str1 = Character.toString(c);

				if (password.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}

		return true;
	}

	public static boolean errorMobileMsg() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Mobile is erquired with numbers only!"));
		return false;
	}

	public static boolean errorNameMsg() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Name is missing!"));
		return false;
	}

	public static boolean errorUsernameMsg() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Username is missing or contains space!"));
		return false;
	}

	public static boolean errorUsernameIsTakenMsg() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Username is already taken!"));
		return false;
	}

	public static boolean errorEmailMsg() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Please ener a vaild mail!"));
		return false;
	}

	public static boolean errorPassMsg() {

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Please ener a vaild password!",""));
		return false;
	}

}
