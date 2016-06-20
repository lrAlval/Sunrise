package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.CamaTipo;
import modelos.HabitacionEstado;
import utility.DBUtility;

public class HabitacionEstadoDao {

	private Connection cn;
	
	public HabitacionEstadoDao() {
		cn = DBUtility.getConnection();
	}
	
	
	public List<HabitacionEstado> getAllHabitacionEstados() {
		List<HabitacionEstado> Estados = new ArrayList<HabitacionEstado>();
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement.executeQuery("select * from HabitacionEstado");
			while (rs.next()) {
				HabitacionEstado he = new HabitacionEstado();
				he.setIdEstado(rs.getInt(1));	
				he.setNotas(rs.getString(2));
				Estados.add(he);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Estados;
	}

}
