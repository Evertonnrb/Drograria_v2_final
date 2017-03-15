package br.com.drogaria.bean;

import javax.faces.bean.ManagedBean;

import org.omnifaces.util.Messages;

@ManagedBean
public class EstadoBean {
	public void salvar(){
//		String texto = "Programação web com java ";
//		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,texto,texto);
//		
//		FacesContext contexto = FacesContext.getCurrentInstance();
//		contexto.addMessage(null, mensagem);	
//	
				Messages.addFlashGlobalWarn("Sucesso!");

	}
}
