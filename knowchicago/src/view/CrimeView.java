package view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dbo.CrimeDbo;

@ManagedBean(name="Crime")
@ViewScoped
public class CrimeView
{
	List<String> distlist = new ArrayList<String>();
	List<String> yrlist = new ArrayList<String>();
	
	CrimeDbo cdbo = new CrimeDbo();
	
	public CrimeView()
	{
	}
	
	public List<String> getDistlist()
	{
		CrimeDbo cdbo = new CrimeDbo();
		distlist = cdbo.getDistrictList();
		
		return distlist;
	}

	public void setDistlist(List<String> distlist)
	{
		this.distlist = distlist;
	}

	public List<String> getYrlist()
	{
		CrimeDbo cdbo = new CrimeDbo();
		yrlist = cdbo.getYearList();
		return yrlist;
	}
	public void setYrlist(List<String> yrlist)
	{
		this.yrlist = yrlist;
	}
	
}
