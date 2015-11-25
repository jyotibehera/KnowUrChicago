package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dbo.PublicHealthDbo;

@ManagedBean(name="HealthStatsBean")
@ViewScoped

public class PublicHealthStatsBean
{
	private String community_name;
	
	private List<String> commList;
	
	
	
	public List<String> getCommList()
	{
		PublicHealthDbo phdbobj = new PublicHealthDbo();
		this.commList= phdbobj.getCommunity();
		return this.commList;
	}
	public void setCommList(List<String> commList)
	{
		this.commList = commList;
	}
	public String getCommunity_name()
	{
		return community_name;
	}
	public void setCommunity_name(String community_name)
	{
		this.community_name = community_name;
	}

	
	public PublicHealthStatsBean()
	{
		System.out.println("PublicHealthStatsBean");	
	}
}
