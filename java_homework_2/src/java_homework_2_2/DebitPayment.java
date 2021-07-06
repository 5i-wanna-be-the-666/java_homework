package java_homework_2_2;

import java.util.Scanner;

import java_homework_2_2.DebitPayment.pT;
import java.util.Scanner;
@SuppressWarnings("unused")
public class DebitPayment {
	public enum pT{  
		 bank,credit,bankfirst,creditfirst;
	 }//用枚举类型定义
	
	String bankAcct;        //银行账号
	 double bankBalance;      //银行余额
	 String creditCardNum;    //信用卡号
	 double creditLimit;      //信用卡额度
	 pT payType;          //支付类型
	 
	 public DebitPayment()
	 {
		 this.bankAcct="";
		 this.bankBalance=0;
		 this.creditCardNum="";
		 this.creditLimit=50;
		 this.payType=pT.bankfirst;
		 
	 }
	 public DebitPayment(String a,double b,String c,double d,pT e)
	 {
		 this.bankAcct=a;
		 this.bankBalance=b;
		 this.creditCardNum=c;
		 this.creditLimit=d;
		 this.payType=e;
		 
	 }
	 public void gaifu(pT c)//改变支付类型的函数
	 {
		 this.payType=c;
	 }
	 public String toString()
	 {
		 return ("银行信息"+this.bankAcct+"  "+this.bankBalance+"信用卡信息"+this.creditCardNum+"  "+this.creditLimit);
	 }
	 double payMethod(double cost,pT payType)//我不觉得这个方法需要在子类中重写
	 //也就是，我觉得不管哪一种平台都可以支持这四种支付方式中的每一种
	 //因为不管哪一种子类的支付方法都是这四种，我并没有在支付宝里拥有余额宝，在微信里拥有微信钱包之类的
	 //也就是这四种方法就是通用的，都是使用你自己的银行余额和信用卡额度去支付
	 //我并不能理解这个重写，所以我自己在支付宝，京东，银联和微信里各添加一个存钱账户进行重写,比如支付宝余额，京东白条等
	 {
		 //0 第一种方法，使用银行卡优先付费，这也是默认的支付方法 
		 if(payType==pT.bankfirst)
		 {
			 if(this.bankBalance>=cost)
			 {
				 this.bankBalance-=cost;
				 System.out.println("支付成功   银行余额"+this.bankBalance);
	    		 return 1;
			 }
			 else
			 {
				 System.out.println("银行余额不足，即将使用信用卡支付，是否确定？");
				 System.out.println("1：确定  "+"2：取消");
				 int cloose=2;
				 Scanner s=new Scanner(System.in);
				 if(s.hasNextInt())
				 {
					 cloose=s.nextInt();
				 }
				 while(cloose!=1&&cloose!=2)
				 {
					 System.out.println("输入有误请重新输入");
					 cloose=s.nextInt();
				 }
			     s.close();
			     
			     if(cloose==1)
			     {

					
					 
			    	 if(this.creditLimit+this.bankBalance<cost)
			    	 {
			    		 System.out.println("支付失败");
			    		 return 0.0;
			    	 }
			    	 
			    	 else
			    	 {
			    		 cost-=this.bankBalance;//先用已有的银行余额进行支付
						 this.bankBalance=0;
			    		 this.creditLimit-=cost;//再用信用卡支付
			    		 System.out.println("支付成功   信用卡剩余额度"+this.creditLimit);
			    		 return 1;
			    	 }
			     }
			 
				
				 
				 
			 }
		 }
		//第一种方法，使用银行卡优先付费，这也是默认的支付方法 
		 
		 
		 
		 
		 
		 
		//1 第二种方法，使用信用卡优先支付
		 if(payType==pT.creditfirst)
		 {
			 if(this.creditLimit>=cost)
			 {
				 this.creditLimit-=cost;
				 System.out.println("支付成功   信用卡剩余额度"+this.creditLimit);
	    		 return 1;
			 }
			 else
			 {
				 System.out.println("信用卡余额不足，即将使用银行余额支付，是否确定？");
				 System.out.println("1：确定  "+"2：取消");
				 int cloose=2;
				 Scanner s=new Scanner(System.in);
				 if(s.hasNextInt())
				 {
					 cloose=s.nextInt();
				 }
				 while(cloose!=1&&cloose!=2)
				 {
					 System.out.println("输入有误请重新输入");
					 cloose=s.nextInt();
				 }
			     s.close();
			     
			     if(cloose==1)
			     {
			    	 
			    	 if(this.bankBalance+this.creditLimit<cost)
			    	 {
			    		 System.out.println("支付失败");
			    		 return 0.0;
			    	 }
			    	 
			    	 else
			    	 {
			    		 
			    		cost-=this.creditLimit;//先用信用卡支付
			    		 this.creditLimit=0;
			    		 this.bankBalance-=cost;//再用银行余额支付
			    		 System.out.println("支付成功   银行余额"+this.bankBalance);
			    		 return 1;
			    		
			    	 }
			     }
			     
			     if(cloose==2)
			     {
			    	 System.out.println("支付失败");
		    		 return 0.0;
			     }
			    	 
			 
				 
				 
			 }
		 }
		 //第二种方法，使用信用卡优先支付
		 
		 //2 第三种方法，使用银行余额支付
		 if(payType==pT.bank)
		 {
			 if(cost>this.bankBalance)
			 {
				 System.out.println("支付失败");
				 return 0;
			 }
			 
			 this.bankBalance-=cost;//用银行余额支付
			 System.out.println("支付成功   银行余额"+this.bankBalance);
    		 return 1;
    		
		 }
		 
		//第三种方法，使用银行余额支付
		 
		 
		 
		 //3第四种方法，使用信用卡额度支付
		 if(payType==pT.credit)
		 {
			 if(cost>this.creditLimit)
			 {
				 System.out.println("支付失败");
				 return 0;
			 }
			 
			 this.creditLimit-=cost;//用信用卡额度支付
    		 System.out.println("支付成功   信用卡剩余额度"+this.creditLimit);
    		 return 1;
    		
		 }
		 //第四种方法，使用信用卡额度支付
		 return 0.0; 
				
	 }
	
		
	
	
	
}
