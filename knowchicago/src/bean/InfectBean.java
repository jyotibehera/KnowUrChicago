package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


public class InfectBean
{
	private String female_gonorrhea;
	private String male_gonorrhea;
	private String tb;
	
	public String getFemale_gonorrhea()
	{
		return female_gonorrhea;
	}

	public void setFemale_gonorrhea(String female_gonorrhea)
	{
		this.female_gonorrhea = female_gonorrhea;
	}

	public String getMale_gonorrhea()
	{
		return male_gonorrhea;
	}

	public void setMale_gonorrhea(String male_gonorrhea)
	{
		this.male_gonorrhea = male_gonorrhea;
	}

	public String getTb()
	{
		return tb;
	}

	public void setTb(String tb)
	{
		this.tb = tb;
	}


	
	public InfectBean()
	{
		
	}
}
