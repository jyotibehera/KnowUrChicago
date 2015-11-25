package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;

import dbo.CrimeDbo;

@ManagedBean(name="CrimeChart")
@RequestScoped

public class CrimeChartBean
{
	private PieChartModel piemodel= new PieChartModel();
	private LineChartModel linemodel = new LineChartModel();
	private List<CrimeBean> cbnlist  = new ArrayList<CrimeBean>();
	private List<CrimeBean> cbnlistbar = new ArrayList<CrimeBean>();
	private List<CrimeBean> cbnlistDbar = new ArrayList<CrimeBean>();
	List<String> blocklist = new ArrayList<String>();
	CrimeDbo cdbo = new CrimeDbo();
	
	private String dist;
	private String yr;
	
	
	public CrimeChartBean()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		dist = request.getParameter("CrimeSearchForm:dist_input");
		yr= request.getParameter("CrimeSearchForm:year_input");
		
		blocklist = cdbo.getBlockList(dist, yr);
		
		
		// Pie chart-----------------------------------------------------------------------------------
		
		
		this.cbnlist = cdbo.getPieInfo(dist, yr);
		
		for(CrimeBean item:cbnlist)
		{
			piemodel.set(item.getCrimetype(), item.getCount());
		}
		
		piemodel.setTitle("District: "+dist+"\n"+" Year: "+yr);
		piemodel.setLegendPosition("e");
		piemodel.setShowDataLabels(true);
		piemodel.setDiameter(300);
		piemodel.setMouseoverHighlight(true);
		piemodel.setExtender("pieExtender");
		piemodel.setLegendPlacement(LegendPlacement.OUTSIDE);
		
		// Line Chart for total chicago------------------------------------------------------------------------

	
		this.cbnlistbar = cdbo.getLineChartInfo();
		
		ChartSeries cr = new ChartSeries();
		cr.setLabel("Chicago Crime Rate");
		
		for(CrimeBean itm : cbnlistbar)
		{
			cr.set(itm.getYear(), itm.getCount());
		}
		
		linemodel.addSeries(cr);
		linemodel.setTitle("Chicago Crime Rate");
		linemodel.setLegendPosition("w");
		
		
		linemodel.getAxes().put(AxisType.X, new CategoryAxis("Years"));
		Axis yAxis = linemodel.getAxis(AxisType.Y);
		yAxis.setLabel("Number of Crime");
		yAxis.setMin(0);
		yAxis.setMax(500000);
		
		
		// Line Chart for the particular district and year------------------------------------------------------
		
		cbnlistDbar = cdbo.getDYLineChartInfo(dist);
		ChartSeries crdist = new ChartSeries();
		for(CrimeBean item1 :cbnlistDbar)
		{
			crdist.set(item1.getYear(), item1.getCount());
		}
		linemodel.addSeries(crdist);
		crdist.setLabel("Crime rate for District "+dist);
	}
	
	public PieChartModel getPiemodel()
	{
		return piemodel;
	}


	public void setPiemodel(PieChartModel piemodel)
	{
		this.piemodel = piemodel;
	}
	public LineChartModel getLinemodel()
	{
		return linemodel;
	}

	public void setLinemodel(LineChartModel linemodel)
	{
		this.linemodel = linemodel;
	}
	public List<CrimeBean> getCbnlist()
	{
		return cbnlist;
	}

	public void setCbnlist(List<CrimeBean> cbnlist)
	{
		this.cbnlist = cbnlist;
	}
	public List<CrimeBean> getCbnlistbar()
	{
		return cbnlistbar;
	}

	public void setCbnlistbar(List<CrimeBean> cbnlistbar)
	{
		this.cbnlistbar = cbnlistbar;
	}

	public List<String> getBlocklist()
	{
		return blocklist;
	}

	public void setBlock(List<String> blocklist)
	{
		this.blocklist = blocklist;
	}

	public String getDist()
	{
		return dist;
	}

	public void setDist(String dist)
	{
		this.dist = dist;
	}

	public String getYr()
	{
		return yr;
	}

	public void setYr(String yr)
	{
		this.yr = yr;
	}

	public List<CrimeBean> getCbnlistDbar()
	{
		return cbnlistDbar;
	}

	public void setCbnlistDbar(List<CrimeBean> cbnlistDbar)
	{
		this.cbnlistDbar = cbnlistDbar;
	}


}
