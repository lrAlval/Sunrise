package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.EmpleadoEstado;
import utility.DBUtility;

public class EmpleadoEstadoDao {

	private Connection cn;

	public EmpleadoEstadoDao() {
		cn = DBUtility.getConnection();
	}

	public List<EmpleadoEstado> getAllEmpleadoEstado() {
		List<EmpleadoEstado> EmpleadoEstado = new ArrayList<EmpleadoEstado>();
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement.executeQuery("select * from EstadoEmpleado");
			while (rs.next()) {
				EmpleadoEstado EE = new EmpleadoEstado();
				EE.setIdEstado(rs.getInt(1));
				EE.setDescEstado(rs.getString(2));
				EmpleadoEstado.add(EE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return EmpleadoEstado;
	}

	public List<EmpleadoEstado> getAllEmpleadoEstado(int startPageIndex,int recordsPerPage) {
		List<EmpleadoEstado> EmpleadoEstado = new ArrayList<EmpleadoEstado>();
		try {
			String query = "select * from EstadoEmpleado order by IdEstado desc LIMIT  "
					+ recordsPerPage + " OFFSET  " + startPageIndex;

			PreparedStatement ps = cn.prepareStatement(query);
			System.out.println(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EmpleadoEstado EE = new EmpleadoEstado();
				EE.setIdEstado(rs.getInt(1));
				EE.setDescEstado(rs.getString(2));
				EmpleadoEstado.add(EE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return EmpleadoEstado;
	}

	public int getTotalRecordCount() {
		int total = 0;
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement
					.executeQuery("select Count(*) from EstadoEmpleado");
			if (rs.next())
				total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}

}
