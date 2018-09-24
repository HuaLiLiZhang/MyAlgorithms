package InterviewDirectory.JDBC;


import java.sql.*;

/**
 * Created by huali on 2018/8/24.
 */
public class JDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //加载驱动
        Class.forName("com.mysql.jdbc.driver");  //要导入jar包mysql-connector-java-5.1.18-bin.jar)
        //建立链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306",
                "user", "123")   ;
        //执行SQL语句
        Statement s = conn.createStatement();
        ResultSet result = s.executeQuery("select * FROM text where id = 12");
        while (result.next())
        {
            int id = result.getInt("id");
            String content = result.getString("content");
        }

        conn.close();;
    }
}