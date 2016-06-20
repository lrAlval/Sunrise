package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.HabitacionTipo;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import daos.HabitacionTipoDao;


@WebServlet("/CHabitacionTipo")
public class CHabitacionTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HabitacionTipoDao HabitacionTipoDao;   
    
    public CHabitacionTipo() {
    	HabitacionTipoDao = new HabitacionTipoDao();
      
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getParameter("action")!=null){
			List<HabitacionTipo> lstHabitacionTipo=new ArrayList<HabitacionTipo>();
			String action=(String)req.getParameter("action");
			Gson gson = new Gson();
			res.setContentType("application/json");
			
			
			if(action.equals("list")){
				try{						
				//Fetch Data from Habitacion Table
					lstHabitacionTipo=HabitacionTipoDao.getAllHabitacionTipos();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstHabitacionTipo, new TypeToken<List<HabitacionTipo>>() {}.getType());
				
				JsonArray jsonArray = element.getAsJsonArray();
				
				String listData=jsonArray.toString();				
				//Return Json in the format required by jTable plugin
				listData="{\"Result\":\"OK\",\"Options\":"+listData+"}";
				res.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					res.getWriter().print(error);
					ex.printStackTrace();
				}				
			}
			
			
		}
	}

}
