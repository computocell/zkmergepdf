package br.com.rodartenogueira.zkspringmodelo.viewmodel;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import br.com.rodartenogueira.zkspringmodelo.multitenant.TenantContext;
import br.com.rodartenogueira.zkspringmodelo.multitenant.entity.Plano;
import br.com.rodartenogueira.zkspringmodelo.multitenant.repository.PlanoRepositorio;
import lombok.Getter;

@Controller("/")
@VariableResolver(DelegatingVariableResolver.class)
public class VmIndex implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@WireVariable
	private PlanoRepositorio planoRepositorio;
	
	
	
	@Getter
	private List<Plano> lsPlanos;

	@Init
	public void init(@RequestParam(value = "id", required = false) String id) {

		TenantContext.setCurrentTenant("0017");
		lsPlanos = planoRepositorio.findAll();
		
		System.out.println("Qtd planos " + lsPlanos.size());
		

	}

	@RequestMapping("/plano")
	public String teste(@RequestParam(value = "id", required = false) String idplano) {
		TenantContext.setCurrentTenant("0018");
		System.out.println("qtd planos " + planoRepositorio.count());
	

		return "index";
	}

}
