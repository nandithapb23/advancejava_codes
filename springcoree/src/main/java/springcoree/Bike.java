package springcoree;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component//to create object
@Primary//to give the default output
public class Bike implements Item{

	public void used() {
		System.out.println("used to ride");
		
	}

}
