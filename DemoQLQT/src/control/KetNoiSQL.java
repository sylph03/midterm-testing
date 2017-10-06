package control;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiSQL {
	public static Connection con ;
	public static KetNoiSQL instance = new KetNoiSQL();
	public static KetNoiSQL getInstance() {
		return instance;
	}
	public Connection connect()
	{
		final String url="jdbc:sqlserver://localhost:1433;DatabaseName=QuanLyQuayThuoc";
		String user ="sa";
		String pass ="sapassword";
		try 
		{
			con=DriverManager.getConnection(url,user,pass);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public void disconnect() throws SQLException
	{
		if(con != null)
			con.close();
	}

}
