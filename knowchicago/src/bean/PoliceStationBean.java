package bean;


public class PoliceStationBean 
{
	private String dist;
	private String addrs;
	private String city;
	private String state;
	private String zip;
	private String link;
	private String ph;
	private String fax;
	private String tty;
	private Double lat;
	private Double longi;
	private String id; 
	
	public String getDist()
	{
		return dist;
	}

	public void setDist(String dist)
	{
		this.dist = dist;
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

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	public String getPh()
	{
		return ph;
	}

	public void setPh(String ph)
	{
		this.ph = ph;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public String getTty()
	{
		return tty;
	}

	public void setTty(String tty)
	{
		this.tty = tty;
	}

	public double getLat()
	{
		return lat;
	}

	public void setLat(Double loc)
	{
		this.lat = loc;
	}

	public double getLongi()
	{
		return longi;
	}

	public void setLongi(Double longi)
	{
		this.longi = longi;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PoliceStationBean other = (PoliceStationBean) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
		
}
