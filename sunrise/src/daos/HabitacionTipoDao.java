package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.HabitacionEstado;
import modelos.HabitacionTipo;
import utility.DBUtility;

public class HabitacionTipoDao {
	private Connection cn;
	
	public HabitacionTipoDao() {
		cn = DBUtility.getConnection();
	}
	
	
	public List<HabitacionTipo> getAllHabitacionTipos() {
		List<HabitacionTipo> Tipos = new ArrayList<HabitacionTipo>();
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement.executeQuery("select * from HabitacionTipo");
			while (rs.next()) {
				HabitacionTipo ht = new HabitacionTipo();
				ht.setNotas(rs.getString(2));;
				ht.setIDHabTipo(rs.getInt(1));	
				Tipos.add(ht);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.print("HabitacionesTipo cargo ?" + Tipos.size()+"");

		return Tipos;
	}


}
