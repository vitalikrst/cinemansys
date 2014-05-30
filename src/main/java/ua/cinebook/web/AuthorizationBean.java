package ua.cinebook.web;

import java.io.Serializable;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;


@Named("authorization")
@Scope("session")
public class AuthorizationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String login;
	String password;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String logIn() {
		return null;
		
	}

}
