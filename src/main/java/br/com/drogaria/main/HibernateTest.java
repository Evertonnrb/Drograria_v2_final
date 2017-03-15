package br.com.drogaria.main;

import org.hibernate.Session;

import br.com.drogaria.util.HibernateUtil;

public class HibernateTest {
	public static void main(String[] args) {
			Session sessao = HibernateUtil.getFabricaSessao().openSession();
	}
}
