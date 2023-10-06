package br.com.tech4me.cadastrosms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CadastrosMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastrosMsApplication.class, args);
	}

}
