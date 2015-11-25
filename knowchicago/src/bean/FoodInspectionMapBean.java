package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import view.FoodInspectionView;
import dbo.FoodInspectionDbo;

@ManagedBean(name="foodinspectionmap")
@ViewScoped

public class FoodInspectionMapBean
{
	private MapModel model = new DefaultMapModel();
	private List<FoodInspectionBean> fdlist;
	private List<FoodInspectionBean> fddistinctlist;
	private double center1;
	private double center2;

	
	public FoodInspectionMapBean()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String inputZip = request.getParameter("inputzip_input");
		
		List<FoodInspectionBean> getfilist =new ArrayList<FoodInspectionBean>();
		
		FoodInspectionDbo fidbo = new FoodInspectionDbo();
		FoodInspectionView fiviewobj = new FoodInspectionView();
		
		getfilist = fidbo.getInspectionInfo(inputZip);
		this.fdlist = fidbo.getInspectionInfo(inputZip);
		for(FoodInspectionBean item : getfilist)
		{
			String desc = item.getRstrntname() + "\n" + item.getAddrs() + "\n" + item.getZip();
			model.addOverlay(new Marker(new LatLng(item.getLat(), item.getLongi()), desc));
		}
		this.fddistinctlist = fidbo.getDistinctEntityInfo(inputZip);
		for(FoodInspectionBean item : getfilist)
		{
			center1=item.getLat();
			center2= item.getLongi();
			break;
		}
	}
	
	public MapModel getModel()
	{
		return this.model;
	}
	
	public List<FoodInspectionBean> getFdlist()
	{
		return fdlist;
	}
	
	public List<FoodInspectionBean> getFddistinctlist()
	{
		return fddistinctlist;
	}
	public void setFddistinctlist(List<FoodInspectionBean> fddistinctlist)
	{
		this.fddistinctlist = fddistinctlist;
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
