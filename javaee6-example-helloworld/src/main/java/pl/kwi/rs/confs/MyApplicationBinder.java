package pl.kwi.rs.confs;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import pl.kwi.services.NameService;

public class MyApplicationBinder extends AbstractBinder{

	@Override
	protected void configure() {
		bind(NameService.class).to(NameService.class);
	}

}
