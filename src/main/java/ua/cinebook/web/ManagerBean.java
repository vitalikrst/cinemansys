package ua.cinebook.web;

import java.io.Serializable;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;


@Named("manager")
@Scope("session")
public class ManagerBean implements Serializable {

	private static final long serialVersionUID = 1L;

}
