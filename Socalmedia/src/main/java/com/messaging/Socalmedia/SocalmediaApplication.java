package com.messaging.Socalmedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@SpringBootApplication

public class SocalmediaApplication {

	static ButtonClass sc;
	static ApplicationContext context;
	public static void main(String[] args) {

		try {
			context= new AnnotationConfigApplicationContext(SocalmediaApplication.class);
			sc=context.getBean("buttonClass",ButtonClass.class);
			sc.setSc("Swap Right");
			socalmedia s=sc.getSc();
			System.out.println(s.start());
			System.out.println(s.messageThrow());
			System.out.println(s.Close());
		}
		catch (Exception e) {
			System.out.println("No Funtionality Avilable");
		}
	}

}
@Configuration
@Component
class ButtonClass{
	@Autowired
	socalmedia sc;
	ApplicationContext context= new AnnotationConfigApplicationContext(SocalmediaApplication.class);
	public void setSc(String s){
		sc=context.getBean(""+s,socalmedia.class);
	}
	public socalmedia getSc() {
		return sc;
	}
}
@Component
interface socalmedia{
	public String start();
	public String messageThrow();
	public  String Close();
}
@Component("Swap Left")
class WhatsApp implements socalmedia{
	@Override
	public String start() {
		return "WhatsApp Start";
	}

	@Override
	public String messageThrow() {
		return "I Have Message Throw WhatsApp";
	}

	@Override
	public String Close() {
		return "WhatsApp Close";
	}
}
@Component("Swap Right")
@Primary
class FaceBook implements socalmedia{
	@Override
	public String start() {
		return "FaceBook Start";
	}

	@Override
	public String messageThrow() {
		return "I Have Message Throw FaceBook";
	}

	@Override
	public String Close() {
		return "FaceBook Close";
	}
}
@Component("Long Press")
class SnapChat implements socalmedia{
	@Override
	public String start() {
		return "SnapChat Start";
	}

	public String  messageThrow() {
		return "I Have Message Throw SnapChat";
	}

	@Override
	public String Close() {
		return "SnapChat Close";
	}
}
@Component("Double Press")
class Linkedin implements socalmedia{
	@Override
	public String start() {
		return "Linkedin Start";
	}

	public String messageThrow() {
		return "I Have Message Throw Linkedin";
	}

	@Override
	public String Close() {
		return "Linedin Close";
	}
}


