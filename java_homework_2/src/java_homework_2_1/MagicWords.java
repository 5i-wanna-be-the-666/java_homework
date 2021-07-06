package java_homework_2_1;

import java.awt.Graphics;
import java.util.Scanner;

@SuppressWarnings("unused")
public class MagicWords {
	String s;
	IdentifyFormatter a=new IdentifyFormatter(" ");//三个对象的初始化
	UppercaseColorFormatter b=new UppercaseColorFormatter(" ");
	ROT13Formatter c=new ROT13Formatter();
	
	
	void magic()
	{
		
		Scanner scan = new Scanner(System.in);
		String l=new String();
		 System.out.println("请输入字符串：");//输入字符串
	        if (scan.hasNextLine()) {
	          l = scan.nextLine();
	            
	        }
	        
	        
	       
		while((a.Identify(l).equals("")))//检查是否只包含字母和空格
		{
			
			System.out.println("输入有误请重新输入：");
	        l = scan.nextLine();
		}
		scan.close();
		l=c.jiami(l);
		System.out.println("加密字符串："+l);
		l=c.jiemi(l);
		System.out.println("解密字符串："+l);

		b.UppercaseColor(l);//上色的函数，我只能用另一个窗口来输出上色之后的字体
	}
	 
	public static void main(String[] args){
		MagicWords w=new MagicWords();
		w.magic();
	}

}
