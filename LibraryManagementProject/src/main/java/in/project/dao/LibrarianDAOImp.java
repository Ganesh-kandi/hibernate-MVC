package in.project.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.project.model.Librarian;
import in.project.model.ValidateLibrarian;
import in.project.util.JDBCUtil;

public class LibrarianDAOImp implements LibrarianDAO{
	Connection connection = null;

	public String save(Librarian librarian) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteById(int lid) {
		// TODO Auto-generated method stub
		return null;
	}

	public String findById(int lid) {
		String query = "select lname from librarian where lid=?";
		PreparedStatement pstmt =null;
		try {
			connection = JDBCUtil.physicalConnection(); 
			if(connection!=null)
		    {
				pstmt = connection.prepareStatement(query);
				if (pstmt != null) {
					pstmt.setInt(1, lid);
				}
				if (pstmt != null) {
				  ResultSet rs = pstmt.executeQuery();
				  System.out.println(pstmt);
				  rs.next();
					if(rs!=null)
					{
					   return rs.getString("lname");
					}
					
				}
		    }
		}catch(Exception e) {}
				
		return null;
	}

	public int librarianValidate(ValidateLibrarian validateLib) {
String sqlInsertQuery = "Select lid from logindetails where username=? and password=?";
		
		PreparedStatement pstmt = null;
		
	    try {
			connection = JDBCUtil.physicalConnection();
			if(connection!=null)
		    {
				pstmt = connection.prepareStatement(sqlInsertQuery);
				if (pstmt != null) {
					pstmt.setString(1, validateLib.getLusername());
					pstmt.setString(2, validateLib.getLpassword());
				}
				if (pstmt != null) {
				  ResultSet rs = pstmt.executeQuery();
				  System.out.println(pstmt);
				  rs.next();
					if(rs!=null)
					{
					   return rs.getInt(1);
					}
					
				}
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public String librarianValidate1(ValidateLibrarian validateLib) {
		String sqlInsertQuery = "Select password from logindetails where username=?";
				
				PreparedStatement pstmt = null;
				
			    try {
					connection = JDBCUtil.physicalConnection();
					if(connection!=null)
				    {
						pstmt = connection.prepareStatement(sqlInsertQuery);
						if (pstmt != null) {
							pstmt.setString(1, validateLib.getLusername());
						}
						if (pstmt != null) {
						  ResultSet rs = pstmt.executeQuery();
						  System.out.println(pstmt);
						  rs.next();
							if(rs!=null)
							{
							   return rs.getString(1);
							}
							
						}
				    }
				} catch (IOException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
}
