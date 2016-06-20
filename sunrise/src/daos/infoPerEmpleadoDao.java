package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import libs.gg;
import modelos.horasEmpleado;
import modelos.infoPerEmpleado;
import utility.DBUtility;

public class infoPerEmpleadoDao  extends gg{

	private Connection cn;

	public infoPerEmpleadoDao() {
		cn = DBUtility.getConnection();
	}

	public List<infoPerEmpleado> getInfoPerEmpleado(int idHora) {
		List<infoPerEmpleado> info = new ArrayList<infoPerEmpleado>();
		PreparedStatement ps = null;
		try {
			ps = cn.prepareStatement("{call sp_infoPerEmpleado(?)}");

			ps.setInt(1, idHora);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				infoPerEmpleado in = new infoPerEmpleado();

				/*
				 * # Opcion, Accion, Fecha, Hora Habitacion, Añadio una
				 * Habitacion, 11-06-2016, 11:25:05
				 */

				in.setIdActividad(rs.getInt(1));
				in.setIdHoraEmpleado(rs.getInt(2));
				in.setOpcion(rs.getString(3));
				in.setAccion(rs.getString(4));
				in.setFecha(rs.getString(5));
				in.setHora(rs.getString(6));

				info.add(in);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return info;
	}
	
	
	
	public void addInfoPerEmpleado(String  SessionID,String Op,String Acc) {
		try {
			/*# 
				#  idEmp, SesionID, Fecha, LogInHora, LogOutHora
				1, 1, 0, 2016-06-11, 20:00:00, 21:00:00

			 * */
			
			int idHora = getIDHora(SessionID);
			
			log("IDHora Obtenido ? : " + idHora );
			
			/*
			INSERT INTO `sunrise`.`infoempleados` (`idhorasEmpleados`, `Opcion`, `Accion`, `Fecha`, `Hora`) 
			VALUES ('2', 'asd', 'ds', 'd', 'd');
*/
			
			
			// idhorasEmpleados, Opcion, Accion, Fecha, Hora 
			String query = "insert into infoempleados( idhorasEmpleados , Opcion, Accion, Fecha, Hora) values (? ,? , ?, ? , ?)";
			PreparedStatement ps = cn.prepareStatement(query);
			
			ps.setInt(1,  idHora );
			ps.setString(2, Op);
			ps.setString(3,  Acc);
			ps.setString(4,  MySQLNOWFecha() );
			ps.setString(5,  HoraActual24H() );
			

			ps.executeUpdate();
			
			log("Adding Loggin Info");

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
