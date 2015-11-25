package view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartSeries;

import dbo.FoodInspectionDbo;


@ManagedBean (name="FoodInspection")
@ViewScoped

public class FoodInspectionView
{
	FoodInspectionDbo foodobj = new FoodInspectionDbo();
	
	public FoodInspectionView()
	{
		
	}
	
	public List<String> getrstrntname(String rstname)
	{
		List<String> rstresult;
		rstresult = foodobj.getRstrnt(rstname);
		List<String> rstrntresultnew = new ArrayList<String>();
		for(String item : rstresult)
		{
			rstrntresultnew.add(item);
		}
		return rstrntresultnew;
	}
	
	ChartSeries boys = new ChartSeries();
	
	
	
}

