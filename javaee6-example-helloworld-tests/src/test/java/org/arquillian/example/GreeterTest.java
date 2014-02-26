package org.arquillian.example;

import java.io.File;

import javax.inject.Inject;
 


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.kwi.tmp.Tmp;
 
@RunWith(Arquillian.class)
public class GreeterTest {
     
    @Inject
//    Tmp greeter;
     
    @Deployment
    public static WebArchive createDeployment() {
        File[] lib = Maven.resolver()
                .resolve("org.jboss.weld.servlet:weld-servlet:2.1.0.Final")
                .withTransitivity().as(File.class);
         
        WebArchive jar =  ShrinkWrap.create(WebArchive.class)
            .addClass(Tmp.class)
            .addAsManifestResource("arquillian.xml")
            .addAsLibraries(lib)
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .setWebXML("web.xml")
            ;
         
        System.out.println(jar.toString(true));
         
        return jar;
    }
     
    @Test
    public void should_create_greeting() {
        
    }
}
