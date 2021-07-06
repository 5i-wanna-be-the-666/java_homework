package jdbc_5;

import java.util.concurrent.ArrayBlockingQueue;


public class pass_money implements Runnable{
	
	
	static zhanghu o1;//这里必须是静态变量，否则加锁就不是在同一个对象上加锁了
	static zhanghu o2;	
	static zhanghu deng;
	static jiaoyi tb;
	
	int self_hao;
	int currunt_hao1=0;
	int currunt_hao2=0;
	int jiaoyi_e=0;
	
	zhanghu[] bank;
	ArrayBlockingQueue<String> w;
	@SuppressWarnings("static-access")
	public pass_money(int num,jiaoyi kp,ArrayBlockingQueue<String> xinxi,zhanghu[] zong)
	{
		this.self_hao=num;
		this.o1=new zhanghu(0,0);
		this.o2=new zhanghu(0,0);
		this.deng=new zhanghu(0,0);
		this.tb=kp;
		this.w=xinxi;
		this.bank=zong;
	}
	 
	
	public void get_infom(String str)//用来把拿到的字符串变量处理成为能用的变量的函数
	{
		int i=0;
		  char[] shu=str.toCharArray();
		  while(shu[i]!=' ')
		  {
			  this.currunt_hao1=currunt_hao1*10+shu[i]-'0';
			  i++;
		  }
		  
		  
		  i++;
		  while(shu[i]!=' ')
		  {
			  this.currunt_hao2=currunt_hao2*10+shu[i]-'0';
			  i++;
		  }
		  
		  i++;
		  while(i<shu.length)
		  {
			  this.jiaoyi_e=jiaoyi_e*10+shu[i]-'0';
			  i++;
		  }
		 
		 
		  //提取结束
	}
	
	public String toString()
	{
		return ("我是第"+this.self_hao+"线程");
		
	}
	@SuppressWarnings("static-access")
	public void run() {
		
			String str=null;
			
			try {
				while((String)w.take()!="-1 0 0")
				{
					
					str=(String) w.take();
					this.currunt_hao1=0;
					this.currunt_hao2=0;
					this.jiaoyi_e=0;
				    this.get_infom(str);
				    
				    o1=bank[currunt_hao1-1];
				    o2=bank[currunt_hao2-1];
					
				 
				   
				    
				   // System.out.println("读入的账户分别为："+currunt_hao1+" "+currunt_hao2+" "+jiaoyi_e);
				    
				    while(true)
				    {
				    	while(o1.flag||o1.shou||o1.iswaitting)
				    	{
					    	
				    	}
					    this.deng.sleep(this.self_hao*500+50);//这里是为了让某一个线程一定要拿到o1，而别人拿不到，把他们的等待时间设置的不一样，不过会让程序时间比较长
					    
					    if(!(o1.flag||o1.shou||o1.iswaitting))
					    	break;
				    }
				    o1.flag=true;
				    
				    
				   
				 
				   
					synchronized(o1){
						
						//System.out.println("I am"+this.toString()+"I get "+o1.toString());
						   o1.flag=true;
						
						
					while(o2.flag||o2.iswaitting)
						
					{
						//try {
						//	o1.wait();
						//	o1.iswaitting=true;
							
						//} catch (InterruptedException e) {
						//	// TODO Auto-generated catch block
						//	e.printStackTrace();
						//}
					}
					
					o1.iswaitting=false;//不再处于等待状态
					o2.shou=true;
					
					
						synchronized(o2){//要放在o1临界区内，因为要保持o1的锁，申请o2的锁
							
							//System.out.println("I am"+this.toString()+"I also get "+o2.toString()+"and compelete");
							 o1.dai_zhuan=jiaoyi_e;
							tb.zhuan_zhang(o1,o2);
							
						//	if(o2.iswaitting)
							//{
							//	o2.notifyAll();
							//}
						}
					
				
					
				}//o1,o2的锁都释放结束
				}//while 循环结束
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//try结束
			
			//System.out.println("I am"+this.toString()+"I am dead ");
		}
	

}
