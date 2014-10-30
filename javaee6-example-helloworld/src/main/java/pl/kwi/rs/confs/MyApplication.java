package pl.kwi.rs.confs;


import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
	
	public MyApplication() {
		register(new MyApplicationBinder());
        packages(true, "pl.kwi.rests");
    }

}
