package RegisterLogin;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import org.json.JSONObject;

@WebServlet("/register")
public class Register extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	private static HashMap<String,String> users = new HashMap<>();
	
	public static HashMap<String,String> getUsers(){
		return users;
	}
	@Override	
	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		PrintWriter out=response.getWriter();
		JSONObject json = new JSONObject();
		
		try{
			BufferedReader reader = request.getReader();
			StringBuilder stringbuilder=new StringBuilder();
			String line;
			
			while ((line=reader.readLine())!=null){
			stringbuilder.append(line);		
			}		
			
			JSONObject requestData = new JSONObject(stringbuilder.toString());
			String username=requestData.getString("username");
			String password=requestData.getString("password");
		
			users.put(username, password);
			json.put("username",username);
			json.put("password",password);
			}		
		catch(Exception e){
			json.put("Error",e.getMessage());	
		}
		out.print(json.toString());
		out.flush();
	}	


}