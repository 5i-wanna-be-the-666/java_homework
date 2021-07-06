package jdbc_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class MyDB_duo {
	
	ServerSocket ss;
	Socket cltsocket;
	int clientNum=0;

	
		
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
		public MyDB_duo(int s) throws IOException
		{
			try {
       	  	 ss = new ServerSocket(6666); //创建一个Server Socket监听在端口6666 		
       	  	 System.out.println("Server is ready...");
		}catch(IOException e){
			System.err.println("Failed to creat Socket");
			System.exit(1);
		}
   	while(true){
   		try{
   			 cltsocket = ss.accept(); //阻塞的accept()方法接收Client的请求,返回一个Socket对象
   		}catch (IOException e) {
   	    	System.err.println("Accept failed.");
   	    	System.exit(1);
   	    }
   		
		clientNum++;
   		//创建并启动一个线程处理一个Client的请求
   		new MultiServerThread(cltsocket, clientNum).start();  
   	}//end of while
		}
		
		public static void main(String[] args) throws IOException 
		
		{
			int port=6666;
			MyDB_duo k=new MyDB_duo(port);
			 
		}
}




		
