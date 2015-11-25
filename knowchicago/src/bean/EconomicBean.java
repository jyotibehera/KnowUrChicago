package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


public class EconomicBean
{
	private String below_poverty;
	private String crowded_housing;
	private String dependency;
	private String no_high_school_diploma;
	private String per_capita_income;
	private String unemployment;
	
	
		
	public String getBelow_poverty()
	{
		return below_poverty;
	}



	public void setBelow_poverty(String below_poverty)
	{
		this.below_poverty = below_poverty;
	}



	public String getCrowded_housing()
	{
		return crowded_housing;
	}



	public void setCrowded_housing(String crowded_housing)
	{
		this.crowded_housing = crowded_housing;
	}



	public String getDependency()
	{
		return dependency;
	}



	public void setDependency(String dependency)
	{
		this.dependency = dependency;
	}



	public String getNo_high_school_diploma()
	{
		return no_high_school_diploma;
	}



	public void setNo_high_school_diploma(String no_high_school_diploma)
	{
		this.no_high_school_diploma = no_high_school_diploma;
	}



	public String getPer_capita_income()
	{
		return per_capita_income;
	}



	public void setPer_capita_income(String per_capita_income)
	{
		this.per_capita_income = per_capita_income;
	}



	public String getUnemployment()
	{
		return unemployment;
	}



	public void setUnemployment(String unemployment)
	{
		this.unemployment = unemployment;
	}



	public EconomicBean()
	{
		
	}
}
