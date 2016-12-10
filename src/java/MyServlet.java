 
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
///import org.apache.logging.log4j.LogManager;
import org.json.JSONException;
import org.json.JSONObject;
 
public class MyServlet extends HttpServlet {
 
    //private static final long serialVersionUID = 1L;
    //private static final Logger logger = LogManager.getLogger(MyServlet.class);
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = request.getReader();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            JSONObject jObj = new JSONObject(sb.toString());
            String fname = jObj.getString("fname");
            String lname = jObj.getString("lname");
            
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("hello from java. you entered : " + fname+" "+lname);
        } catch (JSONException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
 
}