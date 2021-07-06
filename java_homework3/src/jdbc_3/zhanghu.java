package jdbc_3;

public class zhanghu implements Runnable{
	String name;
	int hao;
	int yu_e;
	int dai_cun;
	int dai_zhuan;
	int trans;
	boolean flag;//标志其是否正在转账
	public zhanghu(String s,int n)
	{
		this.name=s;
		this.yu_e=n;
		this.dai_cun=0;
		this.dai_zhuan=0;
		this.trans=0;
		
		this.flag=false;
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
		return ("账户名称"+this.name+"账户余额:"+this.yu_e+","+"带存金额:"+this.dai_cun+","+"待转金额:"+this.dai_zhuan);
		
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
