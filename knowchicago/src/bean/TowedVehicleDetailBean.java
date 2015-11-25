package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import dbo.TowedVehicleDbo;


@ManagedBean(name="TowedVehiclesDetail")


public class TowedVehicleDetailBean
{
	
	private List<TowedVehicleBean> towedlist = new ArrayList<TowedVehicleBean>();
	
	private String dt;
	private String brnd;
	private String pl;
	
	public TowedVehicleDetailBean()
	{
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		dt = request.getParameter("towedform:popup_input");
		brnd= request.getParameter("towedform:brand_input");
		pl= request.getParameter("towedform:plate");
		
		TowedVehicleDbo tvobj = new TowedVehicleDbo();
		towedlist =  tvobj.getTowedvehicleList(dt,brnd,pl);
	}
	
	public List<TowedVehicleBean> getTowedlist()
	{
		return this.towedlist;
	}
	public void setTowedlist(List<TowedVehicleBean> towedlist)
	{
		this.towedlist = towedlist;
	}

	public String getDt()
	{
		return dt;
	}

	public void setDt(String dt)
	{
		this.dt = dt;
	}

	public String getBrnd()
	{
		return brnd;
	}

	public void setBrnd(String brnd)
	{
		this.brnd = brnd;
	}
	
	public String getPl()
	{
		return pl;
	}
	
	public void setPl(String pl)
	{
		this.pl = pl;
	}
}
