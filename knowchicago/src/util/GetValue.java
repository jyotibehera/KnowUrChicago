package util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name="GetValue")
@RequestScoped

public class GetValue
{
	public String phsCommunity;
	public GetValue(){
		
	}
	
	public String getPhsCommunity(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		this.phsCommunity=request.getParameter("frmCommunity:community_input");
		
		return this.phsCommunity;
	}
	
	public void setPhsCommunity(){
		this.phsCommunity = getPhsCommunity();
	}

}
