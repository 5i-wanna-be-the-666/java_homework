package java_homework_2_6;

public class ju_zhen {
	int hang;
	int lie;
	double [][]zu;
	ju_zhen()
	{
		this.hang=5;
		this.lie=5;
		this.zu=new double[this.hang+1][this.lie+1];
		int i=0,j=0;
		for(i=1;i<=this.hang;i++)
		{
			for(j=1;j<=this.lie;j++)
			{
				this.zu[i][j]=0;
			}
		}
	}
	
	ju_zhen(int a,int b)
	{
		this.hang=a;
		this.lie=b;
		this.zu=new double[this.hang+1][this.lie+1];
		int i=0,j=0;
		for(i=1;i<=this.hang;i++)
		{
			for(j=1;j<=this.lie;j++)
			{
				this.zu[i][j]=0;
			}
		}
	}

}
