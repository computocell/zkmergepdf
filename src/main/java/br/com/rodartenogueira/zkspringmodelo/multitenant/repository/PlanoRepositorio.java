package br.com.rodartenogueira.zkspringmodelo.multitenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.rodartenogueira.zkspringmodelo.multitenant.entity.Plano;
@EnableJpaRepositories(basePackageClasses = Plano.class)
public interface PlanoRepositorio extends JpaRepository<Plano, Integer>{
	
	
	
}
