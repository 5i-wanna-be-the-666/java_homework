package jdbc_5;



public class jiaoyi {

	int pingtai;
	public jiaoyi()
	{
		this.pingtai=0;
	}
	 
	 
	
	 public void zhuan_zhang(zhanghu k1,zhanghu k2)
	 {
		 
			 if(k1.yu_e>=k1.dai_zhuan)
				{
				 k1.flag=true;//设置为正在转账状态
					k1.yu_e-=k1.dai_zhuan;
					pingtai=k1.dai_zhuan;
					k1.dai_zhuan=0;
					
					//System.out.println("收到款项，正在转款");
				}
				else {
					k1.flag=false;//转款结束
					k2.shou=false;
					k1.dai_zhuan=0;
					// System.out.println("余额不足,转款失败");
					 return;
				}
			
				 k2.yu_e+=pingtai;
				 pingtai=0;
				 k1.flag=false;//转款结束
				 k2.shou=false;
				 k1.trans+=1;
				 k2.trans+=1;
				// System.out.println("转款成功");
				 
			 
			 
			 
		 
	 }
}
