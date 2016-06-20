package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.SessionTrackingMode;

import libs.gg;
import modelos.horasEmpleado;
import utility.DBUtility;

public class HorasEmpleadosDao extends gg {
	private Connection cn;

	public HorasEmpleadosDao() {
		cn = DBUtility.getConnection();
	}
	
	
	public List<horasEmpleado> getHorasEmpleados(String ExceptoNombre) {
		List<horasEmpleado> horas = new ArrayList<horasEmpleado>();
		PreparedStatement ps = null;
		try {

			ps  = cn.prepareStatement("{call sp_GetHorasEmpleados(?)}");
			
			ps.setString(1, ExceptoNombre);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				horasEmpleado he = new horasEmpleado();
				/*
				 * # idHora, Nombre, Apellido, Fecha, LogInHora, LogOutHora
					1, Pedro, Jimenez, 11-06-2016, 20:00:00, 21:00:00

				 * */
				he.setIdHora(rs.getInt(1));
				he.setNombre(rs.getString(2));
				he.setApellido(rs.getString(3));	
				he.setFecha(rs.getString(4));	
				he.setLogInHora(rs.getString(5));
				he.setLogOutHora(rs.getString(6));
				horas.add(he);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return horas;
	}


		public List<horasEmpleado> getHorasEmpleados(String Nombre,String ExceptoNombre) {
		List<horasEmpleado> horas = new ArrayList<horasEmpleado>();
		PreparedStatement ps = null;
		try {
			
			
			
			ps  = cn.prepareStatement("{call sp_GetHorasEmpleadoss(?,?)}");

			ps.setString(1, Nombre);
			ps.setString(2, ExceptoNombre);
			
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				horasEmpleado he = new horasEmpleado();
				
				/*
				 * # idHora, Nombre, Apellido, Fecha, LogInHora, LogOutHora
					1, Pedro, Jimenez, 11-06-2016, 20:00:00, 21:00:00
				 * */
					
				he.setIdHora(rs.getInt(1));
				he.setNombre(rs.getString(2));
				he.setApellido(rs.getString(3));	
				he.setFecha(rs.getString(4));	
				he.setLogInHora(rs.getString(5));
				he.setLogOutHora(rs.getString(6));
				horas.add(he);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return horas;
	}
		
		
		public void addLoginInfo(horasEmpleado he) {
			try {
				/*# 
					#  idEmp, SesionID, Fecha, LogInHora, LogOutHora
					1, 1, 0, 2016-06-11, 20:00:00, 21:00:00

				 * */
				
				String query = "insert into horasEmpleados(idEmp,SesionID, Fecha, LogInHora, LogOutHora) values (?,? , ?, ? , ?)";
				PreparedStatement ps = cn.prepareStatement(query);
				
				
				
				ps.setInt(1, he.getIdEmp());
				ps.setString(2, he.getSessionID());
				/*
				ps.setString(3, he.getFecha() );
				ps.setString(4, he.getLogInHora());
				ps.setString(5, he.getLogOutHora());
				*/
				ps.setString(3, MySQLNOWFecha() );
				ps.setString(4, HoraActual24H());
				ps.setString(5, HoraActual24H());
				

				ps.executeUpdate();
				
				log("Adding Loggin Info");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		public void UpdateLoginInfo(horasEmpleado he) {
			try {
				/*# #  idEmp, SesionID, Fecha, LogInHora, LogOutHora
					1, 1, 0, 2016-06-11, 20:00:00, 21:00:00

				 * */
				
				log("idEmp " + he.getIdEmp());
				log("LogoutHora " + he.getLogOutHora());
				log("Session ID " + he.getSessionID());
				
				String query = "UPDATE  horasEmpleados SET  LogOutHora = ? WHERE idEmp = ? AND SesionID = ? ";
				PreparedStatement ps = cn.prepareStatement(query);
				// Parameters start with 1
				
				ps.setString(1, he.getLogOutHora());
				ps.setInt(2, he.getIdEmp());
				ps.setString(3, he.getSessionID());
			
				ps.executeUpdate();
				
				log("Updating Loggin Info");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		public int getIDHora(String SessionId) {
			int IdHora = 0;
			try {
				log("Session ID Entrante " + SessionId);
				String query = "SELECT idHora from horasempleados where SesionID = ? ";
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setString(1, SessionId);
			
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) IdHora = rs.getInt(1);
				
				log("Getting IdHora:" + IdHora);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return IdHora;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
