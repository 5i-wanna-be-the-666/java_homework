package jdbc_3;

public class Reality {
	public static void main(String[] args) 
	{
		jiaoyi tb=new jiaoyi();
		zhanghu daoyan =new zhanghu("daoyan",5000);
		zhanghu yanyuan =new zhanghu("yanyuan",0);
		int jiaoyi_e=2500;
		daoyan.cun(jiaoyi_e);
		daoyan.run();
		daoyan.set_zhuan(jiaoyi_e);
		
		yanyuan.cun(200);
		yanyuan.run();
		yanyuan.set_zhuan(200);
		
		
		ren deadLock1=new ren(true,daoyan,yanyuan,tb);
		ren deadLock2=new ren(false,daoyan,yanyuan,tb);
		Thread t1=new Thread(deadLock1);
		Thread t2=new Thread(deadLock2);
		t1.start();
		t2.start();
	
        

		
	}

}
