package jdbc_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@SuppressWarnings("unused")
public class MyDB {
	
		
		private static final String MYSQL_USERNAME = "yourStudentID";
		private static final String MYSQL_PASSWORD = "123456";
		private static final String MYSQL_DATABASE_SERVER = "mysql-user.muc";
		private static final String MYSQL_DATABASE_NAME = "myUniversity";
		
		private static Connection con;
		static String sqlInsert="insert into metropolises " +"VALUES(\"Rostov-on-Don\",\"Europe\",1052000)";
		static String str="select *from metropolises";
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/myUniversity?useSSL=false&serverTimezone=UTC";
				con = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
				System.out.println( "加载驱动成功!" );
				  System.out.println( "连接数据库成功!" );
				  Statement st = con.createStatement();
			        System.out.println( "创建Statement成功!" );
				  
			       
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("student: Update the MySQL constants to correct values!");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.err.println("student: Add the MySQL jar file to your build path!");
			}
		}
		
		public static Connection getConnection() {
			return con;
		}
		
		public static void close() {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public ResultSet sh(ResultSet set) throws SQLException
		{
			 Statement st = con.createStatement();
			set=st.executeQuery( str );
			return set;
		}
		public void ins(String s1,String s2,String s3) throws SQLException
		{
			Statement st = con.createStatement();
			String sp="INSERT INTO metropolises VALUES("+"'"+s1+"'"+","+"'"+s2+"'"+","+"'"+s3+"'"+")";

		        System.out.println("添加新数据成功");
		}
		
		
	}



