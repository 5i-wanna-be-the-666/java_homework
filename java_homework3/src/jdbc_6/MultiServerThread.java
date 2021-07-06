package jdbc_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class MultiServerThread extends Thread
{	
	private Socket cs;
	private int cltNum;
	
	
	
	private Connection con;
	private final String MYSQL_USERNAME = "yourStudentID";
 	private	final String MYSQL_PASSWORD = "123456";
	
	public MultiServerThread(Socket socket, int clientNumber)
    {
		this.cs=socket;
		this.cltNum=clientNumber;		
		System.out.println("Accepted Client：" + cltNum); 
    }
	public void run()
	{		
		try{
    		//由Socket对象获得输入流，并创建BufferedReader对象
            InputStreamReader rs;
				rs = new InputStreamReader(cs.getInputStream());	//打开输入流
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
            
		}catch (IOException ie) {
			ie.printStackTrace();
		}
           
	}//end of run
		
   }


