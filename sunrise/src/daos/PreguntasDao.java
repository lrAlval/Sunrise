package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.Preguntas;
import utility.DBUtility;

public class PreguntasDao {
	
	private Connection cn;
	
	public PreguntasDao() {
		cn = DBUtility.getConnection();
	}
	
	
	public List<Preguntas> getAllPreguntas() {
		List<Preguntas> Preguntas = new ArrayList<Preguntas>();
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement.executeQuery("select * from preguntas");
			while (rs.next()) {
				Preguntas p = new Preguntas();
				p.setIdPregunta(rs.getInt(1));
				p.setDescripcion(rs.getString(2));
				Preguntas.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Preguntas;
	}
	public List<Preguntas> getAllPreguntas(int startPageIndex, int recordsPerPage) {
		List<Preguntas> Preguntas = new ArrayList<Preguntas>();
		try {
			String query = "select * from preguntas order by IdPregunta desc LIMIT  "
					+ recordsPerPage + " OFFSET  " + startPageIndex;

			PreparedStatement ps = cn.prepareStatement(query);
			System.out.println(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Preguntas p = new Preguntas();
				p.setIdPregunta(rs.getInt(1));
				p.setDescripcion(rs.getString(2));
				Preguntas.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Preguntas;
	}
	public int getTotalRecordCount() {
		int total = 0;
		try {
			Statement statement = cn.createStatement();
			ResultSet rs = statement
					.executeQuery("select Count(*) from preguntas");
			if (rs.next())
				total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}

}
