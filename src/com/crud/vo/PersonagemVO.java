package com.crud.vo;

public class PersonagemVO {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nickName;
	private String level;
	private String sexo;
	private String datCria;
	private String armas;
	private String observacoes;
	
	public PersonagemVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PersonagemVO(int id, String nickName, String level, String sexo, String datCria, String armas, String observacoes) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.level = level;
		this.sexo = sexo;
		this.datCria = datCria;
		this.armas = armas;
		this.observacoes = observacoes;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDatCria() {
		return datCria;
	}
	public void setDatCria(String datCria) {
		this.datCria = datCria;
	}
	public String getArmas() {
		return armas;
	}
	public void setArmas(String armas) {
		this.armas = armas;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}
