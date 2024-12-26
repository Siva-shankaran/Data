package com.example.demo.utility;
import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.Model.Clients;
import com.example.demo.Model.Users;

@Component
public class Utility_Class {

	public <T> List<T> maskentities(List<T> entities) {
		for (T entity : entities) {
			maskfield(entity);
		}

		return entities;
	}

	private <T> void maskfield(T entity) {
		Class<?> claZZ = entity.getClass();
		Field[] fields = claZZ.getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object value = field.get(entity);

				if (value instanceof String) {
					String fieldvalue = (String) value;

					if (field.getName().toLowerCase().contains("phone") && fieldvalue.length() == 10) {
						field.set(entity, fieldvalue.subSequence(0, 3) + "XXXX" + fieldvalue.substring(7));
					} else if (field.getName().toLowerCase().contains("mail") && fieldvalue.contains("@")) {
						int index = fieldvalue.indexOf("@");
						field.set(entity, fieldvalue.substring(0, 3) + "*****" + fieldvalue.substring(index));
					} else if (field.getName().toLowerCase().contains("password")) {
						field.set(entity, "####*****");
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * //Methods to data Masking for phone
	 * 
	 * public String MaskPhone(String phone) { if(phone != null &&
	 * phone.length()==10) { return phone.substring(0,
	 * 3)+"*****"+phone.substring(8); } return phone; }
	 * 
	 * //Methods to data Masking for email
	 * 
	 * public String MaskEmail(String mail) { if(mail != null && mail.contains("@")
	 * && mail.length()>5) { int index = mail.indexOf("@"); return mail.substring(0,
	 * 3)+"*****"+mail.substring(index); } return mail; }
	
	// Methods to data Masking for password

	public String Maskpassword(String password) {
		if (password != null) {
			int index = password.length();
			return password.substring(0, 0) + "This is Sensitive Content" + password.substring(index);
		}
		return password;
	}
 */
}
