package ec.wiwaclinic.vista.bean;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("viewMyBean")
public class MyBean {

	public MyBean() {
		System.out.println("Created!");
	}

	public String getFrom() {
		return this.toString();
	}

	public String getDate() {
		return new Date().toString();
	}

}
