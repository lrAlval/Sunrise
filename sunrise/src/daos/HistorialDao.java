package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import modelos.Historial;
import utility.DBUtility;

public class HistorialDao {
	
	private Connection cn;

	public HistorialDao() {
		cn = DBUtility.getConnection();
	}

	public void addHistorial(Historial h) {
		try {
			
			String query = "insert into historial(IdHistorial, IdEmp, IdCliente, "
			+ "IdHabitacion, FechaEstadia, CargoPorHabitacion, CargoPorTelefono, Notas) values (?, ?, ? , ? , ?, ?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(query);
			// Parameters start with 1
			//ps.setInt(1, user.getUserid());
			ps.setInt(1, h.getIdHistorial());
			ps.setInt(2, h.getIdEmp());
			ps.setInt(3, h.getIdCliente());
			ps.setInt(4, h.getIdHabitacion());
			ps.setString(5, h.getFechaEstadia());
			ps.setDouble(6, h.getCargoPorHabitacion());
			ps.setDouble(7, h.getCargoPorTelefono());
			ps.setString(8, h.getNotas());
			ps.executeUpdate();
			
			System.out.print(" Add Historial \n ");

		} catch (SQLException e) {
			System.out.print("Entrando al Fucking Exception");
			e.printStackTrace();
		}
	}
	
	public void deleteHistorial(int IdHistorial) {
		try {
			PreparedStatement ps = cn.prepareStatement("delete from historial where IdHistorial=?");
			// Parameters start with 1
			ps.setInt(1, IdHistorial);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateHistorial(Historial h) throws ParseException {
		try {
			
			String query = "update historial set IdEmp=?, IdCliente=?,IdHabitacion=? , "
					+ "FechaEstadia = ? , CargoPorHabitacion = ? , CargoPorTelefono = ? , Notas = ?" + 
		                   "where IdHistorial=?";
			PreparedStatement ps = cn.prepareStatement(query);
			// Parameters start with 1
			
			ps.setInt(1, h.getIdEmp());
			ps.setInt(2, h.getIdCliente());
			ps.setInt(3, h.getIdHabitacion());
			ps.setString(4, h.getFechaEstadia());
			ps.setDouble(5, h.getCargoPorHabitacion());
			ps.setDouble(6, h.getCargoPorTelefono());
			ps.setString(7, h.getNotas());
			ps.setInt(8, h.getIdHistorial());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Historial> getAllRooms() {
		List<Historial> historial = new ArrayList<Historial>();
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement.executeQuery("select * from historial");
			while (rs.next()) {
				
				Historial h = new Historial();
				h.setIdHistorial(rs.getInt(1));
				h.setIdEmp(rs.getInt(2));
				h.setIdCliente(rs.getInt(3));
				h.setIdHabitacion(rs.getInt(4));
				h.setFechaEstadia(rs.getString(5));
				h.setCargoPorHabitacion(rs.getDouble(6));
				h.setCargoPorTelefono(rs.getDouble(7));
				h.setNotas(rs.getString(8));
				historial.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		return historial;
	}
	
	
	public List<Historial> getAllRooms(int startPageIndex,int recordsPerPage) {
		List<Historial> historial = new ArrayList<Historial>();
		try {
		
			/*
			 * Limit -> Cantidad de Filas a Obtener
			  Offset -> Posicion en el Array de Filas a Empezar a Obtener la Data
			 */

			
			String query = "select * from historial order by IdHistorial desc LIMIT  " + recordsPerPage + " OFFSET  " + startPageIndex ;

			PreparedStatement ps = cn.prepareStatement(query);
			System.out.println(query);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
								
				Historial h = new Historial();
				h.setIdHistorial(rs.getInt(1));
				h.setIdEmp(rs.getInt(2));
				h.setIdCliente(rs.getInt(3));
				h.setIdHabitacion(rs.getInt(4));
				h.setFechaEstadia(rs.getString(5));
				h.setCargoPorHabitacion(rs.getDouble(6));
				h.setCargoPorTelefono(rs.getDouble(7));
				h.setNotas(rs.getString(8));
				historial.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return historial;
	}
	
	
	
	public int  getTotalRecordCount() {
		int total=0;
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement.executeQuery("select Count(*) from historial");
			if (rs.next())  total=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		return total;
	}
	
	/*public Historial getHabById(int IdHistorial) {
		Historial h = new Historial();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from historial where IdHistorial=?");
			ps.setInt(1, IdHistorial);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				h.setIdHistorial(rs.getInt(1));
				h.setIdEmp(rs.getInt(2));
				h.setIdCliente(rs.getInt(3));
				h.setIdHabitacion(rs.getInt(4));
				h.setFechaEstadia(rs.getString(5));
				h.setCargoPorHabitacion(rs.getDouble(6));
				h.setCargoPorTelefono(rs.getDouble(7));
				h.setNotas(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return h;
	}*/

}



