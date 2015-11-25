package dbo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import bean.CrimeBean;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CrimeDbo
{
	public List<String> getDistrict(String str)
	{
		List<String> dist = new ArrayList<String>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("select distinct district from dbchicago.crime_data where district like");
			query.append("'%"+str+"%'");
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				dist.add(rs.getString("district"));
				
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return dist;
	}
	
	public List<String> getYear(String str)
	{
		List<String> yr = new ArrayList<String>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("select distinct year from dbchicago.crime_data where district like");
			query.append("'%"+str+"%'");
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				yr.add(rs.getString("year"));
				
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return yr;
	}
	
	public List<String> getBlock(String str)
	{
		List<String> yr = new ArrayList<String>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			StringBuffer query = new StringBuffer();
			query.append("select distinct block from dbchicago.crime_data where block like");
			query.append("'%"+str+"%'");
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				yr.add(rs.getString("block"));
				
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return yr;
	}
	
	public List<CrimeBean> getPieInfo(String ds,String yr)
	{
		List<CrimeBean> distinctcrimecount = new ArrayList<CrimeBean>();
		
	
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			
			StringBuffer dquery = new StringBuffer();
			
			dquery.append("select primary_type, count(*) from dbchicago.crime_data where district=");
			dquery.append("'"+SplChar(ds)+"' and  year='"+SplChar(yr)+"'"+" group by primary_type");
			ResultSet rsdistinct = st.executeQuery(dquery.toString());
			
			while(rsdistinct.next())
			{
				CrimeBean cobj = new CrimeBean();
				cobj.setCrimetype(rsdistinct.getString("primary_type"));
				cobj.setCount(Integer.parseInt((rsdistinct.getString("count(*)"))));
				distinctcrimecount.add(cobj);
			}
			
			
			
			st.close();
			
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		return distinctcrimecount;
	}
	
	
	public List<CrimeBean> getLineChartInfo()
	{
		List<CrimeBean> distinctyearcount = new ArrayList<CrimeBean>();
			
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer dquery = new StringBuffer();
			
			dquery.append("select year, count(*) from dbchicago.crime_data group by year");
			ResultSet rsdistinct = st.executeQuery(dquery.toString());
			
			while(rsdistinct.next())
			{
				CrimeBean cobj= new CrimeBean();
				cobj.setYear(rsdistinct.getString("year"));
				cobj.setCount(Integer.parseInt(rsdistinct.getString("count(*)")));
				distinctyearcount.add(cobj);
			}
			
			
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		return distinctyearcount;
	}
	
	
	public List<CrimeBean> getDYLineChartInfo(String distrct)
	{
		List<CrimeBean> distinctyearcount = new ArrayList<CrimeBean>();
			
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			
			query.append("select year, count(*) from dbchicago.crime_data where district =");
			query.append("'"+SplChar(distrct)+"' group by year");
			ResultSet rsdistinct = st.executeQuery(query.toString());
			
			while(rsdistinct.next())
			{
				CrimeBean cobj= new CrimeBean();
				
				cobj.setYear(rsdistinct.getString("year"));
				cobj.setCount(Integer.parseInt(rsdistinct.getString("count(*)")));
				distinctyearcount.add(cobj);
			}
			
			
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		return distinctyearcount;
	}
	
	
	
	
	public List<CrimeBean> getCrimeDetail(String dist, String yr, String blk)
	{
		List<CrimeBean> crdtl = new ArrayList<CrimeBean>();
		
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			query.append("select * from dbchicago.crime_data where district='");
			query.append(SplChar(dist)+"' and year ='"+SplChar(yr)+"' and block='"+SplChar(blk)+"'");
			System.out.println(query);
			
			ResultSet rs = st.executeQuery(query.toString());
			
			while(rs.next())
			{
				CrimeBean cbobj = new CrimeBean();
				cbobj.setCasenumber(rs.getString("case_number"));
				cbobj.setDate(rs.getString("date"));
				cbobj.setBlock(rs.getString("block"));
				cbobj.setCrimetype(rs.getString("primary_type"));
				cbobj.setCrimedescription(rs.getString("description"));
				cbobj.setLocation(rs.getString("location_description"));
				if(rs.getString("arrest").equalsIgnoreCase("true"))
				{
					cbobj.setArrest("Yes");
				}
				else
				{
					cbobj.setArrest("No");
				}
				
				if(rs.getString("domestic").equalsIgnoreCase("true"))
				{
					cbobj.setDomestic("Yes");
				}
				else
				{
					cbobj.setDomestic("No");
				}
				cbobj.setDistrict(rs.getString("district"));
				cbobj.setWard(rs.getString("ward"));
				cbobj.setCommunity(rs.getString("community_area"));
				cbobj.setYear(rs.getString("year"));
				cbobj.setLat(Double.parseDouble(rs.getString("latitude")));
				cbobj.setLongi(Double.parseDouble(rs.getString("longitude")));
				String hdr = "District: "+dist+" Block: "+yr+" Year :"+blk;
				cbobj.setHeader(hdr);
				
				crdtl.add(cbobj);
			}
			
			
			
			System.out.println("crime dbo getCrimeDetail");
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return crdtl;
	}
	
	public List<String> getDistrictList()
	{
		List<String> distlist = new ArrayList<String>();
		
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			query.append("select distinct district from dbchicago.crime_data where district!='' order by district");
			
			ResultSet rs = st.executeQuery(query.toString());
			
			while(rs.next())
			{
				distlist.add(rs.getString("district"));
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return distlist;
	}
	
	public List<String> getYearList()
	{
		List<String> yrlist = new ArrayList<String>();
		
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			query.append("select distinct year from dbchicago.crime_data order by year");
			
			ResultSet rs = st.executeQuery(query.toString());
			
			while(rs.next())
			{
				CrimeBean cbobj = new CrimeBean();
				
				yrlist.add(rs.getString("year"));
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return yrlist;
	}
	
	
	public List<String> getBlockList(String dist, String yr)
	{
		List<String> blklist = new ArrayList<String>();
		
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			query.append("select distinct block from dbchicago.crime_data where district = ");
			query.append("'"+SplChar(dist)+"' and year = '"+SplChar(yr)+"'");
			System.out.println(query);
			
			ResultSet rs = st.executeQuery(query.toString());
			
			while(rs.next())
			{			
				blklist.add(rs.getString("block"));
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return blklist;
	}
	
	public String SplChar(String string)
	{
		String newString = string.replace("'", "\\'").replace("%", "\\%");
		return newString;
	}
}
