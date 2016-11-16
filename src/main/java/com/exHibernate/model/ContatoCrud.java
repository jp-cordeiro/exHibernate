package com.exHibernate.model;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.exHibernate.conexao.HibenateUtil;

public class ContatoCrud {

	private Session sessao;
	public ContatoCrud(Session sessao){
		this.sessao = sessao;
	}
	
	//Método que realiza o comando INSERT no BD recebendo contato como parametro
	public void salvar(Contato contato){
		sessao.save(contato);
	}
	
	//Método que realiza o comando UPDATE no BD recebendo contato como parametro
	public void atualizar(Contato contato){
		sessao.update(contato);
	}
	
	//Método que realiza o comando DELETE no BD recebendo contato como parametro
	public void Excluir(Contato contato){
		sessao.delete(contato);
	}
	
	//Método que realiza o comando SELECT * FROM
	public List<Contato> listar(){
		//A classe Query no permite realizar consultas usando HQL (Hibernate Query Language)
		Query consulta = sessao.createQuery("from Contato");//Contato aqui é um objeto, ou seja, uma Classe e não a tabela do BD
		//Retorna uma lista de contatos com os objetos consultados
		return consulta.list();
	}
	
	//Método que realiza o comando SELECT * FROM com a cláusula WHERE que filtra os dados
	public Contato buscaContato(int valor){
		//Consulta parametrizada
		Query consulta = sessao.createQuery("from Contato where codido = :parametro");//:parametro será o parametro passado para 
		//se realizar a consulta e será assimilado a consulta
		consulta.setInteger("parametro", valor);//Indica que o elemento parametro da consulta receberá o paramentro 'valor'
		return (Contato) consulta.uniqueResult();//Retorna apenas um único objeto, que é o resultado da consulta realizada pela chave primária
	}
	
	public static void main(String[] args) {
		Session sessao = HibenateUtil.getSessionFactory().openSession();
		//Inicia uma transação, ou seja, alteração no banco de dados somente serão efetivadas no banco se nenhum erro acontecer
		Transaction transacao = sessao.beginTransaction();
		ContatoCrud crud = new ContatoCrud(sessao);
		
		Contato contato2 = new Contato();
		contato2.setNome("Sicrano");
		contato2.setTelefone("123");
		contato2.setEmail("teste@teste.com");
		contato2.setDataCadastro(new Date(System.currentTimeMillis()));
		contato2.setObs("teste");
		crud.salvar(contato2);
		
		transacao.commit();
		
		System.out.println("Total de registros cadastrados: "+crud.listar().size());
	}
}
