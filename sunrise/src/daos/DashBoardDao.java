package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import libs.gg;

import org.json.JSONArray;
import org.json.JSONException;

import utility.DBUtility;

public class DashBoardDao  extends gg{
	
	private Connection cn;
	
	public DashBoardDao() {
		cn = DBUtility.getConnection();
	}

	
	public JSONArray getPagos() {
		JSONArray Pagos = null;
		try {
			ResultSet rs = cn.prepareStatement("SELECT ImportePagar  FROM pagos limit 7").executeQuery();
			Pagos = toJSON(rs);
		} catch (SQLException | JSONException e) {
			e.printStackTrace();
		}

		return Pagos;
	}
	
	
	
	public JSONArray getReservas() {
		JSONArray Reservas = null ;
		try {
			
			ResultSet rs = cn.prepareStatement("{call sp_CantReservasPorMes()}").executeQuery();
			Reservas = toJSON(rs);
		} catch (SQLException | JSONException e) {
			e.printStackTrace();
		}

		return Reservas;
	}
	
	
	
	public JSONArray getEstadias() {
		JSONArray Estadias = null ;
		try {
			
			ResultSet rs = cn.prepareStatement("{call sp_EmpCantEstadias()}").executeQuery();
			Estadias = toJSON(rs);
		} catch (SQLException | JSONException e) {
			e.printStackTrace();
		}

		return Estadias;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
