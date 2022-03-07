package com.crud.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.crud.dao.PersonagemDAO;
import com.crud.form.CrudForm;
import com.crud.model.vo.PersonagemVO;

public class CrudService {
	
	public void gravar (CrudForm form) throws SQLException {
		PersonagemDAO personagemDAO = new PersonagemDAO();
		try {
			personagemDAO.gravar(form);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void remover (ActionForm form) {	
		CrudForm frm = (CrudForm) form;
		PersonagemDAO personagemDAO = new PersonagemDAO();
		try {
			personagemDAO.excluir(frm);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar (ActionForm form) {
		CrudForm frm = (CrudForm) form;
		PersonagemDAO personagemDAO = new PersonagemDAO();
		try {
			personagemDAO.editar(frm);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> obterListaLevel() {
		ArrayList<String> listaLevel = new ArrayList<String>();
		listaLevel.add("Selecione");
		for(int i=1; i < 100; i++) {
			listaLevel.add(String.valueOf(i));
		}
		return listaLevel;
	}

	public List<PersonagemVO> listaPersonagens() throws SQLException {
		PersonagemDAO personagemDAO = new PersonagemDAO();
		return personagemDAO.listaPersonagens();
	}
}
