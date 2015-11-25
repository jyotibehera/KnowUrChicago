package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dbo.TowedVehicleDbo;

@ManagedBean(name="TowedVehicle")

public class TowedVehicleBean
{
	private Date date;
	private String brand;
	private String style;
	private String color;
	private String plate;
	private String state;
	private String towedAddress;
	private String ph;
	private String inventoryno;
	
	
	private List<String> brndList = new ArrayList<String>();
	private List<String> stylelist = new ArrayList<String>();
	private List<String> colorlist = new ArrayList<String>();
	
	public List<String> getColorlist()
	{
		TowedVehicleDbo tvobj = new TowedVehicleDbo();
		colorlist = tvobj.getColorList();
		return colorlist;
	}
	public void setColorlist(List<String> colorlist)
	{
		this.colorlist = colorlist;
	}
	
	public List<String> getBrndList()
	{
		TowedVehicleDbo tvobj = new TowedVehicleDbo();
		brndList= tvobj.getBrandList();
	
		return brndList;
	}
	public void setBrndList(List<String> brndList)
	{
		this.brndList = brndList;
	}	
	
	public List<String> getStylelist()
	{
		TowedVehicleDbo tvobj = new TowedVehicleDbo();
		stylelist = tvobj.getStyleList();
		return stylelist;
	}
	public void setStylelist(List<String> stylelist)
	{
		this.stylelist = stylelist;
	}
	
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	public String getBrand()
	{
		return brand;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public String getStyle()
	{
		return style;
	}
	public void setStyle(String style)
	{
		this.style = style;
	}
	
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public String getPlate()
	{
		return plate;
	}
	
	public void setPlate(String plate)
	{
		this.plate = plate;
	}
	
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	
	public String getTowedAddress()
	{
		return towedAddress;
	}
	public void setTowedAddress(String towedAddress)
	{
		this.towedAddress = towedAddress;
	}
	
	public String getPh()
	{
		return ph;
	}	
	public void setPh(String ph)
	{
		this.ph = ph;
	}
	
	public String getInventoryno()
	{
		return inventoryno;
	}	
	public void setInventoryno(String inventoryno)
	{
		this.inventoryno = inventoryno;
	}
	
	public TowedVehicleBean()
	{
	}
	
}
