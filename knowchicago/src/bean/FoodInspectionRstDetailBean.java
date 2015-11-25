package bean;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import dbo.FoodInspectionDbo;


@ManagedBean(name="foodinspectionrstdetail")
@ViewScoped

public class FoodInspectionRstDetailBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	BarChartModel model = new BarChartModel();
	
	private MapModel rstmapmodel = new DefaultMapModel();
	
	private List<FoodInspectionBean> fdrstlist;
	private double center1;
	private double center2;
	
	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

	public FoodInspectionRstDetailBean()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		try
		{
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rstname = request.getParameter("rstname");
		
		String addrs = request.getParameter("addrs");
		String zipcode = request.getParameter("zipcode");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		FoodInspectionDbo fdbo = new FoodInspectionDbo();
		fdrstlist = fdbo.getDistinctRstInfo(rstname,addrs,city,state,zipcode);
		
		//-------------------------------------------------------------------------------
		// Bar chart
		ChartSeries rsltpass = new ChartSeries();
		ChartSeries rsltfail = new ChartSeries();
		
		rsltpass.setLabel("Pass");
		rsltfail.setLabel("Fail");
		int pass=0;
		int fail=0;
		
		for(FoodInspectionBean item : fdrstlist)
		{
			if(item.getResult().equalsIgnoreCase("fail"))
			{
				fail=fail+1;
			}
			else
			{
				pass=pass+1;
			}
			
		}
		
		rsltpass.set("Result",pass);
		rsltfail.set("Result",fail);
		
		model.addSeries(rsltpass);
		model.addSeries(rsltfail);		
		model.setTitle("");
	    model.setLegendPosition("ne");
	    model.setShadow(false);
	    model.setMouseoverHighlight(false);
	    model.setShowDatatip(false);
	    
	    model.setShowPointLabels(true);
	    model.setStacked(false);
	    	    
	    Axis xAxis = model.getAxis(AxisType.X);	    
	  
	         
	    Axis yAxis = model.getAxis(AxisType.Y);
	    yAxis.setLabel("Number of Inspection");
	    yAxis.setMin(0);
	    if(pass>fail)
	    {
	    	yAxis.setMax(pass+2);
	    }
	    else
	    {
	    	yAxis.setMax(fail+2);
	    }
	    
	    yAxis.setTickCount(1);
	    
	    //----------------------------------------------------------------------
	    // map model
	    
	    	String desc = fdrstlist.get(0).getAddrs();
	    	rstmapmodel.addOverlay(new Marker(new LatLng(fdrstlist.get(0).getLat(),fdrstlist.get(0).getLongi()),desc));
	    	center1= fdrstlist.get(0).getLat();
	    	center2= fdrstlist.get(0).getLongi();
	}
	
	public List<FoodInspectionBean> getFdrstlist()
	{
		return fdrstlist;
	}

	public void setFdrstlist(List<FoodInspectionBean> fdrstlist)
	{
		this.fdrstlist = fdrstlist;
	}
	
	public BarChartModel getModel()
	{
		return model;
	}
	
	public void setmodel(BarChartModel model)
	{
		this.model = model;
	}
	public MapModel getRstmapmodel()
	{
		return rstmapmodel;
	}

	public void setRstmapmodel(MapModel rstmapmodel)
	{
		this.rstmapmodel = rstmapmodel;
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
