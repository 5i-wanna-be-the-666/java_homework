package jdbc_6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@SuppressWarnings("unused")
public class MyDB {
	
	ServerSocket ss;
	Socket cs;
		
		private static final String MYSQL_USERNAME = "root";
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
		public void get_inform()
		{
			try{ 
	    		try {
	        	  ss = new ServerSocket(6666); //创建一个ServerSocket监听在端口6666
	    		}catch(IOException e){
	    			System.err.println("Failed to creat Socket");
	    			System.exit(1);
	    		}
	    		System.out.println("Server is ready...");
	    		try{
	        	  cs = ss.accept(); //阻塞的accept()方法随时准备接收来自一个Client的请求，返回一个Socket对象    	 
	    		}catch (IOException e) {
	    			System.err.println("Accept failed.");
	    			System.exit(1);
	    		}
	    		System.out.println("Server is receiving msg from "+ss.getInetAddress()+":"+cs.getPort());
	         
	    		//由Socket对象获得输入流，并创建BufferedReader对象
	            InputStreamReader rs=new InputStreamReader(cs.getInputStream());//打开输入流
	            BufferedReader is=new BufferedReader(rs); 
	          
	            //由Socket对象获得输出流，并创建PrintWriter对象
	            PrintWriter os = new PrintWriter(cs.getOutputStream(),true);
	            
	          
	            
	          //从Socket中读出来自Client的数据并输出到屏幕
	           
	            
	            String []s=new String[3];
	            
	            int i;
	            
	            	
	            	
	            for(i=0;i<3;i++)
	            {
	            	 String line = is.readLine();
	 	            System.out.println("Client msg is:"+line);
	 	            s[i]=line;
	 	          
	 	            
	            }
	            os.println("请求接受完毕");
	            
	            try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					String url = "jdbc:mysql://localhost:3306/myUniversity?useSSL=false&serverTimezone=UTC";
					con = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
					Statement st = con.createStatement();
					String sp="INSERT INTO metropolises(metropolis,continent,population) VALUES("+"'"+s[0]+"'"+","+"'"+s[1]+"'"+","+"'"+s[2]+"'"+")";
					 st.executeUpdate(sp);
					 os.println("添加新数据成功");
			        System.out.println("添加新数据成功");
			        
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
	          
	        	
	        	
					
				 //继续循环
	            is.close(); //关闭输入流
	            os.close(); //关闭输出流
	            cs.close(); //与一个客户通信完毕，关闭Client socket
	            ss.close();//关闭server socket
		
	           
	    	} //
			 catch (IOException ie)
			{
		            ie.printStackTrace();
		    }//接收结束
			
			
		    
		}
		
		public static void main(String[] args) 
		{
			 MyDB k=new MyDB();
			 k.get_inform();
		}
}
		
		
	



