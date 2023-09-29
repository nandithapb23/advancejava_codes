package springcoree;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//to tell ioc container that instead of xml file we make use of myconfiguration
@ComponentScan(basePackages = "springcoree")//to tell ioc container to create object for a classes within 
//this pacakge
public class Myconfiguration {

}
