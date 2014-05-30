package ua.cinebook.web;

import java.io.Serializable;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;


@Named("authorization")
@Scope("session")
public class AuthorizationBean implements Serializable {

	private static final long serialVersionUID = 1L;

}
