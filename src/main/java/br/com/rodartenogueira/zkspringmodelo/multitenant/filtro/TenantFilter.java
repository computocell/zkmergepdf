package br.com.rodartenogueira.zkspringmodelo.multitenant.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;


@Component
public class TenantFilter implements Filter {

	private static final String TENANT_HEADER = "banco_entidade";

	@Override
	/**
	 * System.out.println("Volta pro gerenciador e notifica caso não encontrr o header banco_entidade erro");
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// MyServletRequestWrapper httpReq = new
		// MyServletRequestWrapper((HttpServletRequest) request);
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		
		
		//HtmlUnitDriver driver = new HtmlUnitDriver();
		
//		WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
//		LocalStorage localStorage = webStorage.getLocalStorage();
//		SessionStorage sessionStorage = webStorage.getSessionStorage();
//		
		
		
		
		
//		driver.setJavascriptEnabled(true);
//		driver.get("http://localhost:8080/zkspringmodelo/index.zul");
//		System.out.println("Page title is - " + driver.getTitle());
//		System.out.println("Current Url : "+ driver.getCurrentUrl());
//		driver.close();
		
//		WebDriver driver = new JBrowserDriver(Settings.builder() .timezone(Timezone.AMERICA_NEWYORK) .userAgent(UserAgent.CHROME).build());
//		driver.get("http://www.google.com");
//		WebElement element = driver.findElement(By.name("q"));
//		element.sendKeys("Computocell");	
//		element.submit();			
//		System.out.println("Page title is: " + driver.getTitle());
		
//		WebDriver driver = new JBrowserDriver(Settings.builder() .timezone(Timezone.AMERICA_NEWYORK) .userAgent(UserAgent.CHROME).build());
//		driver.get("http://www.google.com");
//		WebElement element = driver.findElement(By.name("q"));
//		element.sendKeys("Computocell");	
//		element.submit();			
//		System.out.println("Page title is: " + driver.getTitle());
//		
//       
//
//		// This code will print the page title		
//       // Locate the searchbox using its name		
////       LocalStorage = driver.
//		JavascriptExecutor javascript = (JavascriptExecutor) driver;
//		String sessionStorage=(String)javascript.executeScript("return window.sessionStorage.getItem(\"banco_entidade\");");  
//		String localStorage=(String)javascript.executeScript("return window.localStorage.getItem(\"banco_entidade\");");  
//
//		System.out.println("Session Storage : "+sessionStorage); 
//		System.out.println("Local Storage   : "+localStorage); 
//
//       
//		
//		driver.quit();
//		
		
		HttpSession session = httpReq.getSession();

		
//		if (httpReq.getHeader("banco_entidade") == null) {
//			TenantContext.setCurrentTenant("0020");//TODO TESTE setar 20 se nao tiver o header definido
//			System.out.println("Volta pro gerenciador e notifica erro");
//
//		}else {
//			TenantContext.setCurrentTenant(httpReq.getHeader("banco_entidade"));
//		}
		
		
//		String tenantHeader = httpRes.getHeader(TENANT_HEADER);
//
//		if (tenantHeader != null && !tenantHeader.isEmpty()) {
//
//			TenantContext.setCurrentTenant(httpReq.getHeader(TENANT_HEADER));
//
//		} 
//		else {
//			httpRes.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//			httpRes.setContentType(MediaType.APPLICATION_JSON_VALUE);
//			httpRes.getWriter().write("{\"erro\": \"Header banco_entidade não foi informado\"}");
//			httpRes.getWriter().flush();
//			
//			TenantContext.setCurrentTenant(null);
//
//			return;
//		}



		chain.doFilter(httpReq, httpRes);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {

		System.out.println("init() method has been get invoked");
		System.out.println("Filter name is " + config.getFilterName());
		System.out.println("ServletContext name is" + config.getServletContext());
		System.out.println("init() method is ended");
	}

	@Override
	public void destroy() {
		Filter.super.destroy();

	}

	
}
