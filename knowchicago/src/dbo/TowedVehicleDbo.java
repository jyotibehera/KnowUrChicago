package dbo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import bean.TowedVehicleBean;

public class TowedVehicleDbo
{
	public List<String> getBrandList()
	{
		List<String> tvlist = new ArrayList<String>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("select distinct make from dbchicago.towed_vehicles");
			
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				tvlist.add(rs.getString("make"));
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return tvlist;
	
	}
	
	public List<String> getStyleList()
	{
		List<String> stylelist = new ArrayList<String>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("select distinct style from dbchicago.towed_vehicles");
			
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				stylelist.add(rs.getString("style"));
			}
			System.out.println("TowedVehicle dbo getStyle");
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return stylelist;
	
	}
	
	public List<String> getColorList()
	{
		List<String> colorlist = new ArrayList<String>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("select distinct color from dbchicago.towed_vehicles");
			
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				colorlist.add(rs.getString("color"));
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return colorlist;
	
	}
	
	public List<TowedVehicleBean> getTowedvehicleList(String date,String make,String plate)
	{
		List<TowedVehicleBean> towedlist = new ArrayList<TowedVehicleBean>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			query.append("select * from dbchicago.towed_vehicles where tow_date= '"+SplChar(date));
			query.append("' and make= '"+SplChar(make)+"' and plate= '"+SplChar(plate)+"'");
			
			
			
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				TowedVehicleBean tvbobj = new TowedVehicleBean();
				tvbobj.setDate(new SimpleDateFormat("MM/dd/yyyy").parse(rs.getString("tow_date")));
				tvbobj.setBrand(rs.getString("make"));
				tvbobj.setStyle(rs.getString("style"));
				tvbobj.setColor(rs.getString("color"));
				tvbobj.setPlate(rs.getString("plate"));
				tvbobj.setState(rs.getString("state"));
				tvbobj.setTowedAddress(rs.getString("towed_to_Address"));
				tvbobj.setPh(rs.getString("tow_facility_phone"));
				tvbobj.setInventoryno(rs.getString("inventory_number"));
				
				towedlist.add(tvbobj);
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException | ParseException e)
		{
			e.printStackTrace();
		}
		return towedlist;
	
	}
	public String SplChar(String string)
	{
		String newString = string.replace("'", "\\'").replace("%", "\\%");
		return newString;
	}
}
