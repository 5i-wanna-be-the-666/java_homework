package jdbc_4;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class SudokuFrame  extends JFrame{
	private JTextField txtPuzzle;
	private JTextField txtSolution;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextPane textPane;
	private JTextPane textPane_1;
	private JTextField txtNowIsSolution;
	
	
	@SuppressWarnings({ "static-access", "unused" })
	public SudokuFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 658);
		setTitle("Sudok solver");
		getContentPane().setLayout(null);
		
		txtPuzzle = new JTextField();
		txtPuzzle.setBackground(new Color(211, 211, 211));
		txtPuzzle.setForeground(Color.DARK_GRAY);
		txtPuzzle.setFont(new Font("宋体", Font.PLAIN, 30));
		txtPuzzle.setText("Puzzle");
		txtPuzzle.setBounds(0, 22, 188, 58);
		getContentPane().add(txtPuzzle);
		txtPuzzle.setColumns(10);
		
		
		
		
		txtSolution = new JTextField();
		txtSolution.setBackground(new Color(220, 220, 220));
		txtSolution.setText("Solutions");
		txtSolution.setFont(new Font("宋体", Font.PLAIN, 30));
		txtSolution.setBounds(417, 22, 169, 58);
		getContentPane().add(txtSolution);
		txtSolution.setColumns(10);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(0, 455, 149, 35);
		getContentPane().add(btnNewButton);
		
		String str=null;//puzzle的字符串
		Sudoku sudoku = null;
		sudoku = new Sudoku();
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Check");
		chckbxNewCheckBox.setFont(new Font("宋体", Font.PLAIN, 20));
		chckbxNewCheckBox.setBounds(157, 455, 149, 34);
		getContentPane().add(chckbxNewCheckBox);
		chckbxNewCheckBox.setSelected(true);
		
		
	
		
		textField_2 = new JTextField();
		textField_2.setBounds(452, 393, 149, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(452, 424, 149, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
		
		textPane = new JTextPane();
		textPane.setFont(new Font("宋体", Font.PLAIN, 20));
		textPane.setBounds(0, 90, 395, 355);
		getContentPane().add(textPane);
		
		 textPane.setText(sudoku.InttoString(sudoku.ff));//这是设置题目的地方，用几个自带的都测试过了
		
		
		
		chckbxNewCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 获取事件源（即复选框本身）
                JCheckBox checkBox = (JCheckBox) e.getSource();
               
                if(checkBox.isSelected())
                {
                	
                			
                	sudoku.textToGrid(textPane.getText());
                }
               
            }
			
        });
		btnNewButton.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
						JButton check=(JButton) e.getSource();
						sudoku.textToGrid(textPane.getText());
						
					}
			
				}
				);
		JButton btnNewButton_1 = new JButton("solut it");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(221, 38, 137, 47);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Next solution\r\n");
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_2.setBounds(607, 38, 137, 42);
		getContentPane().add(btnNewButton_2);
		
		 
		 
		 
		
		textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textPane_1.setBounds(417, 90, 389, 300);
		getContentPane().add(textPane_1);
		
		txtNowIsSolution = new JTextField();
		txtNowIsSolution.setFont(new Font("宋体", Font.PLAIN, 15));
	
		txtNowIsSolution.setBounds(611, 393, 195, 21);
		getContentPane().add(txtNowIsSolution);
		txtNowIsSolution.setColumns(10);
		
		
		int [][] use=new int[9][9];
		 use=sudoku.textToGrid(textPane.getText());;
		 
		 sudoku.set_yong(use);
			
			
			btnNewButton_1.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e) 
						{
							String str1=null;
							Sudoku sudoku = null;
							sudoku = new Sudoku();

							int [][] use=new int[9][9];
							 use=sudoku.textToGrid(textPane.getText());;
							 
							 sudoku.set_yong(use);
								
							
							long start = System.currentTimeMillis();
							
						    sudoku.solve(0);
						    long end = System.currentTimeMillis();
							 sudoku.run_time=end-start;
						    
							 
						    str1=sudoku.jiefa[0];
						    
						    if(sudoku.count==0)
								 str1="此题无解";
						 
						    String slt="Solutions:"+sudoku.count;
						 textField_2.setText(slt);
						 
						 String time="elapsed:"+sudoku.run_time+" ms";
						 textField_3.setText(time);
						txtNowIsSolution.setText("now is solution: 1");
						 textPane_1.setText(str1);
						}
				
					}
			
					);//solut 按钮结束
			
			btnNewButton_2.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent e) 
						{
							String str1=null;
							Sudoku ww = new Sudoku();
						 
							int o=0;
							int k=0;
							 String string=null;
							 string= txtNowIsSolution.getText();
							 for (int i=0; i<string.length(); i++) 
									while(Character.isDigit(string.charAt(i))) 
									{
										
										 o=o*10+Integer.parseInt(string.substring(i, i+1));
										
										 break;
									}
							 txtNowIsSolution.setText("now is solution: "+(o+1));
							 
							int [][] use=new int[9][9];
							 use=ww.textToGrid(textPane.getText());;
							 
							
							 ww.set_yong(use);
							 ww.solve(0);
						
							 
							
						
							 
							
							 if(o<ww.count)
							 {
								 
								 str1=ww.jiefa[o];
								 textPane_1.setText(ww.jiefa[o]);
							 }
							 else 
							 {
								 throw new RuntimeException("this is the last solution");
							 }
								 
							 
							
							
						}
				
					}
					
					);
			
			
			
			
		 
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) { }
		
		SudokuFrame frame = new SudokuFrame();
		frame.setVisible(true);
	}
}
