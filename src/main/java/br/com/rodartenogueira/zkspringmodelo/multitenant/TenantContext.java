package br.com.rodartenogueira.zkspringmodelo.multitenant;

public class TenantContext {
	private static ThreadLocal<Object> currentTenant = new ThreadLocal<>();

	public static void setCurrentTenant(Object tenant) {
		currentTenant.set(tenant);
	}

	
	public static Object getCurrentTenant() {
		return currentTenant.get();
	}
}
