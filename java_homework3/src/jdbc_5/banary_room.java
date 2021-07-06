package jdbc_5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class banary_room {
	
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		ArrayBlockingQueue<String> xinxi=new ArrayBlockingQueue(50);
		
		int i=0;
		zhanghu[] zong=new zhanghu[20];//账户的线程
		jiaoyi tb=new jiaoyi();//用来中转的平台
		for(i=0;i<20;i++)
		{
			
			zong[i]=new zhanghu(1000,i+1);
		}
		
		Random r=new Random();//随机数变量
		int hao1=0;
		int hao2=0;
		int qian=0;
		int ci=0;
		
		
	    
	    ci=r.nextInt(5000)+100;
	    FileOutputStream os = new FileOutputStream("消费.txt");//写入文件夹的输出流对象
		
		String str1=" ";
		String str2="\n";
		byte[] b=str1.getBytes();
		byte[] b1=str2.getBytes();
		//转账情况是随机生成的，个数在100-5100之间
		for(i=0;i<=ci;i++)
		{
			hao1=r.nextInt(20)+1;
			hao2=r.nextInt(20)+1;
			while(hao2==hao1)
			{
				 hao2=r.nextInt(20)+1;
			}
		   
		    qian=r.nextInt(999)+1;
		    String x1=""+hao1;
		    String x2=""+hao2;
		    String x3=""+qian;
		    
		    byte[] k1=x1.getBytes();
		    byte[] k2=x2.getBytes();
		    byte[] k3=x3.getBytes();
		    
		    
			os.write(k1);
			
			os.write(b);
			os.write(k2);
			
			os.write(b);
			
			os.write(k3);
			
			os.write(b1);
		}//随机数生成，且写入完毕
		
		
	    
		
		String str=null;
		
		 FileReader ru = new   FileReader("消费.txt");//读入流对象
		  BufferedReader oru = new BufferedReader(ru);
		  
		  
		  String[] jilu=new String[6000];
		  i=0;
		  System.out.println("请输入线程的数量（小于1000）");
		  Scanner sc = new Scanner(System.in); 
		  int shuliang=10;//这个是线程的数量
		  shuliang=sc.nextInt();
		  
		  Thread[] chuli=new Thread[1000];
		  for(int j=0;j<shuliang;j++)
		  {
			  chuli[j]=new Thread(new pass_money(j+1,tb,xinxi,zong));
			  chuli[j].start();
		  }
		  
		  while((str=(String)oru.readLine())!=null)
			 {
		        jilu[i]=new String();
		        jilu[i]=""+str;
		       xinxi.put(str);
		       //System.out.println(str);
		       
		     
		       System.out.println(i);//这个东西表示程序正在运行
				i++;
				
		     }
		  str="-1 0 0";
		  for(int j=0;j<shuliang;j++)
		  xinxi.put(str);
		  
		  for(int j=0;j<20;j++)
			  System.out.println(zong[j].toString());
		  
		  
		  
		  
		  
	}
	
	

	
}
