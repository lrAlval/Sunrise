package libs;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class debug {
   
	public void ListParameters(HttpServletRequest req, HttpServletResponse res){
	    Map params = req.getParameterMap();
	    Iterator i = params.keySet().iterator();
	    while ( i.hasNext() )
	      {
	        String key = (String) i.next();
	        String value = ((String[]) params.get( key ))[ 0 ];
	        System.out.print("Key " + key + " Value " + value + "\n");
	      }
	}
	
	
	public void log(String cd){
		 System.out.print(cd + "\n");
	}
	
	
}
