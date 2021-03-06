package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entidade.Department;
import model.entidade.Saller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	

	@Override
	public void insert(Saller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Saller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Saller findbyId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
				+	"FROM seller INNER JOIN department "
				+	"ON seller.DepartmentId = department.Id "
				+	"WHERE seller.Id = ?");
			
			st.setInt(1,id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));
				Saller obj = new Saller();
				obj.setId(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setSalaryBase(rs.getDouble("BaseSalary"));
                obj.setBirthDate(rs.getDate("BirthDate"));                
                obj.setDeparttment(dep);
                return obj;
			}
			return null;
		}
		catch (SQLException e ) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Saller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
