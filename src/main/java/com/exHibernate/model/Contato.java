package com.exHibernate.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "contato")
public class Contato {

	@Id//Indica que essa é a chava primária
	@GeneratedValue//Indica que é auto incremento
	@Column(name = "codigo")//Mapea como coluna e define o nome para a coluna
	private Integer codigo;

	@Column(name = "nome", length = 50, nullable = true)//length define a quantidade de caracteres da coluna e nullable indica que aceita valores nulos
	private String nome;
	
	@Column(name="telefone",length=50,nullable=true)
	private String telefone;
	
	@Column(name="email",length=50,nullable=true)
	private String email;
	
	@Column(name="dt_cad", nullable=true)
	private Date dataCadastro;
	
	@Column(name="obs",nullable=true)
	private String obs;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	

}
