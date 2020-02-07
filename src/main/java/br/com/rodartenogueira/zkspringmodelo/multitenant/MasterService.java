package br.com.rodartenogueira.zkspringmodelo.multitenant;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.rodartenogueira.zkspringmodelo.multitenant.datasources.BuilderDriverManagerDataSource;


public class MasterService {

	public static Map<Object, Object> getDataSourceHashMap() {

		// DriverManagerDataSource dataSource_0020 = new DriverManagerDataSource();
		// dataSource_0020.setDriverClassName(DATASOURCE_DRIVER_CLASS_NAME);
		// dataSource_0020.setUrl("jdbc:mysql://localhost:3306/0020");
		// dataSource_0020.setUsername(DATASOURCE_USER_NAME);
		// dataSource_0020.setPassword(DATASOURCE_USER_PASSWORD);
		//
		HashMap<Object, Object> mpDataSources = new LinkedHashMap<>();
		
		for (int i = 01; i < 100; i++) {
			String numeroFormatoBanco = "00" + String.format("%02d", i);
			mpDataSources.put(numeroFormatoBanco, new BuilderDriverManagerDataSource().builder().banco(numeroFormatoBanco).build());
		}
		
		return mpDataSources;
	}

}


