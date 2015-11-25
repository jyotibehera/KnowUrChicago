package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import dbo.PublicHealthDbo;


public class PublicHealthStatsDetailBean
{
	private List<NatalityBean> natalList = new ArrayList<NatalityBean>();
	private List<MortalityBean> mortalList = new ArrayList<MortalityBean>();
	private List<LeadTestBean> leadList = new ArrayList<LeadTestBean>();
	private List<InfectBean> infectList = new ArrayList<InfectBean>();
	private List<EconomicBean> economiList = new ArrayList<EconomicBean>();
	
	

	
	public PublicHealthStatsDetailBean()
	{}
	


	public List<MortalityBean> getMortalList()
	{
		return mortalList;
	}

	public void setMortalList(List<MortalityBean> mortalList)
	{
		this.mortalList = mortalList;
	}

	public List<LeadTestBean> getLeadList()
	{
		return leadList;
	}

	public void setLeadList(List<LeadTestBean> leadList)
	{
		this.leadList = leadList;
	}

	public List<InfectBean> getInfectList()
	{	
		return infectList;
	}

	public void setInfectList(List<InfectBean> infectList)
	{
		this.infectList = infectList;
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
