package dbo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Fidelity;

import org.apache.commons.lang3.text.WordUtils;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener;

import bean.FoodInspectionBean;

public class FoodInspectionDbo
{
	public List<FoodInspectionBean> getInspectionInfo(String element)
	{
		List<FoodInspectionBean> filist = new ArrayList<FoodInspectionBean>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		
		try
		{
			Connection conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("select * from dbchicago.food_inspection where zipcode = ");
			query.append("'"+SplChar(element)+"'");
			
			query.append(" and location!='' ");
			
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				try
				{
					FoodInspectionBean fibobj = new FoodInspectionBean();
					
					fibobj.setRstrntname(rs.getString("dba_name"));
					fibobj.setLicense(rs.getString("license"));
					fibobj.setRstrnttype(rs.getString("facility_type"));
					fibobj.setRisk(rs.getString("risk"));
					fibobj.setAddrs(rs.getString("address"));
					fibobj.setCity(rs.getString("city"));
					fibobj.setState(rs.getString("state"));
					fibobj.setZip(rs.getString("zipcode"));
					fibobj.setDate(rs.getString("inspection_date"));
					fibobj.setInspectiontype(rs.getString("inspection_type"));
					fibobj.setResult(rs.getString("results"));
					fibobj.setCause(rs.getString("violations"));
					
					String locstr = rs.getString("location");
					String newstr = locstr.substring(locstr.indexOf("(")+1,locstr.indexOf(")"));
					String loc[] = newstr.split(",");
					
					Double finalloc[] = new Double[loc.length];
					int i;
					for(i=0;i<loc.length;i++)
					{
						finalloc[i] = Double.parseDouble(loc[i]);
						
					}
					
					fibobj.setLat(finalloc[0]);
					fibobj.setLongi(finalloc[1]);
					
					filist.add(fibobj);
					}
				catch(Exception e)
				{
					
					e.printStackTrace();
				}
			}
			st.close();
			conn.close();
		} 
		catch (ClassNotFoundException e)
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
		return filist;
	}
	public List<String> getZipcodes(String str)
	{
		
		List<String> zips = new ArrayList<String>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		
		try
		{
			Connection conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("select distinct zipcode from dbchicago.food_inspection where zipcode like ");
			query.append("\"%"+str+"%\"");
			query.append(" order by zipcode asc");
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				zips.add(rs.getString("zipcode"));
			}
			st.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return zips;
	}
	
	public List<String> getRstrnt(String str)
	{
		
		List<String> rstr = new ArrayList<String>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		
		try
		{
			Connection conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("select distinct dba_name from dbchicago.food_inspection where dba_name like ");
			query.append("\"%"+str+"%\"");
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				rstr.add(rs.getString("dba_name"));
			}
			st.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return rstr;
	}
	
	public List<FoodInspectionBean> getResult(String st)
	{
		
		List<FoodInspectionBean> rslt = new ArrayList<FoodInspectionBean>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		
		try
		{
			Connection conn = (Connection) dbcon.getConnection();
			Statement statement = (Statement) conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("select * from dbchicago.food_inspection where dba_name = 'au bon pain'");
			
			ResultSet rs = statement.executeQuery(query.toString());
			while(rs.next())
			{
				FoodInspectionBean fibobj = new FoodInspectionBean();
				String s = rs.getString("inspection_date");
				String snew = s.substring(s.lastIndexOf(':'+1));
				
				
				fibobj.setDate(snew);
				
				
				fibobj.setResult(rs.getString("results"));
				
				fibobj.setRstrntname(rs.getString("dba_name"));
				
				rslt.add(fibobj);
			}
			statement.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return rslt;
	}
	 
	
	
	public List<FoodInspectionBean> getDistinctEntityInfo(String element)
	{
		List<FoodInspectionBean> filist = new ArrayList<FoodInspectionBean>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
	
		try
		{
			Connection conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("select distinct dba_name,address,city,state,zipcode from dbchicago.food_inspection where zipcode= ");
			query.append("'"+SplChar(element)+"' and location!=''");
			
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				try
				{
					FoodInspectionBean fibobj = new FoodInspectionBean();
					
					fibobj.setRstrntname(rs.getString("dba_name"));
					fibobj.setDupRstname((rs.getString("dba_name")).replace("#", "%23"));
					fibobj.setAddrs(rs.getString("address"));
					fibobj.setCity(rs.getString("city"));
					fibobj.setState(rs.getString("state"));
					fibobj.setZip(rs.getString("zipcode"));
					
					filist.add(fibobj);
				}
				catch(Exception e)
				{
					
					e.printStackTrace();
				}
			}
			st.close();
			conn.close();
		} 
		catch (ClassNotFoundException e)
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
		
		
		return filist;
	} 
	public List<FoodInspectionBean> getDistinctRstInfo(String rname,String adrs,String ct, String stt, String zip)
	{
		List<FoodInspectionBean> filist = new ArrayList<FoodInspectionBean>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		
		try
		{
			Connection conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			StringBuffer query = new StringBuffer();
			
			query.append("select * from dbchicago.food_inspection where ");
			query.append("dba_name ='"+SplChar(rname)+"' ");
			
			query.append(" and zipcode = '"+SplChar(zip)+"' ");
			query.append(" and address= '"+SplChar(adrs)+"' ");
			query.append(" and city = '"+SplChar(ct)+"' ");
			query.append(" and state = '"+SplChar(stt)+"'");

		
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				try
				{
					FoodInspectionBean fibobj = new FoodInspectionBean();
					
					fibobj.setRstrntname(rs.getString("dba_name"));
					fibobj.setLicense(rs.getString("license"));
					fibobj.setRstrnttype(rs.getString("facility_type"));
					fibobj.setRisk(rs.getString("risk"));
					fibobj.setAddrs(rs.getString("address"));
					fibobj.setCity(rs.getString("city"));
					fibobj.setState(rs.getString("state"));
					fibobj.setZip(rs.getString("zipcode"));
					fibobj.setDate(rs.getString("inspection_date"));
					fibobj.setInspectiontype(rs.getString("inspection_type"));
					fibobj.setResult(rs.getString("results"));
					fibobj.setCause(WordUtils.capitalizeFully(rs.getString("violations")).replace("|", "<br/><br/>"));
					fibobj.setLat(Double.parseDouble(rs.getString("latitude")));
					fibobj.setLongi(Double.parseDouble(rs.getString("longitude")));
					
					
					filist.add(fibobj);
				}
				catch(Exception e)
				{
					
					e.printStackTrace();
				}
			}
			st.close();
			conn.close();
		} 
		catch (ClassNotFoundException e)
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
		
		
		return filist;
	}
	
	public List<String> getZipcodeInfo()
	{
		
		List<String> rslt = new ArrayList<String>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		
		try
		{
			Connection conn = (Connection) dbcon.getConnection();
			Statement statement = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			query.append("select distinct zipcode from dbchicago.food_inspection  where  (latitude!='' || longitude!='') && zipcode !='' order by zipcode");
			
			ResultSet rs = statement.executeQuery(query.toString());
			while(rs.next())
			{
				
				rslt.add(rs.getString("zipcode"));
			}
			statement.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return rslt;
	}
	public String SplChar(String string)
	{
		String newString = string.replace("'", "\\'").replace("%", "\\%").replace("&", "\\&");
		return newString;
	}
}
