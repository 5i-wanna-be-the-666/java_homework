package jdbc_5;



public class zhanghu extends Thread{
	
	int hao;
	int yu_e;
	int dai_cun;
	int dai_zhuan;
	int trans;
	boolean iswaitting;//标志其是否正在等待
	boolean flag;//标志其是否正在转账
	boolean shou;//标志其是否正在收钱
	
	
	
	public zhanghu(int n,int num)
	{
		
		this.yu_e=n;
		this.hao=num;
		
		this.dai_cun=0;
		this.dai_zhuan=0;
		this.trans=0;
		
		this.flag=false;
		this.iswaitting=false;
		this.shou=false;
	}
	
	public  void cun(int n)
	{
		
		this.dai_cun=n;
	}
	public void set_zhuan(int n)
	{
		this.dai_zhuan=n;
	}
	public String toString()
	{
		return ("账户编号"+this.hao+"账户余额:"+this.yu_e+","+"带存金额:"+this.dai_cun+","+"待转金额:"+this.dai_zhuan+"转账次数"+this.trans);
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			if(this.dai_cun!=0)
			{
				this.yu_e+=this.dai_cun;
				
				System.out.println("存钱成功,"+this.dai_cun);
				this.dai_cun=0;
			}
		
			
		
	}

}

