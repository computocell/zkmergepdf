package br.com.rodartenogueira.zkspringmodelo.multitenant;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
//		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); // get request object
		
		
//		if (attr != null) {
//			String tenantId = attr.getRequest().getParameter("tenantId"); // find parameter from request
//			return tenantId;
//		} else {
//			return "tenantId2"; // default data source

		return TenantContext.getCurrentTenant() != null ? TenantContext.getCurrentTenant() : "0020";
		
		}
	
	// private final String DEFAULT_SCHEMA = "DEFAULT_SCHEMA";
	// @Override
	// protected Object determineCurrentLookupKey() {
	// ServletRequestAttributes attr = (ServletRequestAttributes)
	// RequestContextHolder.getRequestAttributes();
	//
	// if(attr!=null) {
	// String tenantId = attr.getRequest().getParameter("tenantId"); // find
	// parameter from request
	// return tenantId;
	// }else{
	// return "DEFAULT_SCHEMA"; // default data source
	// }
	// }

}
