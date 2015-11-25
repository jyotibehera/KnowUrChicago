package view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import bean.PoliceStationBean;
import dbo.PoliceStationDbo;

@ManagedBean(name="policestation")
@ViewScoped

public class PoliceStationView 
{
	private PoliceStationBean policeStation;
	private List<PoliceStationBean> policelist;
	
	
	public PoliceStationBean getPoliceStation()
	{
		return policeStation;
	}

	public void setPoliceStation(PoliceStationBean policeStation)
	{
		this.policeStation = policeStation;
	}

	PoliceStationDbo psdbo = new PoliceStationDbo();
	
	public PoliceStationView(){
		policelist = psdbo.getPoliceInfo();
	}
	
	public List<PoliceStationBean> getPolicelist()
	{
		return policelist;
	}

	public void setPolicelist(List<PoliceStationBean> policelist)
	{
		this.policelist = policelist;
	}

}
