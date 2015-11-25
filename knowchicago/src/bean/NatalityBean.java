package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



public class NatalityBean
{
	private String community_name;
	private String birth_rate;
	private String fertility_rate;
	private String low_birth_weight;
	private String prenatal_care;
	private String preterm_birth;
	private String teen_birth_rate;
	
	
	public String getCommunity_name()
	{
		return community_name;
	}
	public void setCommunity_name(String community_name)
	{
		this.community_name = community_name;
	}
	public String getBirth_rate()
	{
		return birth_rate;
	}
	public void setBirth_rate(String birth_rate)
	{
		this.birth_rate = birth_rate;
	}
	public String getFertility_rate()
	{
		return fertility_rate;
	}
	public void setFertility_rate(String fertility_rate)
	{
		this.fertility_rate = fertility_rate;
	}
	public String getLow_birth_weight()
	{
		return low_birth_weight;
	}
	public void setLow_birth_weight(String low_birth_weight)
	{
		this.low_birth_weight = low_birth_weight;
	}
	public String getPrenatal_care()
	{
		return prenatal_care;
	}
	public void setPrenatal_care(String prenatal_care)
	{
		this.prenatal_care = prenatal_care;
	}
	public String getPreterm_birth()
	{
		return preterm_birth;
	}
	public void setPreterm_birth(String preterm_birth)
	{
		this.preterm_birth = preterm_birth;
	}
	public String getTeen_birth_rate()
	{
		return teen_birth_rate;
	}
	public void setTeen_birth_rate(String teen_birth_rate)
	{
		this.teen_birth_rate = teen_birth_rate;
	}
	
	
	public NatalityBean()
	{
	}
}
