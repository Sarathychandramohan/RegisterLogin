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

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static HashMap<String, String> users = Register.getUsers();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        try {
            BufferedReader reader = request.getReader();
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            JSONObject requestData = new JSONObject(stringBuilder.toString());
            String username = requestData.getString("username").trim();
            String password = requestData.getString("password").trim();

            if (users.containsKey(username) && users.get(username).equals(password)) {
                json.put("username", username);
                json.put("password", password);
            }else { 
                json.put("error", "Invalid Username or Password.Try again"); 
            }
        } catch (Exception e) {
            json.put("error", e.getMessage());  
        }

        out.print(json.toString());
        out.flush();
    }
}
