package com.kralici.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;


public class DataSourceTest {
public static void main(String[] args) {
		
		DataSource ds = MyDataSourceFactory.getOracleDataSource();
				
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select name, sec from Bunnies21");
			while(rs.next()){
				System.out.println("Bunny="+rs.getString("name")+", Pohlavi="+rs.getString("sex"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}
