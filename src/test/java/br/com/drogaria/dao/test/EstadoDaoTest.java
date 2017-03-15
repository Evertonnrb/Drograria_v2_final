package br.com.drogaria.dao.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.EstadoDao;
import br.com.drogaria.domain.Estado;

public class EstadoDaoTest {

	@Test
	@Ignore
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("Bahia");
		estado.setSigla("BH");
		EstadoDao dao = new EstadoDao();
		dao.salvar(estado);
		
	}
	@Test
	@Ignore
	public void listar(){
		EstadoDao dao = new EstadoDao();
		List<Estado> lista =  dao.listar();
		
		System.out.println("Total de registros encontrados "+lista.size());
		for(Estado estado : lista){
		System.out.println(estado.getNome()+"\t"+estado.getSigla());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 6L;
		
		EstadoDao dao = new EstadoDao();
		Estado estado = dao.buscar(codigo);
		if(estado!=null){
			System.out.println(estado.getNome()+"\t"+estado.getSigla());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 6L;
		
		EstadoDao dao = new EstadoDao();
		Estado estado = dao.buscar(codigo);
		dao.excluir(estado);
		if(estado!=null){
			System.out.println(estado.getNome()+"\t"+estado.getSigla());
		}
	}
}
