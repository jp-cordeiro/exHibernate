package com.exHibernate.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

//Classe responsável por instanciar a SessionFactory do Hibernate e retorná-la quando solicitado.
public class HibenateUtil {

	//O objeto sessionFactory ira receber o retorno do método buildSessionFactory().
	private static final SessionFactory sessionFactory = buildSessionFactory();

	//Método resposável por criar uma SessionFactory com base no arquivo 'configure.cfg.xml'
	private static SessionFactory buildSessionFactory() {
		try{
			//Configuração sendo iniciada
			Configuration cfg = new Configuration();
			//Arquivo 'hibernate.cfg.xml' sendo passado como parâmetro.
			cfg.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
			registradorServico.applySettings(cfg.getProperties());
			StandardServiceRegistry servico = registradorServico.build();
			return cfg.buildSessionFactory(servico);
		}catch(Throwable e){
			System.out.println("Criação inicial do objeto SessionFactory falhou. Erros: "+e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
