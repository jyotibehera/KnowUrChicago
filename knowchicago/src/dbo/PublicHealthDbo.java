package dbo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EconomicBean;
import bean.InfectBean;
import bean.LeadTestBean;
import bean.MortalityBean;
import bean.NatalityBean;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class PublicHealthDbo
{
	public List<String> getCommunity()
	{
		
		List<String> community = new ArrayList<String>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			query.append("select distinct community_area_name from dbchicago.public_health_stats");
			
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				community.add(rs.getString("community_area_name"));
				
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return community;
		
	}
	
	
	public List<NatalityBean> getNatality(String element)
	{
		
		List<NatalityBean> natalitylist = new ArrayList<NatalityBean>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			query.append("select birth_rate, general_fertility_rate,low_birth_weight,preterm_births,teen_birth_rate from dbchicago.public_health_stats where community_area_name= ");
			query.append("'"+SplChar(element)+"'");
			
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				NatalityBean phobj = new NatalityBean();
				
				phobj.setBirth_rate(rs.getString("birth_rate"));
				phobj.setFertility_rate(rs.getString("general_fertility_rate"));
				phobj.setLow_birth_weight(rs.getString("low_birth_weight"));
				phobj.setPreterm_birth(rs.getString("preterm_births"));
				phobj.setTeen_birth_rate(rs.getString("teen_birth_rate"));
				
				natalitylist.add(phobj);
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return natalitylist;
		
	}
	
	public List<MortalityBean> getMortality(String element)
	{
		
		List<MortalityBean> mortalitylist = new ArrayList<MortalityBean>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			query.append("select assault_homicide,breast_cancer_in_females,cancer_all_sites,colorectal_cancer,diabetes_related,firearm_related,infant_mortality_rate,lung_cancer,prostate_cancer_in_males,stroke_cerebrovascular_disease ");
			query.append("from dbchicago.public_health_stats where community_area_name=");
			query.append("'"+SplChar(element)+"'");
		
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				MortalityBean phobj = new MortalityBean();
				
				phobj.setAssault_homicide(rs.getString("assault_homicide"));
				phobj.setFemale_breastcancer(rs.getString("breast_cancer_in_females"));
				phobj.setAllcancer(rs.getString("cancer_all_sites"));
				phobj.setColorectal_cancer(rs.getString("colorectal_cancer"));
				phobj.setDiabetes(rs.getString("diabetes_related"));
				phobj.setFirearm_related(rs.getString("firearm_related"));
				phobj.setInfant_mortalityrate(rs.getString("infant_mortality_rate"));
				phobj.setLung_cancer(rs.getString("lung_cancer"));
				phobj.setProstate_cancer_male(rs.getString("prostate_cancer_in_males"));
				phobj.setStroke(rs.getString("stroke_cerebrovascular_disease"));
				
				mortalitylist.add(phobj);
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return mortalitylist;
	}
	
	
	public List<LeadTestBean> getLead(String element)
	{
		
		List<LeadTestBean> leadlist = new ArrayList<LeadTestBean>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			query.append("select childhood_blood_lead_level_screening, childhood_lead_poisoning from dbchicago.public_health_stats where community_area_name = ");
			query.append("'"+SplChar(element)+"'");
		
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				LeadTestBean phobj = new LeadTestBean();
				
				phobj.setChildhood_blood_lead_level(rs.getString("childhood_blood_lead_level_screening"));
				phobj.setChildhood_lead_poisoning(rs.getString("childhood_lead_poisoning"));
				
				leadlist.add(phobj);
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return leadlist;
	}
	
	public List<InfectBean> getInfectious(String element)
	{
		
		List<InfectBean> infectlist = new ArrayList<InfectBean>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			query.append("select gonorrhea_in_females,gonorrhea_in_males,tuberculosis from dbchicago.public_health_stats where community_area_name= ");
			query.append("'"+SplChar(element)+"'");
		
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				InfectBean phobj = new InfectBean();
				
				phobj.setMale_gonorrhea(rs.getString("gonorrhea_in_females"));
				phobj.setFemale_gonorrhea(rs.getString("gonorrhea_in_males"));
				phobj.setTb(rs.getString("tuberculosis"));
				
				infectlist.add(phobj);
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return infectlist;
	}
	
	
	public List<EconomicBean> getEconomic(String element)
	{
		
		List<EconomicBean> economiclist = new ArrayList<EconomicBean>();
		JdbcConnectionPool dbcon = new JdbcConnectionPool();
		Connection conn;
		try
		{
			conn = (Connection) dbcon.getConnection();
			Statement st = (Statement) conn.createStatement();
			
			StringBuffer query = new StringBuffer();
			query.append("select below_poverty_level,crowded_housing,dependency,no_high_school_diploma,per_capita_income,unemployment from dbchicago.public_health_stats where community_area_name= ");
			query.append("'"+SplChar(element)+"'");
		
			ResultSet rs = st.executeQuery(query.toString());
			while(rs.next())
			{
				EconomicBean phobj = new EconomicBean();
				
				phobj.setBelow_poverty(rs.getString("below_poverty_level"));
				phobj.setCrowded_housing(rs.getString("crowded_housing"));
				phobj.setDependency(rs.getString("dependency"));
				phobj.setNo_high_school_diploma(rs.getString("no_high_school_diploma"));
				phobj.setPer_capita_income(rs.getString("per_capita_income"));
				phobj.setUnemployment(rs.getString("unemployment"));
				
				economiclist.add(phobj);
			}
			
			st.close();
			conn.close();
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return economiclist;
	}
	public String SplChar(String string)
	{
		String newString = string.replace("'", "\\'").replace("%", "\\%");
		return newString;
	}
}
