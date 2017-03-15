package br.com.drogaria.dao.test;


import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDao;
import br.com.drogaria.dao.PessoaDao;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Pessoa;

public class FuncionarioDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Long codPessoa = 1L;
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscar(codPessoa);
		
		System.out.println("Funcionario : "+pessoa.getNome());
		
		Funcionario funcionario = new Funcionario();
		funcionario.setPessoa(pessoa);
		funcionario.setCarteiraTrabalho("SSP - 2332");
		funcionario.setDataAdmissao(new Date());
		
		FuncionarioDao dao = new FuncionarioDao();
		dao.salvar(funcionario);
	}
	@Test
	@Ignore
	public void listar(){
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		List<Funcionario> funcionarios = funcionarioDao.listar();
		for(Funcionario f : funcionarios){
			System.out.println(f.getPessoa().getNome());
			System.out.println(f.getCarteiraTrabalho());
			System.out.println(f.getDataAdmissao());
		}
	}
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(codigo);
		System.out.println("Funcionario "+funcionario.getPessoa().getNome());
	}
	@Test
	@Ignore
	public void editar(){
		
		Long codigoFun = 1L;
		Long pessoaCod = 1L;
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(codigoFun);
		
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscar(pessoaCod);
		
		funcionario.setPessoa(pessoa);
		funcionario.setDataAdmissao(new Date());
		funcionario.setCarteiraTrabalho("MSSP - 000011");
		
		funcionarioDao.salvar(funcionario);
	}
	@Test
	@Ignore
	public void excluir(){
		Long cod = 1L;
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(cod);
		funcionarioDao.excluir(funcionario);
		
	}
}
