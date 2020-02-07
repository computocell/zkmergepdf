package br.com.rodartenogueira.zkspringmodelo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.rodartenogueira.zkspringmodelo.multitenant.CustomRoutingDataSource;
import br.com.rodartenogueira.zkspringmodelo.multitenant.MasterService;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,GsonAutoConfiguration.class })
@ComponentScan(basePackages = "br.com.rodartenogueira.zk")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.rodartenogueira.zkspringmodelo")
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Bean
	public DataSource dataSource() {
		CustomRoutingDataSource customDataSource = new CustomRoutingDataSource();
		customDataSource.setTargetDataSources(MasterService.getDataSourceHashMap());
		return customDataSource;
	}

}
