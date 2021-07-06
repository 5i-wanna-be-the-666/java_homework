package java_homework_2_3;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



@SuppressWarnings("unused")
public class RobotWorld {
	
	
	boolean RobotLegsComparator(AbstractRobot a,AbstractRobot b)//比较numlegs
	{
		if(a.numLegs>=b.numLegs)
		return true;
		else
			return false;
		
	}
	
	boolean RobotPowerComparator(AbstractRobot a,AbstractRobot b)//比较电量
	{
		if(a.powerLevel>=b.powerLevel)
		return true;
		else
			return false;
		
	}
    
	
	
	@SuppressWarnings("resource")
	public static void main(String []arug) throws IOException,	    
	ClassNotFoundException {
		int i=0;
		List<AbstractRobot> A=new ArrayList<AbstractRobot>();//用的ArrayList存储对象
		
		FileOutputStream os = new FileOutputStream("Robot.txt");//写入文件夹的输出流对象
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		
		    
		
		
		Interface_crudRobot xx=new Interface_crudRobot();//这是管理机器人的对象
		
		AbstractRobot []Ab =new AbstractRobot[7];;//初始化数组
		AbstractRobot C1=new CarrierRobot();
		AbstractRobot T1=new TranslationRobot();
		
		AbstractRobot C2=new CarrierRobot("f*ck",55,9,6);
		AbstractRobot T2=new TranslationRobot("think",88,2,2);
		
		AbstractRobot C3=new CarrierRobot("what",59,15,6);
		AbstractRobot T3=new TranslationRobot("talk",998,2,999);
		
		AbstractRobot C4=new CarrierRobot("wat",9,5,6);//以上是初始化对象
		
		Ab[0]=C1;
		Ab[1]=T1;
		Ab[2]=C2;
		Ab[3]=T2;
		Ab[4]=C3;
		Ab[5]=T3;
		Ab[6]=C4;//向上映射
		
		xx.inser(A,Ab);//xx的将对象数组插入ArrayList中
		
		
		xx.find(A,C1);//查
		xx.update(A,T2,T3);//改
		xx.display(A);//显示
		xx.delete(A,C1);//删
		 
		for(i=0;i<Ab.length;i++)
		oos.writeObject(Ab[i]);//写入文件夹
		
		oos.flush();
	    oos.close();
	    
	    FileInputStream is = new FileInputStream("Robot.txt");//读入流对象
	    ObjectInputStream ois = new ObjectInputStream(is);
	    i=0;
	   for(i=0;i<Ab.length;i++)//读入文件中的对象
	    {
		   Ab[i].greet();
				   try {
				
				    
				    if(i%2!=0)//因为有两个，所以需要分开讨论，我是准备用（getclass）相等的，但是运行起来不行
				    {
				    	TranslationRobot deserialized = (TranslationRobot) ois.readObject();
				    	System.out.println("文件  "+i);
						System.out.println(deserialized.toString());
				    }
				    
				    if(i%2==0)
				    {
				    	CarrierRobot deserialized = (CarrierRobot) ois.readObject();
				    	System.out.println("文件  "+i);
						System.out.println(deserialized.toString());
				    }
				   
				    
				   
				   
				}
				catch(Exception e) {//这里可以防止中间出现问题，直接读完结束
					System.out.println("读取完毕");
		            e.printStackTrace();
		        }
	    	 
	    	
	    		
	    
	    }
	    
	    

		
	}
}
