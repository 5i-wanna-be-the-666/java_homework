package jdbc_2;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

@SuppressWarnings({ "unused", "serial" })
public class jc extends JPanel implements ActionListener{
	public JTextField textField;//文本域
	public JLabel lblNewLabel;//暂存数字的地方
	public JButton btnNewButton;//开始按钮
	public JButton btnNewButton_1;//暂停按钮
	public work_thread w;//用来执行睡眠的另外一个线程
	public int yong;//用来记录当前数字的变量
	public Timer t;//用来数数和改变线程状态的
	public int time=0;//用来被数的数
	public jc others[];
	
	public void get(jc s,int k)
	{
		
		this.others[k]=new jc();
		this.others[k]=s;
	}
	
	public jc() {
		
		others=new jc[3];
		
		setLayout(null);
		w=new work_thread();
		
		lblNewLabel = new JLabel("0");
		lblNewLabel.setBounds(10, 78, 58, 15);
		add(lblNewLabel);
		
		
		
		 btnNewButton = new JButton("Start");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(0, 113, 122, 36);
		add(btnNewButton);
		btnNewButton.addActionListener(this);
		

		
		 btnNewButton_1 = new JButton("Stop");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(0, 159, 122, 36);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		
		
		textField = new JTextField();
		textField.setBounds(0, 20, 146, 36);
		add(textField);
		textField.setColumns(10);
		
		
		
		
		
		t=new Timer(1, new ActionListener()//这里可以改时间间隔，我是一毫秒运行一次
			{
			
				@Override
				public void actionPerformed (ActionEvent e) 
		{
					
					String start=null;
					int num=0;
					
					num=Integer.valueOf(textField.getText());
				time++;
				
				if(time%1000==0)//这里我怕数字太大了不好看，改成了一千睡眠一次
				{
					w.run();
					start=""+yong;
					lblNewLabel.setText(start);
				}
				if(time>num||w.wy==false)
				{
					t.stop();
					yong=0;
					textField.setText("");
					w.wy=false;
					System.out.println("运行结束");
				}
				
				
				if(time<=num)
				{
					yong=time;
					System.out.println(time);
				}
		} 
				}
				);
				
			
			
		
	}
	
		
		public void actionPerformed (ActionEvent e) 
		{
			// TODO Auto-generated method stub
			
			JButton jk=(JButton)e.getSource();
		
			if(jk==btnNewButton)
			{
				
				int num=0;
				
				try
				{
				    num=Integer.valueOf(textField.getText());
				}
					catch(NumberFormatException exa)
					{
						System.out.println("需要是数字");
						throw new NoSuchElementException();
					}
				
				
				if(!t.isRunning())
				{
					for (int i=0;i<3;i++)
					{
						if(others[i].t.isRunning())
						{
							System.out.println("暂停其运行，自己开始运行");
							others[i].t.stop();
							others[i].btnNewButton.setEnabled(true);
							others[i].yong=0;
						}
					}
					
					time=yong;
					t.start();
				
					
					btnNewButton.setEnabled(false);
					w.wy=true;
					
				}
			}//开始功能键
			
			if(jk==btnNewButton_1)
			{
				if(t.isRunning())
				{
					t.stop();
					w.wy=false;
					btnNewButton.setEnabled(true);
					String start=null;
					
					start=""+yong;
					lblNewLabel.setText(start);
					time=0;
				}
			}//停止功能键
		    
		
		
		
		
	}
private static void createAndShowGUI() { 
	 
}
public static void main(String[] args) {
	
SwingUtilities.invokeLater(new Runnable() {
	public void run() {
						createAndShowGUI(); 
				}
			}); 
		}
	}