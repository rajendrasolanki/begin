
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends HttpServlet {
            Connection con;
            Statement smt;
            ResultSet rs;
            StringBuilder sb;
            BufferedReader br;
            String str=null;
            String Query;

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","raj");
            smt=con.createStatement();
            sb=new StringBuilder();
            br=request.getReader();
         
            while((str = br.readLine())!=null)
            {
                sb.append(str);
            }
            
            JSONObject obj=new JSONObject(sb.toString());
            String name=obj.getString("name");
            String pass=obj.getString("pass");            
            Query = "select count(*) from user where Uname='"+name+"' and Password='"+pass+"'";
            rs=smt.executeQuery(Query);
            rs.next();
            int count=rs.getInt(1);
            
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(String.valueOf(count));
        } catch (JSONException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}