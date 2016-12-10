
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
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;


public class PDetail extends HttpServlet {
            Connection con;
            Statement smt;
            ResultSet rs;
            String Query;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","raj");
                    smt=con.createStatement();
                    Query="select * from person";
                    rs=smt.executeQuery(Query);
                   
                    JSONArray arr=convertResultSetIntoJSON(rs);
                    JSONObject obj=new JSONObject();
                    obj.put("DATA", arr);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print(obj);
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JSONException ex) {
                    Logger.getLogger(PDetail.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(PDetail.class.getName()).log(Level.SEVERE, null, ex);
                }
}

    public static JSONArray convertResultSetIntoJSON(ResultSet resultSet) throws Exception {
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            JSONObject obj = new JSONObject();
            obj.put("name",resultSet.getString("Name") );
            obj.put("age",resultSet.getString("Age") );
            obj.put("city",resultSet.getString("City") );
            obj.put("id",resultSet.getString("Id") );
            jsonArray.put(obj);
        }
        return jsonArray;
    }

}
