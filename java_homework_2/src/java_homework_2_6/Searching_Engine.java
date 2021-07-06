package java_homework_2_6;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.math.BigDecimal;

public class Searching_Engine 
{
	int wen_dang_shu;
	String []Vocabulary;
    ju_zhen wen_dang;
    Searching_Engine()
    {
    	this.wen_dang_shu=0;
    	
    	
    }
    public double Three_decimal_places(double f) //保留三位小数的函数
    {
        BigDecimal bg = new BigDecimal(f);
        @SuppressWarnings("deprecation")
		double f1 = bg.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }
  
    
	
	@SuppressWarnings({ "unused", "resource" })
	void creat(Searching_Engine s,String []wen_name) throws IOException
	{
		int i=0;
		FileReader ci = new   FileReader("Vocabulary.txt");//读入流对象
		  BufferedReader oci = new BufferedReader(ci);
		  String str;
		 while((str=(String)oci.readLine())!=null)
		 {
			
			//确定词表中的单词个数，方便下面的各个变量的建立
			 i++;
			
		 }
		
		 FileReader ci2 = new   FileReader("Vocabulary.txt");//读入流对象
		  BufferedReader oci2 = new BufferedReader(ci2);
		 
		int n=wen_name.length;
		int j=0;
		this.wen_dang_shu=n;//文档的数量
	    this.Vocabulary=new String[i];//词表的长度
	    this.wen_dang=new ju_zhen(n,i);//矩阵的新建
		 for(j=0;j<i;j++)
		 {
			 this.Vocabulary[j]=(String)oci2.readLine();//读入了词表
			
		 }
		 
		 
		 
		String yong=new String();//用来暂时储存字符串的
		int wen_wei=0;//记录文档下标的变量
		 for(wen_wei=0;wen_wei<wen_name.length;wen_wei++)
		 {
			 FileReader dang = new FileReader(wen_name[wen_wei]);//读入流对象
			 BufferedReader odang = new  BufferedReader(dang);
			 
			 StringBuilder result=new StringBuilder();
			 while(( yong=odang.readLine())!=null)
			 {
				result.append(yong);
				
				result.append('\n');
			 }
			 
			  yong=result.substring(0,result.length());//读入文件中所有词汇到yong字符串中
			
			    char []use=new char[yong.length()];
			    use=yong.toCharArray();
			   int word_shu=0;
			   for(int u=0;u<use.length;u++)
			   {
				   if(use[u]=='\n')
				   {
					   word_shu++;
				   }
				   if(use[u]==' ')
				   {
					   word_shu++;
					   while(use[u]==' ')//跳过除了第一个之外的空格
						   u++;
					  
				   }
				
			   }//把yong转化为字符数组统计\n也就是单词的数量
			  
			   
			   for(int Vocabulary_wei=0;Vocabulary_wei<this.Vocabulary.length;Vocabulary_wei++)
			   {
				   int wei=-2;
				   int ci_shu=0;
				   String yy=new String();
				   yy=yong;
				   while(wei!=-1 && yy!=null && yy.length()!=0)
					  {
					 
					
						wei=yy.indexOf(this.Vocabulary[Vocabulary_wei]); 
						if(wei!=-1)
						{
							ci_shu++;//找到了就让次数加一
							yy=yy.substring(wei+this.Vocabulary[Vocabulary_wei].length());//跳过现在的这个单词再次检索
						}
						 
						  
					  }
				
				   this.wen_dang.zu[wen_wei+1][Vocabulary_wei+1]=(double)ci_shu/word_shu;//这里确定了矩阵中（i，j）的大小，加一是为了让它从第一行第一列开始，比较好看
				   this.wen_dang.zu[wen_wei+1][Vocabulary_wei+1]=this.Three_decimal_places(this.wen_dang.zu[wen_wei+1][Vocabulary_wei+1]);
			   }
			   
			  
			  
			   
			   
		 }
		 
		
	}
	public void print()//输出存储矩阵的函数
	{
		for(int k=1;k<=this.wen_dang_shu;k++)
		   {
			   for(int p=1;p<=this.Vocabulary.length;p++)
			   {
				   System.out.print(this.wen_dang.zu[k][p]+" ");
			   }
			   System.out.println();
		   }
	}
	
	public String find(String s,String []wen_name)
	{
		 int wei=-2;
		   int ci_shu=0;
		   ju_zhen xiang_liang=new ju_zhen(1,this.Vocabulary.length+1);//行向量
		   double []result=new double [this.Vocabulary.length+1];//存储矩阵向量相乘的结果
		   String yy=new String();
		  
			  
			   for(int Vocabulary_wei=0;Vocabulary_wei<this.Vocabulary.length;Vocabulary_wei++)
			   {
				   ci_shu=0;
				   yy=s;
				   wei=-2;
				   while(wei!=-1 && yy!=null && yy.length()!=0)
					  {
					 
						wei=yy.indexOf(this.Vocabulary[Vocabulary_wei]); 
						if(wei!=-1)
						{
							ci_shu++;//找到了就让次数加一
							yy=yy.substring(wei+this.Vocabulary[Vocabulary_wei].length());//跳过现在的这个单词再次检索
						}
						
						  
					  }
				   xiang_liang.zu[1][Vocabulary_wei+1]=ci_shu;
				 
			   }
			   System.out.println();
		   
		   
		   double sum_hang=0;
		   int return_file_wei=0;//返回文件数组中选定文件的下标
		   double most_close=0;//用来表示最接近搜索的索引项
		   for(int lie_chang=0;lie_chang<wen_name.length;lie_chang++)
		   {
			   sum_hang=0.0;
			   for(int hang_chang=1;hang_chang<=this.Vocabulary.length;hang_chang++)
			   {
				   sum_hang+= xiang_liang.zu[1][hang_chang]*this.wen_dang.zu[lie_chang+1][hang_chang];
			   }
			   result[lie_chang]=this.Three_decimal_places(sum_hang);//结果是行向量与原来的矩阵中存储的数值相乘的结果
			   if(most_close<result[lie_chang])
			   {
				   most_close=result[lie_chang];
				   return_file_wei=lie_chang;
			   }
			 
		   }
		   
		
		return wen_name[return_file_wei];
		
	}
	public static void main(String []arug) throws IOException,	    
	ClassNotFoundException 
	{
		String []wen_name=new String[2];
		wen_name[0]=new String("ofile1.txt");//新建文件名的string数组
		wen_name[1]=new String("ofile2.txt");
		Searching_Engine search=new Searching_Engine();
		search.creat(search,wen_name);//建立基本表的函数
		search.print();
		System.out.println(search.find("green apple blue sky", wen_name));//确定检索内容及检索的函数
		
	
	}

	

}
