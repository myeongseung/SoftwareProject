import java.sql.*;
public class DBConnection{
    public static Connection dbConn;
    public static Connection getConnection() {
        Connection conn = null;
        try{
            String user = "KIOSK";
            String pw = "1234";
            String url = "jdbc:oracle:thin:@localhost:1521/XE";


            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,user,pw);

            //System.out.println("DB에 연결되었습니다");
        }catch (ClassNotFoundException cnfe){
            System.out.println("로딩 실패:"+cnfe.toString());
        }catch (SQLException sqle){
            System.out.println("로딩 실패:"+sqle.toString());
        }catch (Exception e){
            System.out.println("Unknown error");
            e.printStackTrace();
        }
        return conn;
    }
}
