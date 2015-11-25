package bean;

import java.sql.Date;

public class FoodInspectionBean
{
	private String rstrntname;
	private String dupRstname;
	private String license;
	private String rstrnttype;
	private String risk;
	private String addrs;
	private String city;
	private String state;
	private String zip;
	private String date;
	private String inspectiontype;
	private String result;
	private String cause;
	private Double lat;
	private Double longi;
	
	public FoodInspectionBean(){}
	
	public FoodInspectionBean(String rstrntname, String license,String rstrnttype,String risk,String addrs,
			String city,String state,String zip,String date,String inspectiontype,String result,
			String cause,Double lat,Double longi )
	{
		this.rstrntname = rstrntname;
		this.license = license;
		this.rstrnttype = rstrnttype;
		this.risk = risk;
		this.addrs = addrs;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.date = date;
		this.inspectiontype = inspectiontype;
		this.result = result;
		this.cause = cause;
		this.lat = lat;
		this.longi = longi;

		
	}
	
	public String getRstrntname()
	{
		return rstrntname;
	}
	public void setRstrntname(String rstrntname)
	{
		this.rstrntname = rstrntname;
	}
	public String getLicense()
	{
		return license;
	}
	public void setLicense(String license)
	{
		this.license = license;
	}
	public String getRstrnttype()
	{
		return rstrnttype;
	}
	public void setRstrnttype(String rstrnttype)
	{
		this.rstrnttype = rstrnttype;
	}
	public String getRisk()
	{
		return risk;
	}
	public void setRisk(String risk)
	{
		this.risk = risk;
	}
	public String getAddrs()
	{
		return addrs;
	}
	public void setAddrs(String addrs)
	{
		this.addrs = addrs;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getZip()
	{
		return zip;
	}
	public void setZip(String zip)
	{
		this.zip = zip;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date2)
	{
		this.date = date2;
	}
	public String getInspectiontype()
	{
		return inspectiontype;
	}
	public void setInspectiontype(String inspectiontype)
	{
		this.inspectiontype = inspectiontype;
	}
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result = result;
	}
	public String getCause()
	{
		return cause;
	}
	public void setCause(String cause)
	{
		this.cause = cause;
	}
	public Double getLat()
	{
		return lat;
	}
	public void setLat(Double lat)
	{
		this.lat = lat;
	}
	public Double getLongi()
	{
		return longi;
	}
	public void setLongi(Double longi)
	{
		this.longi = longi;
	}

	public String getDupRstname()
	{
		return dupRstname;
	}

	public void setDupRstname(String dupRstname)
	{
		this.dupRstname = dupRstname;
	}
	
	
}
