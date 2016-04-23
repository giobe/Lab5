package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParolaDao {
	Connection con = DBConnect.getConnection();
	public boolean cerca(String lettere2, int passo){
		
		
		try {
			/*String in="";
			for(int i=0;i<=passo;i++){
				in+=""+lettere2[i];
			}*/
			
			Statement st = con.createStatement();
			String sql = "select nome from parola where nome='"+lettere2+"'";
		    ResultSet res= st.executeQuery(sql);
		    
		    if(res.next()){
		    	return true;
		    }else{
		    	return false;
		    }
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean contiene(String lettere2, int passo){
		
		try {
			/*String in="";
			for(int i=0;i<=passo;i++){
				in+=""+lettere2[i];
			}
			*/
			Statement st = con.createStatement();
			String sql="select nome from parola where nome like '"+lettere2+"%'";
			System.out.println(sql);
			ResultSet res = st.executeQuery(sql);
			if(res.next()){
				return true;
			}else{
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
