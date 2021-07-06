package java_homework_2_1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.font.*;

import javax.swing.JFrame;

import java.applet.*;
@SuppressWarnings({ "unused", "serial" })
public class UppercaseColorFormatter extends JFrame {
	String s;
	UppercaseColorFormatter(String a)
	{
		this.s=a;
	}
	public void UppercaseColor(String a)//显示和染色函数
	{
		
		char []x;
		int n=a.length();
		x=a.toCharArray();
		int i;
		for(i=0;i<n;i++)
		{
			if(x[i]>='a'&&x[i]<='z' || x[i]>='A'&&x[i]<='Z')
			{
				if(x[i]>='a'&&x[i]<='z')
					x[i]-=32;
				
				
			}
			
			
		}
		a=new String(x);
		UppercaseColorFormatter o=new UppercaseColorFormatter(a);
		
		o.setLocation(500, 500);
		o.setTitle("解密");
		o.setSize(300, 300);
		o.setVisible(true);
		Label l=new Label(a);
		Font font=new Font("宋体",Font.BOLD,20);
		l.setFont(font);
		l.setForeground(Color.green);
		o.add(l);
		
		
		
	}

}
