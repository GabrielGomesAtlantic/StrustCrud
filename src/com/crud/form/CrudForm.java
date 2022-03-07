package com.crud.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.crud.model.vo.PersonagemVO;

public class CrudForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	private List<PersonagemVO> listaPersonagens    = new ArrayList<PersonagemVO>();
	private String nickName                        = "";
	private String level                           = "";
	private String sexo                            = "";
	private String datCria                         = "";
	private String armas                           = "";
	private String observacoes                     = "";
	private int id;
	private String acao                            = "";

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<PersonagemVO> getListaPersonagens() {
		return listaPersonagens;
	}
	public void setListaPersonagens(List<PersonagemVO> listaPersonagens) {
		this.listaPersonagens = listaPersonagens;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
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
