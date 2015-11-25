package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import dbo.CrimeDbo;

@ManagedBean(name="CrimeDetailBn")
@RequestScoped

public class CrimeDetailBean
{
	private List<CrimeBean> crlist= new ArrayList<CrimeBean>();
	private MapModel cmap = new DefaultMapModel();
	private double center1;
	private double center2;
	
	public CrimeDetailBean()
	{
		
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String blk = request.getParameter("CrimesearchFrmBlk:blk_input");
		
		String dist = request.getParameter("CrimesearchFrmBlk:dist");
		String yr= request.getParameter("CrimesearchFrmBlk:yr");
		
		CrimeDbo cdbo = new CrimeDbo();
		
		this.crlist = cdbo.getCrimeDetail(dist, yr, blk);
		
		for(CrimeBean item: crlist)
		{
			String desc = "Case Number: "+item.getCasenumber()+ "\n"+item.getCrimetype();
			cmap.addOverlay(new Marker(new LatLng(item.getLat(), item.getLongi()), desc));
		}
		for(CrimeBean item :crlist)
		{
			center1 = item.getLat();
			center2 = item.getLongi();
			break;
		}
		
	}
	public MapModel getCmap()
	{
		return cmap;
	}
	public void setCmap(MapModel cmap)
	{
		this.cmap = cmap;
	}
	public List<CrimeBean> getCrlist()
	{
		return crlist;
	}
	public void setCrlist(List<CrimeBean> crlist)
	{
		this.crlist = crlist;
	}
	public double getCenter1()
	{
		return center1;
	}
	public void setCenter1(double center1)
	{
		this.center1 = center1;
	}
	public double getCenter2()
	{
		return center2;
	}
	public void setCenter2(double center2)
	{
		this.center2 = center2;
	}
}
