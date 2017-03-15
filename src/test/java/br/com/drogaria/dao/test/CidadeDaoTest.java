package br.com.drogaria.dao.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.CidadeDao;
import br.com.drogaria.dao.EstadoDao;
import br.com.drogaria.domain.Cidade;
import br.com.drogaria.domain.Estado;

public class CidadeDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		EstadoDao  estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(5L);
		System.out.println(estado.getNome());
		Cidade cidade = new Cidade();
		cidade.setNome("Muriae");
		cidade.setEstado(estado);

		CidadeDao cidadeDao = new CidadeDao();
		cidadeDao.salvar(cidade);
	}
	@Test
	@Ignore
	public void listar(){
		CidadeDao cidadeDao = new CidadeDao();
		List<Cidade> cidade = cidadeDao.listar();
		for(Cidade cidades : cidade ){
			System.out.println("\tCodigo :"+cidades.getCodigo());
			System.out.println("\tNome :"+cidades.getNome());
			System.out.println("\tSigla :"+cidades.getEstado().getSigla());
			System.out.println("\tEstado : "+cidades.getEstado().getNome());
			System.out.println("");
		}
	}
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.buscar(codigo);
		System.out.println(cidade.getNome());
	}
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 7L;
		CidadeDao dao = new CidadeDao();
		Cidade cidade = dao.buscar(codigo);
		if(cidade!=null){
		dao.excluir(cidade);	
		}else{
			System.out.println("Cidade não encontrada");
		}
		
		System.out.println(cidade.getNome()+" cidade excluida");
	}
	@Test
	@Ignore
	public void editar(){
		Long codigoCidade = 5L;
		Long codigoEstado = 5L;
		
		CidadeDao dao = new CidadeDao();
		Cidade cidade  = dao.buscar(codigoCidade);
		
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(codigoEstado);
		
		System.out.println("Estado a ser editado "+cidade.getEstado().getNome());
		System.out.println("Cidade a ser editada "+cidade.getNome());
		
		estado.setNome("Paraná");
		cidade.setNome("Guarapuava");
		
		
	}
}
