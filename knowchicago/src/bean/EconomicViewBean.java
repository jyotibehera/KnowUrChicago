package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import dbo.PublicHealthDbo;

@ManagedBean(name="EconomicViewBean")

@RequestScoped
public class EconomicViewBean
{
	private List<EconomicBean> economiList = new ArrayList<EconomicBean>();
	
	public EconomicViewBean()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String community = request.getParameter("phsform:community");
		
		
		PublicHealthDbo objph = new PublicHealthDbo();
		
		economiList = objph.getEconomic(community);
	}
	
	public List<EconomicBean> getEconomiList()
	{
		return economiList;
	}

	public void setEconomiList(List<EconomicBean> economiList)
	{
		this.economiList = economiList;
	}
}
