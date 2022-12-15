package ecommmerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.boot.CommandLineRunner;
 
@SpringBootApplication
@PropertySource(value = { "classpath:secret.properties" })
@EnableConfigurationProperties(value = { Secret.class })
public class EcommerceApi implements CommandLineRunner{
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(EcommerceApi.class, args);
		
		//Secret secretProperties = configurableApplicationContext.getBean(Secret.class);
		//System.out.println(secretProperties);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
