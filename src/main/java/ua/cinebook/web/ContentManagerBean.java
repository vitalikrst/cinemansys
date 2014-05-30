package ua.cinebook.web;

import java.io.Serializable;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

@Named("contentManager")
@Scope("session")
public class ContentManagerBean implements Serializable {

	private static final long serialVersionUID = 1L;

}
