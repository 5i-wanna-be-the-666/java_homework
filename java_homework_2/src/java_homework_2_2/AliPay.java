package java_homework_2_2;

import java_homework_2_2.DebitPayment.pT;
import java.util.Scanner;
@SuppressWarnings("unused")
public class AliPay extends DebitPayment {
	
	
	 String AliAcct;       //支付宝账户
	 double AliBalance;
	 public AliPay()
	 {
		 super();
		 this.AliAcct="";
		 this.AliBalance=0;
	 }
	 public String toString()
	 {
		 return ("支付宝信息"+this.AliAcct+"  "+this.AliBalance+"银行信息"+this.bankAcct+"  "+this.bankBalance+"信用卡信息"+this.creditCardNum+"  "+this.creditLimit);
	 }
	 
	 public AliPay(String a,double b,String c,double d,pT e,String f,double o)
	 {
		 super(a,b,c,d,e);
		 this.AliAcct=f;
		 this.AliBalance=o;
	 }
	 double payMethod(double cost,pT payType)
	 {
		 @SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		 int n=0;
		 System.out.println("将优先使用支付宝余额支付，然后您指定的方法支付");
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
			 if(this.AliBalance>=cost)
			 {
				 System.out.println("支付成功");
				 this.AliBalance-=cost;
				 System.out.println("支付宝余额为:"+this.AliBalance);
				 return this.AliBalance;
			 }
			 else
			 {
				 cost-=this.AliBalance;//优先使用支付宝余额进行支付
				 this.AliBalance=0;
				 super.payMethod(cost, payType);//再按指定方法支付
			 }
		 }
		 
		 if(n==2)//不需要
		 {
			 super.payMethod(cost, payType);
		 }
		 return 0;
	 }

}
