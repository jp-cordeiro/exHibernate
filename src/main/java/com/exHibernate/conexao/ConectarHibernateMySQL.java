package com.exHibernate.conexao;

import org.hibernate.Session;

public class ConectarHibernateMySQL {

	public static void main(String[] args) {
		//Cria uma sessão vazia
		Session sessao = null;
		//Recupera uma instancia de SessionFactory para usarmos o método openSession, para 'sessao' receber o sessão aberta com o banco
		sessao = HibenateUtil.getSessionFactory().openSession();
		System.out.println("Conectou!");
		//Fecha a sessão
		sessao.close();
	}
}
