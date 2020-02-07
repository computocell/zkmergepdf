package br.com.rodartenogueira.zkspringmodelo.multitenant.datasources;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import lombok.Builder;

public class BuilderDriverManagerDataSource {
	private final static String DATASOURCE_USER_NAME = "system";
	private final static String DATASOURCE_USER_PASSWORD = "systemlog";
	private final static String DATASOURCE_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

	DriverManagerDataSource dataSource;

	@Builder(builderMethodName = "builder")	
	public DriverManagerDataSource gerarSource(String banco) {

		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DATASOURCE_DRIVER_CLASS_NAME);
		dataSource.setUrl("jdbc:mysql://localhost:3306/" + banco);
		dataSource.setUsername(DATASOURCE_USER_NAME);
		dataSource.setPassword(DATASOURCE_USER_PASSWORD);

		return dataSource;
	}
}