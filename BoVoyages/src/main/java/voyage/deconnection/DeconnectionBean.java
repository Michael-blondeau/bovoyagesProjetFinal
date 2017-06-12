package voyage.deconnection;

import java.io.Serializable;


import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Named("DeconnectionBean")
@RequestScoped
public class DeconnectionBean implements Serializable{

	private static final long serialVersionUID = 1L;

	public String disconnect(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse resp = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		if(session != null){
			session.invalidate();
		}
			
		return "index?faces-redirect=true";
	}
}
