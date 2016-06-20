package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.CamaTipo;
import modelos.Habitacion;
import utility.DBUtility;

public class CamaTipoDao {

	private Connection cn;
	
	public CamaTipoDao() {
		cn = DBUtility.getConnection();
	}
	
	
	public List<CamaTipo> getAllCamaTipos() {
		List<CamaTipo> CamaTipos = new ArrayList<CamaTipo>();
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement.executeQuery("select * from CamaTipo");
			while (rs.next()) {
				CamaTipo ct = new CamaTipo();
				ct.setIdCamaTipo(rs.getInt(1));
				ct.setNotas(rs.getString(2));
				CamaTipos.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return CamaTipos;
	}
	
	
	
	
	
	
	
	

}
