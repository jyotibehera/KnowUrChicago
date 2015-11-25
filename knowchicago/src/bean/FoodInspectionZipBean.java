package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import dbo.FoodInspectionDbo;

@ManagedBean(name="FoodInspectionZipBean")
@SessionScoped
public class FoodInspectionZipBean
{
	List<String> zipcodes = new ArrayList<String>();
	
	public FoodInspectionZipBean()
	{
		FoodInspectionDbo fidbo = new FoodInspectionDbo();
		zipcodes = fidbo.getZipcodeInfo() ;
	}
	
	public List<String> getZipcodes()
	{
		return zipcodes;
	}

	public void setZipcodes(List<String> zipcodes)
	{
		this.zipcodes = zipcodes;
	}
	
}
