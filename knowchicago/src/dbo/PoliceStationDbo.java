package dbo;

import java.sql.Connection;

import bean.PoliceStationBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbo.JdbcConnectionPool;

import java.lang.StringBuffer;

public class PoliceStationDbo 
{
	
	public List<PoliceStationBean> getPoliceInfo()
	{
	
		List<PoliceStationBean> pslist = new ArrayList<PoliceStationBean>(); 
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		try 
		{
			Connection conn = dbcon.getConnection();
			Statement st = conn.createStatement();
			StringBuffer str = new StringBuffer("Select * from dbchicago.police_station");
			ResultSet rs = st.executeQuery(str.toString());
			int id=1;
			while(rs.next())
			{
				PoliceStationBean psbobj = new PoliceStationBean();
				psbobj.setDist(rs.getString("district"));
				psbobj.setAddrs(rs.getString("address"));
				psbobj.setCity(rs.getString("city"));
				psbobj.setState(rs.getString("state"));
				psbobj.setZip(rs.getString("zipcode"));
				psbobj.setLink(rs.getString("website"));
				psbobj.setPh(rs.getString("phone"));
				psbobj.setFax(rs.getString("fax"));
				psbobj.setTty(rs.getString("tty"));
				psbobj.setId(Integer.toString(id++));
				
				String locstr = rs.getString("location");
				String newlocstr = locstr.substring(locstr.indexOf("(")+1,locstr.indexOf(")"));
				String loc[] = newlocstr.split(",");
				int i;
				double locnew[]= new double[loc.length];
				for(i=0;i<loc.length;i++)
				{
					locnew[i]= Double.parseDouble(loc[i]);
				}
				
				
				psbobj.setLat(locnew[0]);
				psbobj.setLongi(locnew[1]);
				
				pslist.add(psbobj);				
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		return pslist;
	
		}
	

}
