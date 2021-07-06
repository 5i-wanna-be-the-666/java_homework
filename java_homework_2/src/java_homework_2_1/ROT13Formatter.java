package java_homework_2_1;

public class ROT13Formatter {
             
	String s;
	public String jiami(String a)//加密函数
	{
		char []x;
		int n=a.length();
		int i;
		x=a.toCharArray();
		for(i=0;i<n;i++)
		{
			if(x[i]>='a'&&x[i]<='z')
			{
				x[i]+=13;
				if(x[i]>'z')
				{
					x[i]-=26;
				}
				
			}
			if( x[i]>='A'&&x[i]<='Z')
			{
				x[i]+=13;
				if(x[i]>'Z')
				{
					x[i]-=26;
				}
			}
			
		}
		
		a=new String(x);
		return a;
		
	}
	public String jiemi(String a)//解密函数
	{
		char []x;
		int n=a.length();
		int i;
		x=a.toCharArray();
		for(i=0;i<n;i++)
		{
			if(x[i]>='a'&&x[i]<='z' )
			{
				x[i]-=13;
				if(x[i]<'a')
				{
					x[i]+=26;
				}
				
			}
			if( x[i]>='A'&&x[i]<='Z')
			{
				x[i]-=13;
				if(x[i]<'A')
				{
					x[i]+=26;
				}
			}
			
		}
		
		a=new String(x);
		return a;
		
	}
	
}
