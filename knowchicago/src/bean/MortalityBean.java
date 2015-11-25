package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


public class MortalityBean
{
	
	private String assault_homicide;
	private String female_breastcancer;
	private String allcancer;
	private String colorectal_cancer;
	private String diabetes;
	private String firearm_related;
	private String infant_mortalityrate;
	private String lung_cancer;
	private String prostate_cancer_male;
	private String stroke;
	
	public String getFirearm_related()
	{
		return firearm_related;
	}
	public void setFirearm_related(String firearm_related)
	{
		this.firearm_related = firearm_related;
	}
	public String getLung_cancer()
	{
		return lung_cancer;
	}
	public void setLung_cancer(String lung_cancer)
	{
		this.lung_cancer = lung_cancer;
	}
	public String getProstate_cancer_male()
	{
		return prostate_cancer_male;
	}
	public void setProstate_cancer_male(String prostate_cancer_male)
	{
		this.prostate_cancer_male = prostate_cancer_male;
	}
	public String getStroke()
	{
		return stroke;
	}
	public void setStroke(String stroke)
	{
		this.stroke = stroke;
	}
	
	public String getAssault_homicide()
	{
		return assault_homicide;
	}
	public void setAssault_homicide(String assault_homicide)
	{
		this.assault_homicide = assault_homicide;
	}
	public String getFemale_breastcancer()
	{
		return female_breastcancer;
	}
	public void setFemale_breastcancer(String female_breastcancer)
	{
		this.female_breastcancer = female_breastcancer;
	}
	public String getAllcancer()
	{
		return allcancer;
	}
	public void setAllcancer(String allcancer)
	{
		this.allcancer = allcancer;
	}
	public String getColorectal_cancer()
	{
		return colorectal_cancer;
	}
	public void setColorectal_cancer(String colorectal_cancer)
	{
		this.colorectal_cancer = colorectal_cancer;
	}
	public String getDiabetes()
	{
		return diabetes;
	}
	public void setDiabetes(String diabetes)
	{
		this.diabetes = diabetes;
	}
	public String getInfant_mortalityrate()
	{
		return infant_mortalityrate;
	}
	public void setInfant_mortalityrate(String infant_mortalityrate)
	{
		this.infant_mortalityrate = infant_mortalityrate;
	}
	
	public MortalityBean()
	{
			
	}
}
