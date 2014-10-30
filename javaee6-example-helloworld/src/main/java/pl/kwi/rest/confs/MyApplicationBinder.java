package pl.kwi.rest.confs;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import pl.kwi.services.NameService;
import pl.kwi.validators.InputValidator;

public class MyApplicationBinder extends AbstractBinder{

	@Override
	protected void configure() {
		bind(NameService.class).to(NameService.class);
		bind(InputValidator.class).to(InputValidator.class);
	}

}
