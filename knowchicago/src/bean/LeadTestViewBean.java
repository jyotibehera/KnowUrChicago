package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import dbo.PublicHealthDbo;

@ManagedBean(name="LeadTestViewBean")

@RequestScoped
public class LeadTestViewBean
{
	private List<LeadTestBean> leadList = new ArrayList<LeadTestBean>();
	
	public LeadTestViewBean()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String community = request.getParameter("phsform:community");
		
		
		PublicHealthDbo objph = new PublicHealthDbo();

		leadList = objph.getLead(community);
	}

	public List<LeadTestBean> getLeadList()
	{	
		return leadList;
	}

	public void setLeadList(List<LeadTestBean> leadList)
	{
		this.leadList = leadList;
	}

}
