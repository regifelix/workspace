package br.com.regifelix;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Principal {

	// assumes the current class is called logger
	private final static Logger LOGGER = Logger.getLogger(Principal.class.getName());

	public static void main(String[] args) {
		
		System.out.println(System.getProperty("java.class.path"));
		
        
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring-config.xml");
	
		FonteDados fonte = (FonteDados) context.getBean("fonteDados");
		fonte.teste();

	}

}