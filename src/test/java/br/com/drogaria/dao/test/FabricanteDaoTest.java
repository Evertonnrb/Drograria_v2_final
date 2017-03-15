package br.com.drogaria.dao.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDao;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDaoTest {

	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setNome("Lec voi");
		fabricante.setDescrisao("Cuidando dos seus cuidados");
		FabricanteDao dao = new FabricanteDao();
		dao.salvar(fabricante);
	}
	@Test
	@Ignore
	public void listar(){
		FabricanteDao dao = new FabricanteDao();
		List<Fabricante> fab = dao.listar();
		for(Fabricante fabricantes : fab){
			System.out.println(fabricantes.getNome()+"\t"+fabricantes.getDescrisao());
		}
	}
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;
		
		FabricanteDao dao = new FabricanteDao();
		Fabricante fabricante = dao.buscar(codigo);
		if(fabricante!=null){
			System.out.println(fabricante.getNome()+"\tencontrado");
		}
	}
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		FabricanteDao dao = new FabricanteDao();
		Fabricante fabricante = dao.buscar(codigo);
		dao.excluir(fabricante);
		if(fabricante!=null){
			System.out.println(fabricante.getNome()+"\t Excluido");
		}
	}
}	
