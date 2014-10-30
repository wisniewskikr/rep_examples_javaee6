package pl.kwi.rs.confs;


import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
	
	public MyApplication() {
        packages(true, "pl.kwi");
    }

}
