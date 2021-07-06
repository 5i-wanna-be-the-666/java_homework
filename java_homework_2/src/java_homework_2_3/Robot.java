package java_homework_2_3;

import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Robot implements Serializable{
	String name;
	float weight;
	int numLegs;
	float powerLevel;
	public Robot(String name,float a,int b,float c) 
	{    
		this.name=name;
		this.weight=a;
		this.numLegs=b;
		this.powerLevel=c;
	}
	public static boolean equals(Object a, Object b) 
	{
        return (a == b) || (a != null && a.equals(b));
    }
	public boolean equals(Object b)//重写的equals
   {
		if(b==this)
		{
		   return true;	
		}
		 if (b == null)
		 {
	            return false;
	      }
		 
		 if(this.getClass()!=b.getClass())
		 {
			 return false;
		 }
		 
		 Robot y=(Robot) b;
		 
		
	   return Robot.equals(name,y.name) && weight==y.weight &&numLegs==y.numLegs&&powerLevel==y.powerLevel;
   }
   public Robot() 
    {
    	this.name="2b";
    	this.weight=(float) 148.8;
    	this.powerLevel=1;
    	this.numLegs=0;
    }
   
		@SuppressWarnings("resource")
		void talk(String phrase)
		{ 
			Scanner sc=new Scanner(System.in);
			int n=0;
			if(this.powerLevel==0)//如果电量不充足就充电
			{
				System.out.println("电量不足无法说话，是否需要充电？");//电量不足就充电
				System.out.println("1:需要  2：不想听");
				while(n!=1&&n!=2)
				{
					n=sc.nextInt();
					if(n!=1&&n!=2)
					{
						System.out.println("请重新输入");
					}
				}
				if(n==1)
				{
					this.charge(2);
				}
				if(n==2)
				{
					return;
				}
				
			}
			
			
			this.powerLevel-=1;
			System.out.println(phrase);//电量充足就说话
		}
			void charge(float amount) 
			{
				this.powerLevel+=amount;
			}
			
			public String toString()
			{
				return("姓名，腿，体重，电量等级"+this.name+" "+this.numLegs+" "+this.weight+" "+this.powerLevel);
			}
    
}
