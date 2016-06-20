package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import libs.Read;
import libs.debug;
import libs.gg;
import modelos.Empleado;
import modelos.horasEmpleado;
import utility.DBUtility;



public class EmpleadoDao extends gg {

	private Connection cn;

	public EmpleadoDao() {
		cn = DBUtility.getConnection();
	}

	public List<Empleado> getAllEmpleados() {
		List<Empleado> Empleados = new ArrayList<Empleado>();
		try {
			Statement statement = cn.createStatement();
			//String Query = ;
			ResultSet rs = statement.executeQuery("SELECT *  FROM empleados ");
			while (rs.next()) {
				/*
				 * # IdEmp, Nombre, Apellido, Edad, Cargo, login, pass, idPregunta, respuesta, idEstado, profilepic
					1, Pedro, Jimenez, 35, Jefe de Turno, pjimenez, 123456, 1, gato1, 1, public/profile pics/troll.jpg
*/
				Empleado e = new Empleado();
				
				e.setIdEmp(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setApellido(rs.getString(3));
				e.setEdad(rs.getString(4));
				e.setCargo(rs.getString(5));
				e.setLogin(rs.getString(6));
				e.setPass(rs.getString(7));
				e.setIdPregunta(rs.getInt(8));
				e.setRespuesta(rs.getString(9));
				e.setIdEstado(rs.getInt(10));
				e.setProfilepic(rs.getString(11));
				Empleados.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Empleados;
	}
	
	
	public List<Empleado> getAllEmpleados(int startPageIndex, int recordsPerPage) {
		List<Empleado> Empleados = new ArrayList<Empleado>();
		try {
			String query = "select * from empleados order by IdEmp desc LIMIT  " + recordsPerPage + " OFFSET  " + startPageIndex;

			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				/*# 
					IdEmp, Nombre, Apellido, Edad, Cargo, login, pass, idPregunta, respuesta, idEstado, profilepic
					1, Pedro, Jimenez, 35, Jefe de Turno, pjimenez, 123456, 1, gato1, 1, public/profile pics/troll.jpg

				 * */

				Empleado e = new Empleado();
				e.setIdEmp(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setApellido(rs.getString(3));
				e.setEdad(rs.getString(4));
				
				
				e.setCargo(rs.getString(5));
				e.setLogin(rs.getString(6));
				e.setPass(rs.getString(7));
				e.setIdPregunta(rs.getInt(8));
				e.setRespuesta(rs.getString(9));
				e.setIdEstado(rs.getInt(10));
				e.setProfilepic(rs.getString(11));
				
				
				Empleados.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Empleados;
	}
	
	
	public List<Empleado> getEmpleadosActivos(int startPageIndex, int recordsPerPage) {
		List<Empleado> Empleados = new ArrayList<Empleado>();
		try {
			Statement statement = cn.createStatement();
			//String query = "select * from empleados order by IdEmp desc LIMIT  "  + recordsPerPage + " OFFSET  " + startPageIndex;
			String Query = " SELECT * FROM empleados where idEstado not in(3,2) order by IdEmp desc LIMIT "
			 + recordsPerPage + " OFFSET  " + startPageIndex;
			ResultSet rs = statement.executeQuery(Query);
			while (rs.next()) {
				Empleado e = new Empleado();
				e.setIdEmp(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setApellido(rs.getString(3));
				e.setEdad(rs.getString(4));
				e.setCargo(rs.getString(5));
				e.setLogin(rs.getString(6));
				e.setPass(rs.getString(7));
				e.setIdPregunta(rs.getInt(8));
				e.setRespuesta(rs.getString(9));
				e.setProfilepic(rs.getString(11));
				Empleados.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Empleados;
	}

	
	public List<Empleado> getEmpleadosActivos() {
		List<Empleado> Empleados = new ArrayList<Empleado>();
		try {
			Statement statement = cn.createStatement();
			String Query = "SELECT * FROM empleados where idEstado not in(3,2)";
			ResultSet rs = statement.executeQuery(Query);
			while (rs.next()) {
				Empleado e = new Empleado();
				e.setIdEmp(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setApellido(rs.getString(3));
				e.setEdad(rs.getString(4));
				e.setCargo(rs.getString(5));
				e.setLogin(rs.getString(6));
				e.setPass(rs.getString(7));
				e.setIdPregunta(rs.getInt(8));
				e.setRespuesta(rs.getString(9));
				e.setProfilepic(rs.getString(11));
				Empleados.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Empleados;
	}
	
	
	
	
	
	public void addEmpleado(Empleado e){
		
		try {
			String query="INSERT INTO Empleados(Nombre, Apellido, Edad,Cargo, login, pass , idPregunta, respuesta ,idEstado) "
					+ "VALUES  (?,?,?,?,?,?,?,?)";

			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getApellido());
			ps.setString(3, e.getCargo());
			ps.setString(4, e.getLogin());
			ps.setString(5, e.getPass());
			ps.setInt(6, e.getIdPregunta());
			ps.setString(7, e.getRespuesta());
			ps.setInt(8, e.getIdEstado());
			ps.executeUpdate();
			
			System.out.print("Insert Empleado Dao " + "\n");
			
			
		} catch (SQLException ex) {
			System.out.print("Entrando al Fucking Exception");
			ex.printStackTrace();
		}
		
	}
	
	public void deleteEmpleado(int IdEmp) {
		try {
			PreparedStatement ps = cn.prepareStatement("update empleados set idEstado = 3 where IdEmp = ? ");
			System.out.print("delete EmpleadoDao " + ps + "\n");
			ps.setInt(1, IdEmp);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateEmpleado(Empleado e) {
		try {
			debug d = new debug();

			d.log("Id Emp Entrante "+ e.getIdEmp());
			d.log("Id Estado Entrante "+ e.getIdEstado());
			
			
			String query = " update empleados set Nombre = ?, Apellido = ? , Cargo = ? , " + 
			" login = ? , pass = ? , idPregunta = ? , respuesta = ? , idEstado = ? where IdEmp = ? ";
			
			PreparedStatement ps = cn.prepareStatement(query);
			
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getApellido());
			ps.setString(3, e.getCargo());
			ps.setString(4, e.getLogin());
			ps.setString(5, e.getPass());
			ps.setInt(6, e.getIdPregunta());
			ps.setString(7, e.getRespuesta());
			ps.setInt(8, e.getIdEstado());
			ps.setInt(9, e.getIdEmp());

			ps.executeUpdate();
			
			System.out.print("saliendo el update dao " + " \n");

		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
	}
	

	


	public int getTotalRecordCount() {
		int total = 0;
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement
					.executeQuery("select Count(*) from empleados");
			if (rs.next())
				total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}
	
	public int getTotalRecordCountActivos() {
		int total = 0;
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement
					.executeQuery("select Count(*) from empleados where idEstado not in(3,2)");
			if (rs.next())
				total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}
	
	
	
	// for Login Purpuses
	public Empleado login(String User, String pass) {
		Empleado e = null;
		try {
			//Statement statement = cn.createStatement();
			String Query = "select * from Empleados where login = ? and pass = ? ";
			PreparedStatement ps = cn.prepareStatement(Query);
			ps.setString(1, User);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				/*
				 * # IdEmp, Nombre, Apellido, Edad, Cargo, login, pass, idPregunta, respuesta, idEstado, profilepic
						1, Pedro, Jimenez, 35, Jefe de Turno, pjimenez, 123456, 1, gato1, 1, public/profile pics/troll.jpg
						*/

				e = new Empleado();
				e.setIdEmp(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setApellido(rs.getString(3));
				e.setEdad(rs.getString(4));
				
				e.setCargo(rs.getString(5));
				e.setLogin(rs.getString(6));
				e.setPass(rs.getString(7));
				e.setIdPregunta(rs.getInt(8));
				e.setRespuesta(rs.getString(9));
				e.setProfilepic(rs.getString(11));

			}
			
		} catch (SQLException ex) {
			System.out.println(" Fail en Login Empleado Dao " + ex.getMessage());
		}
		return e ;
	}
	
	
	public String getHorasEmpleado(int idEmp) {
		String Horas = null;
		PreparedStatement ps = null;
		try {
			log("Get Horas Per Empleado: " + idEmp);
			ps  = cn.prepareStatement("{call sp_GetHorasEmpleado(?)}");
			ps.setInt(1, idEmp);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//e.setNombre(rs.getString(1));
				//e.setApellido(rs.getString(2));
				Horas = rs.getString(3);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return Horas;
	}
	

	public String getCantClientes(int idEmp) {
		String CantClientes = null;
		PreparedStatement ps = null;
		try {

			log("Get getCantClientes " + idEmp);
			
			ps  = cn.prepareStatement("{call sp_cantClientes(?)}");
			
			ps.setInt(1, idEmp);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				CantClientes = rs.getString(1);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return CantClientes;
	}
	
	
	public String getCantReservas(int idEmp) {
		String CantReservas = null;
		PreparedStatement ps = null;
		try {

			log("Get getCantReservas: " + idEmp);
			
			ps  = cn.prepareStatement("{call sp_cantReservas(?)}");
			
			ps.setInt(1, idEmp);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
					CantReservas = rs.getString(1);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return CantReservas;
	}
	
	
	
	
	
	
	
	
	
	
	public Boolean Activo(String cod) {
		Boolean flag = false;
		for (Empleado e : getEmpleadosActivos()) {
			if (Read.toString(e.getIdEmp()).equals(cod))
				flag = true;
		}
		return flag;
	}
	

}
