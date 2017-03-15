package br.com.drogaria.dao.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDao;
import br.com.drogaria.dao.ProdutoDao;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDaoTest {
	@Test
	@Ignore
	public void salvar() {
		Long CodFabricante = 4L;

		FabricanteDao fabricanteDao = new FabricanteDao();
		Fabricante fabricante = fabricanteDao.buscar(CodFabricante);

		System.out.println(fabricante.getNome());

		ProdutoDao produtoDao = new ProdutoDao();

		Produto produto = new Produto();

		produto.setDescrisao("Sempre Livre");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal(3.49));
		produto.setQuantidade(new Short("300"));
		produtoDao.salvar(produto);
		System.out.println("Produto salvo " + produto.getDescrisao());
	}

	@Test
	@Ignore
	public void listar() {

		ProdutoDao dao = new ProdutoDao();
		List<Produto> produtos = dao.listar();
		for (Produto p : produtos) {
			System.out.println(p.getDescrisao() + " " + p.getFabricante().getNome());
		}

	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;
		
		ProdutoDao dao = new ProdutoDao();
		Produto produto = dao.buscar(codigo);
		if(produto!=null){
			System.out.println(" "+produto.getDescrisao());
		}else{
			System.out.println("Produto nao encontrado");
		}
	}
	@Test
	@Ignore
	public void editar(){
		Long codFab = 3L;
		FabricanteDao fabDao = new FabricanteDao();
		Fabricante fabricante = fabDao.buscar(codFab);
		System.out.println("Fabricante "+fabricante.getNome());
		
		Long codigo = 1L;
		ProdutoDao dao = new ProdutoDao();
		Produto produto = dao.buscar(codigo);
		produto.setDescrisao("Camisinha sabor limão");
		produto.setFabricante(fabricante);
		
		dao.salvar(produto);
	}
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L;
		ProdutoDao dao = new ProdutoDao();
		
		Produto produto = dao.buscar(codigo);
		dao.excluir(produto);
	}
}
