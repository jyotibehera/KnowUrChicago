package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



public class LeadTestBean
{
	private String childhood_blood_lead_level;
	private String childhood_lead_poisoning;	
	
	public String getChildhood_blood_lead_level()
	{
		return childhood_blood_lead_level;
	}

	public void setChildhood_blood_lead_level(String childhood_blood_lead_level)
	{
		this.childhood_blood_lead_level = childhood_blood_lead_level;
	}

	public String getChildhood_lead_poisoning()
	{
		return childhood_lead_poisoning;
	}

	public void setChildhood_lead_poisoning(String childhood_lead_poisoning)
	{
		this.childhood_lead_poisoning = childhood_lead_poisoning;
	}

	public LeadTestBean()
	{
			
	}
}
