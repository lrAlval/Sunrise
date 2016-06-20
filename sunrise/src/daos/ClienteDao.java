package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.Cliente;
import modelos.Empleado;
import modelos.Habitacion;
import utility.DBUtility;

public class ClienteDao {
	private Connection cn;

	public ClienteDao() {
		cn = DBUtility.getConnection();
	}
		

	public void addCliente(Cliente c) {
		try {

			String query = "insert into clientes( Nombre, Apellido, Telefono, Notas) values (?, ?, ? , ? )";
			PreparedStatement ps = cn.prepareStatement(query);

			//ps.setInt(1, c.getIdCliente());
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getApellido());
			ps.setString(3, c.getTelefono());
			ps.setString(4, c.getNotas());
			ps.executeUpdate();

			System.out.print("Entrando al Fucking Insert Cliente");

		} catch (SQLException e) {
			System.out.print("Entrando al Fucking Exception");
			e.printStackTrace();
		}
	}

	public void deleteCliente(int IdCliente) {
		try {
			PreparedStatement ps = cn.prepareStatement("delete from clientes where IdCliente=?");
			
			ps.setInt(1, IdCliente);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCliente(Cliente c) {
		try {
			

			String query = "update clientes set Nombre=?, Apellido=? , Telefono=? , Notas=?" + "where IdCliente=?";
			PreparedStatement ps = cn.prepareStatement(query);

			//ps.setInt(1, c.getIdCliente());
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getApellido());
			ps.setString(3, c.getTelefono());
			ps.setString(4, c.getNotas());
			ps.setInt(5, c.getIdCliente());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> getAllClientes() {
		List<Cliente> Cliente = new ArrayList<Cliente>();
		try {
			Statement statement = cn.createStatement();
			
			ResultSet rs = statement.executeQuery("select IdCliente, Nombre, Apellido, Telefono, Notas from Clientes");
			while (rs.next()) {
				Cliente c = new Cliente();

				c.setIdCliente(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setApellido(rs.getString(3));
				c.setTelefono(rs.getString(4));
				c.setNotas(rs.getString(5));
				Cliente.add(c);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Cliente;
	}

	public List<Cliente> getAllClientes(int startPageIndex, int recordsPerPage) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			String query = "select * from clientes order by IdCliente desc LIMIT  "
					+ recordsPerPage + " OFFSET  " + startPageIndex;

			PreparedStatement ps = cn.prepareStatement(query);
			System.out.println(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Cliente c = new Cliente();
				c.setIdCliente(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setApellido(rs.getString(3));
				c.setTelefono(rs.getString(4));
				c.setNotas(rs.getString(5));
				clientes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clientes;
	}

	public int getTotalRecordCount() {
		int total = 0;
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement
					.executeQuery("select Count(*) from clientes");
			if (rs.next())
				total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}
	
	

}
