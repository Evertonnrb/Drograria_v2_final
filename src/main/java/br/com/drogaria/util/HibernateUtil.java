package br.com.drogaria.util;

import javax.sound.sampled.ReverbType;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static  SessionFactory fabricaSessao = criarFabricaDeSessoes();
	
	private static SessionFactory criarFabricaDeSessoes(){
		try {
			Configuration confiracao = new Configuration().configure();
			ServiceRegistry registro = new StandardServiceRegistryBuilder()
					.applySettings(confiracao.getProperties())
					.build();
			
			SessionFactory fabrica = confiracao.buildSessionFactory(registro);
			return fabrica;
		} catch (Throwable e) {
			System.err.println(" A fabrica nao pode ser criada "+e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getFabricaSessao() {
		return fabricaSessao;
	}
}
