package br.com.drogaria.dao.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.CidadeDao;
import br.com.drogaria.dao.PessoaDao;
import br.com.drogaria.domain.Cidade;
import br.com.drogaria.domain.Pessoa;

public class PessoaDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Long codigoCidade = 3L;
		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.buscar(codigoCidade);
		
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Brunna surfistinha");
		pessoa.setRg("223323");
		pessoa.setCpf("122121");
		pessoa.setEmail("bb69@gmail.com");
		pessoa.setCidade(cidade);
		pessoa.setBairro("Alvez");
		pessoa.setNumero(new Short("123"));
		pessoa.setCelular("99090-91232");
		pessoa.setRua("Tabatta");
		pessoa.setCep("2121");
		
		PessoaDao dao = new PessoaDao();
		dao.salvar(pessoa);
	}
	@Test
	@Ignore
	public void listar(){
		PessoaDao pessoaDao = new PessoaDao();
		List<Pessoa> pessoas = pessoaDao.listar();
		for(Pessoa p:pessoas){
			System.out.println(p.getNome());
			System.out.println(p.getCidade().getNome());
			System.out.println(p.getCidade().getEstado().getNome());
		}
	}
	@Test
	@Ignore
	public void buscar(){
		
		Long codigo = 1L;
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscar(codigo);
		System.out.println(":: "+pessoa.getNome());
	}
	@Test
	public void editar(){
		Long codigo = 1L;
		
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscar(codigo);
		
		pessoa.setNome("Bruuna Surfistinha");
		
		pessoaDao.salvar(pessoa);
	}
}
