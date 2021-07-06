package java_homework_2_1;

public class IdentifyFormatter {
	String s;
	IdentifyFormatter(String a)
	{
		this.s=a;
	}
	String Identify(String a)//确定字符串全是字母的函数
	{
		char []x;
		int n=a.length();
		int i;
		x=a.toCharArray();
		for(i=0;i<n;i++)
		{
			if(x[i]>='a'&&x[i]<='z' || x[i]>='A'&&x[i]<='Z'||x[i]==' ')
			{
				continue;
			}
			else return "";
		}
		
		return a;
		
	}

}
