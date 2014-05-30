package ua.cinebook.web;

import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import ua.cinebook.service.CustomerService;

@Named("customer")
@Scope("session")
public class CustomerBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	CustomerService cservice;


}
