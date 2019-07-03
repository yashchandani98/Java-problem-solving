//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnect{
    private Connection conn;
    Statement st;
    ResultSet rt;

    public DbConnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            st = conn.createStatement();
        }
        catch(Exception e){
            System.err.println(e);
        }
    }

    public ResultSet queryExecutor(String s){
        try{
            rt = st.executeQuery(s);
        }catch(Exception e){}
        finally{
            return rt;
        }
    }

}