package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import dbo.PublicHealthDbo;

@ManagedBean(name="NatalityView")

@RequestScoped
public class NatalityViewBean
{
	private List<NatalityBean> natalList = new ArrayList<NatalityBean>();
	

	
	public NatalityViewBean()
	{
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String community = request.getParameter("phsform:community");
		
		
		PublicHealthDbo objph = new PublicHealthDbo();
		
		natalList =  objph.getNatality(community);
	}
	
	public List<NatalityBean> getnatalList()
	{
		return natalList;
	}
	public void setnatalList(List<NatalityBean> natalList)
	{
		this.natalList = natalList;
	}
}
