package java_homework_2_2;
import java_homework_2_2.DebitPayment.pT;
import java.util.Scanner;
@SuppressWarnings("unused")
public class MyMobilePayment extends DebitPayment{
	   
	   String number;
	   AliPay Ali;
	   WeChatPay WC;
	   JDPay JD;
	   UnionPay UP;
	   MyMobilePayment()
	   {
		   this.number="";
		   this.Ali=new AliPay();
		   this.WC=new WeChatPay();
		   this.JD=new JDPay();
		   this.UP=new UnionPay();
	   }
	   MyMobilePayment(String haoma,AliPay a,WeChatPay b,JDPay c,UnionPay d)
	   {
		   super(a.bankAcct,a.bankBalance,a.creditCardNum,a.creditLimit,a.payType);
		   this.number=haoma;
		   this.Ali=a;
		   this.WC=b;
		   this.JD=c;
		   this.UP=d;
	   }
	   public String toString()
	   {
		   
		   
		   return ("电话号码"+number+"\n"+super.toString()+"\n支付宝信息:"+this.Ali+"\n京东信息:"+this.JD+"\n微信信息:"+this.WC+"\n银联信息:"+this.UP);
	   }
	   void fuqian(DebitPayment a,double cost,pT payType)//确定使用什么方式付钱，并且统一各个平台的信用卡和银行余额
	   {
		   if(a==this.Ali)
		   {
			   this.bankBalance=this.Ali.bankBalance;
			   this.creditLimit=this.Ali.creditLimit;
			   
			   this.JD.bankBalance=this.bankBalance;
			   this.JD.creditLimit=this.creditLimit;
			   
			   this.WC.bankBalance=this.bankBalance;
			   this.WC.creditLimit=this.creditLimit;
			   
			   this.UP.bankBalance=this.bankBalance;
			   this.UP.creditLimit=this.creditLimit;
		   }
		   
		   if(a==this.JD)
		   {
			   this.JD.payMethod(cost, payType);
			   this.bankBalance=this.JD.bankBalance;
			   this.creditLimit=this.JD.creditLimit;

			   this.WC.bankBalance=this.bankBalance;
			   this.WC.creditLimit=this.creditLimit;
			   
			   this.UP.bankBalance=this.bankBalance;
			   this.UP.creditLimit=this.creditLimit;
			   
			   this.Ali.bankBalance=this.bankBalance;
			   this.Ali.creditLimit=this.creditLimit;
		   }
		   
		   if(a==this.UP)
		   {
			   this.UP.payMethod(cost, payType);
			   this.bankBalance=this.UP.bankBalance;
			   this.creditLimit=this.UP.creditLimit;
			   
			   
			   this.Ali.bankBalance=this.bankBalance;
			   this.Ali.creditLimit=this.creditLimit;
			   
			   this.JD.bankBalance=this.bankBalance;
			   this.JD.creditLimit=this.creditLimit;
			   
			   this.WC.bankBalance=this.bankBalance;
			   this.WC.creditLimit=this.creditLimit;
		   }
		   
		   if(a==this.WC)
		   {
			   this.WC.payMethod(cost, payType);
			   this.bankBalance=this.WC.bankBalance;
			   this.creditLimit=this.WC.creditLimit;
			   
			   this.UP.bankBalance=this.bankBalance;
			   this.UP.creditLimit=this.creditLimit;
			   
			   this.Ali.bankBalance=this.bankBalance;
			   this.Ali.creditLimit=this.creditLimit;
			   
			   this.JD.bankBalance=this.bankBalance;
			   this.JD.creditLimit=this.creditLimit;
		   }
	   }
	   
	   
       public static void main(String[] args)
       {
    	   AliPay a=new AliPay("3355",9568,"7756",100000,pT.bankfirst, "7799", 500);//支付宝设立的银行卡优先
    	   WeChatPay b=new WeChatPay("3355",9568,"7756",100000,pT.bank, "9977", 600);//微信设置的是只能银行卡
    	   JDPay c=new JDPay("3355",9568,"7756",100000,pT.credit, "8597", 700);//京东只能信用卡
    	   UnionPay d=new UnionPay("3355",9568,"7756",100000,pT.creditfirst, "3598", 800);//银联是信用卡优先
    	   
    	   // 上面随便建立了四个对象
    	   MyMobilePayment me=new  MyMobilePayment("19957392890",a,b,c,d);//手机对象
    	   
    	   System.out.println("京东支付情况：");
    	   me.fuqian(c, 9000,c.payType);
    	   System.out.println("支付宝支付情况：");
    	   me.fuqian(a,800,pT.credit);
    	   me.fuqian(b,900,b.payType);
    	   System.out.println(me.toString());
    	  
       }
}
