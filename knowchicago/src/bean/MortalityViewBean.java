package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import dbo.PublicHealthDbo;

@ManagedBean(name="MortalityViewBean")

@RequestScoped
public class MortalityViewBean
{
	private List<MortalityBean> mortalList = new ArrayList<MortalityBean>();

	public MortalityViewBean()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String community = request.getParameter("phsform:community");
		
		
		PublicHealthDbo objph = new PublicHealthDbo();
		
		mortalList = objph.getMortality(community);
	}
	
	public List<MortalityBean> getMortalList()
	{	
		return mortalList;
	}

	public void setMortalList(List<MortalityBean> mortalList)
	{
		this.mortalList = mortalList;
	}
}
