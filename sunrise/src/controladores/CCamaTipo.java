package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import modelos.CamaTipo;
import modelos.Habitacion;
import daos.CamaTipoDao;
import daos.HabitacionDao;


@WebServlet("/CCamaTipo")
public class CCamaTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CamaTipoDao CamaTipoDao;
       
    
    public CCamaTipo() {
    	CamaTipoDao =new CamaTipoDao();
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getParameter("action")!=null){
			List<CamaTipo> lstCamaTipo=new ArrayList<CamaTipo>();
			String action=(String)req.getParameter("action");
			Gson gson = new Gson();
			res.setContentType("application/json");
			
			
			if(action.equals("list")){
				try{						
				//Fetch Data from Habitacion Table
					lstCamaTipo=CamaTipoDao.getAllCamaTipos();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstCamaTipo, new TypeToken<List<CamaTipo>>() {}.getType());
				
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
