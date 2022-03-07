package com.crud.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.crud.form.CrudForm;
import com.crud.service.CrudService;

public class CrudAction extends Action {
	
	private static String TELA_CRUD = "telaCrud";
	
	public ActionForward execute (ActionMapping mapping,ActionForm form,
									HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward actionForward = new ActionForward();
		actionForward = mapping.findForward(TELA_CRUD);
		
		CrudForm frm = (CrudForm) form;
		
		CrudService service = new CrudService();

		if(frm.getAcao().equals("EXCLUIR")) {
			remover(form);
		}
		
		if(frm.getAcao().equals("EDITAR")) {
			editar(form);
		}
		
        if(frm.getAcao().equals("GRAVAR") && !frm.getNickName().isEmpty()) {
        	gravar(frm);	
		}        
        request.setAttribute("listaLevel", service.obterListaLevel());
        request.setAttribute("listaPersonagens", service.listaPersonagens());
		return actionForward;
		
	}
	
	public void gravar(CrudForm form) throws SQLException {
		CrudService service = new CrudService();
		service.gravar(form);
	}
	
	public void editar(ActionForm form) throws SQLException {
		CrudService service = new CrudService();
		service.editar(form);
	}
	
	public void remover(ActionForm form) throws SQLException {
		CrudService service = new CrudService();
		service.remover(form);
	}
}
	