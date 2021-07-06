package jdbc_6;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JSeparator;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JProgressBar;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

@SuppressWarnings({ "unused", "serial" })
public class myj extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private static JTable table_1;
	Socket cs;
	PrintWriter os;
	
	
	/**
	 * Launch the application.
	 */
	
	@SuppressWarnings({ })
	
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myj frame = new myj();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		
		
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public myj() throws SQLException {
		MyDB s=new MyDB();
		
		
		
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 519);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Metropolis\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(37, 47, 130, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Continent\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(279, 56, 114, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Population\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(506, 56, 124, 15);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(696, 101, 130, 45);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("search");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(696, 167, 130, 43);
		getContentPane().add(btnNewButton_1);
		
		
		
		
		textField = new JTextField();
		textField.setBounds(156, 53, 97, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
	
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(389, 53, 107, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(615, 53, 142, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JList list = new JList();
		list.setBounds(117, 391, 379, -238);
		getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(742, 220, 1, 1);
		getContentPane().add(list_1);
		
		JLabel lblNewLabel_3 = new JLabel("search options");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(684, 220, 165, 18);
		getContentPane().add(lblNewLabel_3);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(173, 391, 1, 2);
		getContentPane().add(separator);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(681, 248, 218, 23);
		comboBox.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox.setToolTipText("562");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Population Larger Than", "Population Less Than"}));
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(681, 290, 218, 23);
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Exact match", "Partial Match"}));
		getContentPane().add(comboBox_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 62, 2, 2);
		getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(48, 101, 582, 350);
		getContentPane().add(scrollPane_1);
		
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"1s", "w", null},
				{null, "s", "j"},
				{"w", null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Metropolis", "Continent", "Population"
			}
			 
			
		)
				
		{
			Class[] columnTypes = new Class[] {
				Object.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		ResultSet k = null;
		ResultSet set = s.sh(k);//存储数据库元素的集合
		Vector tit=new Vector();//标题
		tit.add("Metropolis");
		tit.add("Continent");
		tit.add("Population");
		
		Vector data = new Vector();//数据库元素
		while(set.next())
		{
			String s1=set.getString("Metropolis");
			String s2=set.getString("Continent");
			String s3=set.getString("Population");
			Vector row = new Vector(); 
			row.add(s1);
			row.add(s2);
			row.add(s3);
			
			data.add(row);
			
			
			
		}
		table_1.setModel(new DefaultTableModel(data,tit) {});//添加到表中
		
		
	
		//按键功能
		btnNewButton.addActionListener(new ActionListener()//这是add的按键功能
		{

			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int n=0;
				String p1=null;
				String p2=null;
				try
				{
				
				
				n=Integer.valueOf(textField_2.getText());
				}
					catch(NumberFormatException exa)
					{
						System.out.println("人口需要是数字");
						throw new NoSuchElementException();
					}
				try
				{
				  p1=String.valueOf(textField.getText());
				  p2=String.valueOf(textField_1.getText());
				 

					String regex1 = ".*[a-zA-z].*";  
					boolean result1 = p1.matches(regex1);
					boolean result2 = p2.matches(regex1);//正则表达式确定必须是字符串
				  if(p1.equals(""))
				  {

						System.out.println("空指针异常");
						throw new NullPointerException();
				  }
				  if(p2.equals(""))
				  {
					  System.out.println("空指针异常");
						throw new NullPointerException();
				  }
				  
				  if(!result1||!result2)
				  {
					  System.out.println("大洲和城市需要是字符串");
						throw new NoSuchElementException();
				  }
				}
				
				
				
				catch(NumberFormatException exa)
				{
					System.out.println("大洲和城市需要是字符串");
					throw new NoSuchElementException();
				}
				
					
					

				
					
				Vector row = new Vector(); 
				row.add(textField.getText());
				row.add(textField_1.getText());
				row.add(textField_2.getText());
				  
			
				
				
				
				
				 try{
				        try{
				        	 cs = new Socket("127.0.0.1",6666);//创建一个Client socket并绑定端口号6666 
				        	 os = new PrintWriter(cs.getOutputStream(),true);//打开输出流
				        }catch (UnknownHostException e1) {
				                System.err.println("Failed to get Server hostname");
				                System.exit(1);
				        } catch (IOException e1) {
				        	System.err.println("Failed to create socket");
				            System.exit(1);
						}

				      //由Socket对象获得输出流，并创建PrintWriter对象
						PrintWriter os=new PrintWriter(cs.getOutputStream());
						
						//由Socket对象获得输入流，并创建BufferedReader对象
						BufferedReader is=new BufferedReader(new InputStreamReader(cs.getInputStream()));
						
					
						os.println(textField.getText());
						os.println(textField_1.getText());
						os.println(textField_2.getText());
						
//						os.println("second");//测试使用
//						os.println("aaaw");
//						os.println("132");
						
						os.flush();
				        System.out.println("Client input:"+textField.getText()+" "+textField_1.getText()+" "+textField_2.getText());
				    
				        String line=is.readLine();
				       // String line="seconde aaaw 132";
				        System.out.println(line);
				       // while(!line.equals("添加新数据成功"+textField.getText()))//运行noblocking的时候需要这个while，前两个是下面那个while
				        while(!line.equals("添加新数据成功"))
				        {
				        	line=is.readLine();
				        }
				        System.out.println(line);
				        
				        
					
				        os.close(); //关闭输出流
				        is.close(); //关闭输入流
				        cs.close(); //关闭 client socket
				        System.out.println("client is closed...");
				      }
				 catch(IOException e1)
				 {
			    	  e1.printStackTrace();
			      }//发送请求结束
				 
				 
				data.add(row);
				
				
				
				
				
				
				table_1.setModel(new DefaultTableModel(data,tit) {});//添加新的一行到表中
				
			}

		}
				);//add按键功能结束
		
		btnNewButton_1.addActionListener(new ActionListener()//search的按键功能
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						ResultSet k = null;
						
						String MYSQL_USERNAME = "yourStudentID";
						String MYSQL_PASSWORD = "123456";
						Connection con = null;
						String url = "jdbc:mysql://localhost:3306/myUniversity?useSSL=false&serverTimezone=UTC";
						
						
						
							try {
								Class.forName("com.mysql.cj.jdbc.Driver");
								con = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
								Statement st = con.createStatement();
								String sp="select *from metropolises ";
								
								//一个或某几个检索项不为空时
								if(!textField.getText().equals(""))
								{
									String tip1="where  metropolis="+"'"+textField.getText()+"'";
									sp=sp+tip1;
								}
								if(!textField_1.getText().equals(""))
								{
									String tip2=null;
									if(comboBox_1.getSelectedItem().equals("Exact match"))//在第二索引不为空的时候确定查找的需求
									{
										if(!textField.getText().equals(""))
										{
											 tip2=" and Continent="+"'"+textField_1.getText()+"'";
										}
										else tip2=" where Continent="+"'"+textField_1.getText()+"'";
										sp=sp+tip2;
									}
									
									if(comboBox_1.getSelectedItem().equals("Partial Match"))//在第二索引不为空的时候确定查找的需求
									{
										if(!textField.getText().equals(""))
										{
											 tip2=" and Continent like "+"'%"+textField_1.getText()+"%'";
										}
										else tip2=" where Continent like "+"'%"+textField_1.getText()+"%'";
										sp=sp+tip2;
									}
								}
								
								if(!textField_2.getText().equals(""))
								{
									String tip3=null;
									
									if(comboBox.getSelectedItem().equals("Population Larger Than"))//在第三索引不为空的时候确定查找的需求
									{
										if(!textField.getText().equals("")||!textField_1.getText().equals(""))
											 tip3=" and population>="+textField_2.getText();
											
											else tip3=" where population>="+textField_2.getText();
											sp=sp+tip3;
									}
									
									if(comboBox.getSelectedItem().equals("Population Less Than"))//在第三索引不为空的时候确定查找的需求
									{
										if(!textField.getText().equals("")||!textField_1.getText().equals(""))
											 tip3=" and population<="+textField_2.getText();
											
											else tip3=" where population<="+textField_2.getText();
											sp=sp+tip3;
									}
								}
								
								
								
						        
						        
								ResultSet set = st.executeQuery(sp);;//存储数据库元素的集合
								Vector tit=new Vector();//标题
								tit.add("Metropolis");
								tit.add("Continent");
								tit.add("Population");
								
								Vector data = new Vector();//数据库元素
								while(set.next())
								{
									String s1=set.getString("Metropolis");
									String s2=set.getString("Continent");
									String s3=set.getString("Population");
									Vector row = new Vector(); 
									row.add(s1);
									row.add(s2);
									row.add(s3);
									
									data.add(row);
									
									
									
								}
								table_1.setModel(new DefaultTableModel(data,tit) {});//添加到表中
								if(data.isEmpty())
									System.out.println("查询不到对应数据!!");
						        
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						
                         
						
						
					}
				}
		);//search功能结束
		
				}
		
	}


