package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;



import utility.DBUtility;
import modelos.Habitacion;
public class HabitacionDao {
	
	private Connection cn;

	public HabitacionDao() {
		cn = DBUtility.getConnection();
	}

	public void addHabitacion(Habitacion h) {
		try {
			
			String query = "insert into Habitacion(IDHabTipo, IdCamaTipo, Precio, IdEstado, Notas) values (?, ?, ? , ? , ?)";
			PreparedStatement ps = cn.prepareStatement(query);
			// Parameters start with 1
			//ps.setInt(1, user.getUserid());
			ps.setInt(1, h.getIDHabTipo());
			ps.setInt(2, h.getIdCamaTipo());
			ps.setDouble(3, h.getPrecio());
			ps.setInt(4, h.getIdEstado());
			ps.setString(5, h.getNotas());
			ps.executeUpdate();
			
			System.out.print("Entrando al Fucking Insert Habitacion");

		} catch (SQLException e) {
			System.out.print("Entrando al Fucking Exception");
			e.printStackTrace();
		}
	}
	
	public void deleteHabitacion(int HabID) {
		try {
			
			String query = "UPDATE habitacion  SET idEstado = 3 where IDHab = ? ";
			PreparedStatement ps = cn.prepareStatement(query);
			
			// Parameters start with 1
			ps.setInt(1, HabID);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateHabitacion(Habitacion h){
		try {
			//IDHab, IDHabTipo, IdCamaTipo, Precio, IdEstado, Notas
			
			String query = "update Habitacion set IDHabTipo=?, IdCamaTipo=? , Precio=? , IdEstado = ? , Notas = ? " +  
			" where IDHab= ? ";
			
			PreparedStatement ps = cn.prepareStatement(query);
			// Parameters start with 1
			
			ps.setInt(1, h.getIDHabTipo());
			ps.setInt(2, h.getIdCamaTipo());
			ps.setDouble(3, h.getPrecio());
			ps.setInt(4, h.getIdEstado());
			ps.setString(5, h.getNotas());
			ps.setInt(6, h.getIDHab());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//llamar en el hijo
	public List<Habitacion> getAllRooms() {
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		try {
			Statement statement = cn.createStatement();
			
			String query =" SELECT H.IDHab , H.IDHabTipo , H.IdCamaTipo , H.Precio , H.IdEstado , T.Notas " +
							" FROM habitacion AS H "+
							" INNER JOIN HabitacionTipo as T "+
							" on h.IDHabTipo = T.IDHabTipo " +
							" where h.idEstado not in (2,3) ";
			
			
			//ResultSet rs = statement.executeQuery("select * from Habitacion where idEstado not in (2,3)");
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				
				//IDHab, IDHabTipo, IdCamaTipo, Precio, IdEstado, Notas
				
				Habitacion h = new Habitacion();
				h.setIDHab(rs.getInt(1));
				h.setIDHabTipo(rs.getInt(2));
				h.setIdCamaTipo(rs.getInt(3));
				h.setPrecio(rs.getDouble(4));
				h.setIdEstado(rs.getInt(5));
				h.setNotas(rs.getString(6));
				habitaciones.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		return habitaciones;
	}
	
	
	public List<Habitacion> getAllRooms(int startPageIndex,int recordsPerPage) {
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		try {
		
			/*
			 * Limit -> Cantidad de Filas a Obtener
			  Offset -> Posicion en el Array de Filas a Empezar a Obtener la Data
			 */

			String query = "select * from Habitacion where idEstado not in (2,3) order by IDHab desc LIMIT  " 
			+ recordsPerPage + " OFFSET  " + startPageIndex ;
			
			
			
			PreparedStatement ps = cn.prepareStatement(query);
			System.out.println(query);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				
				//IDHab, IDHabTipo, IdCamaTipo, Precio, IdEstado, Notas
				
				Habitacion h = new Habitacion();
				h.setIDHab(rs.getInt(1));
				h.setIDHabTipo(rs.getInt(2));
				h.setIdCamaTipo(rs.getInt(3));
				h.setPrecio(rs.getDouble(4));
				h.setIdEstado(rs.getInt(5));
				h.setNotas(rs.getString(6));
				habitaciones.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return habitaciones;
	}
	
	
	
	public int  getTotalRecordCount() {
		int total=0;
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement.executeQuery("select Count(*) from Habitacion where idEstado not in (2,3) ");
			if (rs.next())  total=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		return total;
	}
	
	
	
	
	
	
	
	public Habitacion getHabById(int HabID) {
		Habitacion h = new Habitacion();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from Habitacion where IDHab=?");
			ps.setInt(1, HabID);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				h.setIDHab(rs.getInt(1));
				h.setIDHabTipo(rs.getInt(2));
				h.setIdCamaTipo(rs.getInt(3));
				h.setPrecio(rs.getDouble(4));
				h.setIdEstado(rs.getInt(5));
				h.setNotas(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return h;
	}

}

