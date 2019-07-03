import java.sql.ResultSet;

public class Main{
    public static void main(String args[]){
        DbConnect db = new DbConnect();
        ResultSet result;
        try{
            result=db.queryExecutor("SELECT * FROM `test`");
            while(result.next()){
                System.out.println(result.getString(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
            }
        }catch(Exception e){
            System.err.println(e);
        }
    }
}