package jdbc_2;

public class work_thread extends Thread{
	volatile boolean wy=false;
	public void run() 
	{
		
			try {
				sleep(100);
				System.out.println("к╞веак");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	    
	}

}
