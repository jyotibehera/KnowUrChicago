package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import dbo.PoliceStationDbo;

@ManagedBean(name="policemap")
@ViewScoped
public class PoliceMapBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private MapModel model = new DefaultMapModel();
	private Marker marker;
	private PoliceStationBean selectedPS;

	public PoliceMapBean()
	{
		List<PoliceStationBean> pslistmap = new ArrayList<PoliceStationBean>();
		PoliceStationDbo psdbo = new PoliceStationDbo();
		
		
		pslistmap = psdbo.getPoliceInfo();
		for(PoliceStationBean temp:pslistmap)
		{	
				String displaytext= "District: "+ temp.getDist()+"\n"+temp.getAddrs();
				model.addOverlay(new Marker(new LatLng(temp.getLat(), temp.getLongi()),displaytext));
		}
		
	}
	
      
    public Marker getMarker() 
    {
        return marker;
    }
	public MapModel getModel()
	{
		return this.model;
	}
	
	public void onRowSelect(SelectEvent event){
		this.selectedPS = (PoliceStationBean)event.getObject();
		
		
		List<PoliceStationBean> pslistmap = new ArrayList<PoliceStationBean>();
		PoliceStationDbo psdbo = new PoliceStationDbo();
		
		
		pslistmap = psdbo.getPoliceInfo();
		for(PoliceStationBean temp:pslistmap)
		{
			if(selectedPS == null)
			{
				String displaytext= "District: "+ temp.getDist()+"\n"+temp.getAddrs();
				model.addOverlay(new Marker(new LatLng(temp.getLat(), temp.getLongi()),displaytext));
			}
			else if(selectedPS != null && 
					selectedPS.getLat() == temp.getLat() && 
						selectedPS.getLongi() == temp.getLongi())
			{				
		
				String displaytext= "District: "+ temp.getDist()+"\n"+temp.getAddrs();
				model.addOverlay(new Marker(new LatLng(temp.getLat(), temp.getLongi()),displaytext,null, "../resources/images/marker_blue.png"));//Make color change
			}
			else
			{
				String displaytext= "District: "+ temp.getDist()+"\n"+temp.getAddrs();
				model.addOverlay(new Marker(new LatLng(temp.getLat(), temp.getLongi()),displaytext)); 
			}
		}
	}
}
