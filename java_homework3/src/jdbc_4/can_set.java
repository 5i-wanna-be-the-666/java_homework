package jdbc_4;

import java.util.ArrayList;

public class can_set {
	public int x;
	public int y;
	ArrayList<Integer> it_canbe;
	public int keyi;
	public can_set(int xx,int yy)
	{
		this.x=xx;
		this.y=yy;
		 this.it_canbe = new ArrayList<Integer>();
		for (int i=1;i<=9;i++)
		{
			this.it_canbe.add(i);
		}
		this.keyi=9;
		
	}

}
