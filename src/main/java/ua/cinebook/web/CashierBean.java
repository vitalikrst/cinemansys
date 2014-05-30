package ua.cinebook.web;

import java.io.Serializable;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

@Named("cashier")
@Scope("session")
public class CashierBean implements Serializable {

	private static final long serialVersionUID = 1L;

}
