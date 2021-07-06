package jdbc_6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@SuppressWarnings("unused")

public class MyDB_noblocking {
	ServerSocket ss;
	Socket cltsocket;
	int clientNum=0;
	private Selector selector;
	
		
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
		
		@SuppressWarnings("unused")
		public void ins(String s1,String s2,String s3) throws SQLException
		{
			
			Statement st = con.createStatement();
			String sp="INSERT INTO metropolises VALUES("+"'"+s1+"'"+","+"'"+s2+"'"+","+"'"+s3+"'"+")";

		        System.out.println("添加新数据成功");
		}
		public void initServer(int port) throws IOException {
			ServerSocketChannel serverChannel = ServerSocketChannel.open();//打开一个Channel
			serverChannel.configureBlocking(false);// 设置通道为非阻塞
			// 将该通道对应的ServerSocket绑定到port端口
			serverChannel.socket().bind(new InetSocketAddress(port));
			this.selector = Selector.open();//打开一个Selector
			//注册通道到Selector，并为该通道注册ACCEPT事件
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		}
		public void listen() throws IOException, SQLException {
			
			System.out.println("Server is running...");
			while (true) {
				// 轮询访问selector
				selector.select(); //选择Channel
			
				
				java.util.Iterator<SelectionKey> ite = this.selector.selectedKeys().iterator();
				
				while (ite.hasNext() )
				{//遍历所有就绪Channel
					SelectionKey key = (SelectionKey) ite.next();
					ite.remove();// 删除已选的key,以防重复处理
					if (key.isAcceptable()) 
					{//ServerSocketChannel接收到一个连接
						ServerSocketChannel server = (ServerSocketChannel) key.channel();
						SocketChannel channel = server.accept();//接受请求
						channel.configureBlocking(false);

						//发送回复给客户
						
						channel.write(ByteBuffer.wrap(new String("添加新数据成功").getBytes()));
					    //给Channel设置可读权限以继续接受请求
						channel.register(this.selector, SelectionKey.OP_READ);
						
						
					}
					
					else if (key.isReadable()) 
					{//Channel进入读模式
						read(key);
							
					}
				}
				
			}
		}
		
		public void read(SelectionKey key) throws IOException, SQLException{
		
			SocketChannel channel = (SocketChannel) key.channel();//返回一个SocketChannel
			ByteBuffer buffer = ByteBuffer.allocate(50);
			channel.read(buffer);
			byte[] data = buffer.array();
			String msg = new String(data).trim();
			int n=msg.length();
			int i=0;
			int k=0;
			while(msg.charAt(i)!=13)
				i++;
			String s1=msg.substring(0,i);
			System.out.println("这是第一段:"+s1);
			i++;
			k=i;
			
			while(msg.charAt(i)!=13)
				i++;
			String s2=msg.substring(k+1,i);
			System.out.println("这是第二段:"+s2);
			i++;
			k=i;
			
			
			String s3=msg.substring(k+1,n);
			System.out.println("这是第三段:"+s3);
			
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					String url = "jdbc:mysql://localhost:3306/myUniversity?useSSL=false&serverTimezone=UTC";
					con = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
					Statement st = con.createStatement();
					String sp="INSERT INTO metropolises(metropolis,continent,population) VALUES("+"'"+s1+"'"+","+"'"+s2+"'"+","+"'"+s3+"'"+")";
					 st.executeUpdate(sp);
					
			        System.out.println("添加新数据成功");
			        
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			System.out.println("Server received msg："+msg);
			ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
			channel.write(outBuffer);//读取客户传递的数据
			channel.close();
			
		}
		public MyDB_noblocking(int s) throws IOException, InterruptedException, SQLException
		{
			//try {
       	 // 	 ss = new ServerSocket(s); //创建一个Server Socket监听在端口6666 		
       	 // 	 System.out.println("Server is ready...");
	//	}catch(IOException e){
	//		System.err.println("Failed to creat Socket");
		//	System.exit(1);
	//	}
			initServer(s);
   
   		Thread.sleep(500);
   		listen();
	
   
		}
		
		@SuppressWarnings("unused")
		public static void main(String[] args) throws IOException, InterruptedException, SQLException 
		
		{
			int port=6666;
			MyDB_noblocking k=new MyDB_noblocking(port);
			 
		}
}
