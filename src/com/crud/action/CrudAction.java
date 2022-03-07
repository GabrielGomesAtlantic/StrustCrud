package com.crud.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.crud.form.CrudForm;
import com.crud.vo.PersonagemVO;

public class CrudAction extends Action {
	
	public ActionForward execute (ActionMapping mapping,ActionForm form,
									HttpServletRequest request,HttpServletResponse response) throws Exception{
		ActionForward actionForward = new ActionForward();
		actionForward = mapping.findForward("telaCrud");
		
		CrudForm frm = (CrudForm) form;
		
		if(frm.getListaPersonagens().isEmpty()) {
			 if(frm.getAcao().equals("GRAVAR") && !frm.getNickName().isEmpty()) {
		        gravar (form);
		        request.setAttribute("listaPersonagens", frm.getListaPersonagens());
		    	return actionForward;
			}
			 iniciaArray (form);
		}
		
		if(frm.getAcao().equals("LIMPAR")) {
			limpar (form);
        }
		
		if(frm.getAcao().equals("EXCLUIR")) {
			remover (form);
			limpar (form);
		}
		
		if(frm.getAcao().equals("EDITAR")) {
			editar (form);
		}
		
        if(frm.getAcao().equals("GRAVAR") && !frm.getNickName().isEmpty()) {
        	gravar (form);
        	limpar (form);
		}        

		request.setAttribute("listaPersonagens", frm.getListaPersonagens());
		return actionForward;
		
	}
	
	public void gravar (ActionForm form) {
		
		CrudForm frm = (CrudForm) form;
		
		int count = 0;
		
		for(int i = 0; frm.getListaPersonagens().size() > i; i++) {
			count++;
		}
		frm.getListaPersonagens().add(new PersonagemVO(count+1, frm.getNickName(), frm.getLevel(), frm.getSexo(), frm.getDatCria(), frm.getArmas(), frm.getObservacoes()));
		frm.setNickName("");
		frm.setLevel("");
		frm.setSexo("");
		frm.setDatCria("");
		frm.setArmas("");
		frm.setObservacoes("");
		frm.setAcao("");
	}
	
	
	public void limpar (ActionForm form) {
		
		CrudForm frm = (CrudForm) form;
		
		frm.setNickName("");
		frm.setLevel("");
		frm.setSexo("");
		frm.setDatCria("");
		frm.setArmas("");
		frm.setObservacoes("");
		frm.setAcao("");
		
	}
	
	public void iniciaArray (ActionForm form) {
		
		CrudForm frm = (CrudForm) form;
		
		frm.getListaPersonagens().add(new PersonagemVO(1,"Teste1", "91-99","M", "25/11/2018", "Metralhadora", "Ping Alto Frequente"));
		frm.getListaPersonagens().add(new PersonagemVO(2,"Teste2", "11-20","F", "25/12/2018", "Shotgun", "Ping Alto Frequente"));
		frm.setAcao("");
	}
	
	public void remover (ActionForm form) {		
		CrudForm frm = (CrudForm) form;
		
		int aux = frm.getValor()-1;
		
		frm.setAcao("");
		if(aux > 1 && aux != 2) {
			frm.getListaPersonagens().remove(aux);
			frm.setAcao("");
		} else { 
			if(frm.getListaPersonagens().size() == 2) {
				frm.getListaPersonagens().remove(aux);
				frm.setAcao("");
			} else {
				if(frm.getListaPersonagens().size() > 2) {
					frm.getListaPersonagens().remove(aux);
					frm.setAcao("");
				} else {
					frm.getListaPersonagens().remove(0);
					frm.setAcao("");
				}
			}
		}
		frm.setAcao("");
	}
	
	
	/*public void editar (ActionForm form) {
		
		CrudForm frm = (CrudForm) form;
		
		String nickName = "";
		
		if(frm.getListaPersonagens() != null) {
			for(PersonagemVO p : frm.getListaPersonagens()) {
				if(frm.getValor()-1 == p.getId()) {
					nickName = p.getNickName();
					break;
				}
			}
			frm.setNickName(nickName);
		}
		
	}*/
	
	public void editar (ActionForm form) {
		
		CrudForm frm = (CrudForm) form;
		
		List<PersonagemVO> personagens = new ArrayList<PersonagemVO>();
		personagens.add(new PersonagemVO(frm.getValor(), frm.getNickName(), frm.getLevel(), frm.getSexo(), frm.getDatCria(), frm.getArmas(), frm.getObservacoes()));
		frm.getListaPersonagens().set(frm.getValor()-1, personagens.get(0));
	
	}
	
}
	