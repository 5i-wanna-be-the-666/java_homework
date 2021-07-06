package java_homework_2_2;

import java_homework_2_2.DebitPayment.pT;
import java.util.Scanner;
@SuppressWarnings("unused")

public class JDPay extends DebitPayment {
	String JDAcct;
	double JDbaitiao;
	
	JDPay()
	{
		super();
	}
	
	JDPay(String a,double b,String c,double d,pT e,String f,double o)
	{
		super(a,b,c,d,e);
		this.JDAcct=f;
		this.JDbaitiao=o;
	}
	public String toString()
	 {
		 return ("京东信息"+this.JDAcct+"  "+this.JDbaitiao+"银行信息"+this.bankAcct+"  "+this.bankBalance+"信用卡信息"+this.creditCardNum+"  "+this.creditLimit);
	 }
	double payMethod(double cost,pT payType)
	 {
		 @SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		 int n=0;
		 System.out.println("将优先使用京东余额支付，然后您指定的方法支付");
		 System.out.println("1：确定   2:不需要，我要我选择的方式进行支付");
		 while(n!=1&&n!=2)
		 {
			 System.out.println("请输入:");
			 n=s.nextInt();
			 if(n!=1&&n!=2)
				 System.out.println("输入错误"); 
		 }
		 
		 if(n==1)//确定需要
		 {
			 if(this.JDbaitiao>=cost)
			 {
				 System.out.println("支付成功");
				 this.JDbaitiao-=cost;
				 System.out.println("京东余额为:"+this.JDbaitiao);
				 return 1;
			 }
			 else
			 {
				 cost-=this.JDbaitiao;//优先使用京东余额进行支付
				 this.JDbaitiao=0;
				 super.payMethod(cost,payType);//再按指定方法支付
			 }
		 }
		 
		 if(n==2)//不需要
		 {
			 super.payMethod(cost, payType);
		 }
		 return 0;
	 }

}
