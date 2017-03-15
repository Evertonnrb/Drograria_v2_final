package br.com.drogaria.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.drogaria.util.HibernateUtil;

public class GenricDao <Entidade>{
	//API reflection para parametrizar a entidade e enxengaa a classe filha
	private Class<Entidade> classe;
	
	
//API reflection	

	@SuppressWarnings("unchecked")
	public GenricDao() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}



	public void salvar(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaSessao().openSession();
		org.hibernate.Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException e) {
			if(transacao!=null) transacao.rollback();
			throw e;
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(){
		Session sessao = HibernateUtil.getFabricaSessao().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		}finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo){
		Session sessao = HibernateUtil.getFabricaSessao().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado =(Entidade) consulta.uniqueResult();
			return resultado;
						
		} catch (RuntimeException e) {
			throw e;
		}finally {
			sessao.close();
		}
	}
	
	public void excluir(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaSessao().openSession();
		Transaction trasacao = null;
		try {
			trasacao = sessao.beginTransaction();
			sessao.delete(entidade);
			trasacao.commit();
		} catch (RuntimeException e) {
			if(trasacao!=null){ 
				trasacao.rollback();
			}
			throw e;
		}finally {
			sessao.close();
		}
	}
}
