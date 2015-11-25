package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import dbo.PublicHealthDbo;

@ManagedBean(name="InfectViewBean")

@RequestScoped
public class InfectViewBean
{
	private List<InfectBean> infectList = new ArrayList<InfectBean>();

	public InfectViewBean()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String community = request.getParameter("phsform:community");
		System.out.println("InfectViewBean : " + community);
		
		PublicHealthDbo objph = new PublicHealthDbo();

		infectList = objph.getInfectious(community);
		
	}
	
	public List<InfectBean> getInfectList()
	{	
		return infectList;
	}

	public void setInfectList(List<InfectBean> infectList)
	{
		this.infectList = infectList;
	}
}
